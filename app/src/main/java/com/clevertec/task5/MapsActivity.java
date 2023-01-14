package com.clevertec.task5;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.clevertec.task5.api.service.ApiService;
import com.clevertec.task5.api.service.impl.ApiServiceImpl;
import com.clevertec.task5.databinding.ActivityMapsBinding;
import com.clevertec.task5.model.Marker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Comparator;
import java.util.List;

import static com.clevertec.task5.constants.Constants.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        ApiService apiService = new ApiServiceImpl(this);
        apiService.getAtms(DEFAULT_CITY);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setApiDataList(List<Marker> markerList) {
        markerList.sort(Comparator.comparing(Marker::getDistance));
        addMarkers(
                markerList.size() < COUNT_MARKERS + 1
                        ? markerList
                        : markerList.subList(0, COUNT_MARKERS + 1)
        );
    }

    public void addMarkers(List<Marker> markerList) {
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLngBounds.Builder boundsBuilder = LatLngBounds.builder();
                LatLng selectPoint = new LatLng(DEFAULT_LATITUDE_COORD, DEFAULT_LONGITUDE_COORD);
                boundsBuilder.include(selectPoint);

                mMap.setTrafficEnabled(true);
                mMap.addMarker(
                        new MarkerOptions()
                                .position(selectPoint)
                                .title(SELECT_TITLE)
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_red))
                                .zIndex(1)
                );

                if ((markerList != null) && (markerList.size() != 0)) {
                    for (Marker m : markerList) {
                        boundsBuilder.include(new LatLng(Double.parseDouble(m.getGpsX()), Double.parseDouble(m.getGpsY())));
                        mMap.addMarker(
                                new MarkerOptions()
                                        .position(new LatLng(Double.parseDouble(m.getGpsX()), Double.parseDouble(m.getGpsY())))
                                        .title(m.getTypeObject())
                                        .snippet(m.getAddressType() + " " + m.getAddress() + " " + m.getHouse())
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_blue))

                        );
                    }
                } else {
                    Toast.makeText(MapsActivity.this, NO_OBJECT_IN_CITY_ERROR, Toast.LENGTH_SHORT).show();
                }

                try {
                    mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 70));
                } catch (Exception e) {
                    Toast.makeText(MapsActivity.this, MAP_RENDERING_ERROR, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}