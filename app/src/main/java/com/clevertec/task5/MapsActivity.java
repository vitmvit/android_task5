package com.clevertec.task5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.clevertec.task5.api.service.ApiService;
import com.clevertec.task5.api.service.impl.ApiServiceImpl;
import com.clevertec.task5.databinding.ActivityMapsBinding;
import com.clevertec.task5.model.Markers;
import com.clevertec.task5.util.MarkerSorter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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

        LatLng selectPoint = new LatLng(DEFAULT_LATITUDE_COORD, DEFAULT_LONGITUDE_COORD);

        mMap.setTrafficEnabled(true);
        mMap.addMarker(
                new MarkerOptions()
                        .position(selectPoint)
                        .title(SELECT_TITLE)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_red))
                        .zIndex(1)
        );
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(selectPoint)
                .zoom(14.5f)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), null);

        ApiService apiService = new ApiServiceImpl(this);
        apiService.getAtms(DEFAULT_CITY);
    }

    @SuppressLint("NewApi")
    public void setApiDataList(List<Markers> listMarkers) {
        List<Markers> m = new MarkerSorter().sortMarkersList(listMarkers, DEFAULT_LATITUDE_COORD, DEFAULT_LONGITUDE_COORD);
        addMarkers(m.subList(0, COUNT_MARKERS + 1));
    }

    public void addMarkers(List<Markers> markers) {
        if (markers != null && markers.size() != 0) {
            for (Markers m : markers) {
                mMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(Double.parseDouble(m.getGpsX()), Double.parseDouble(m.getGpsY())))
                                .title(m.getTypeObject())
                                .snippet(m.getAddressType() + " " + m.getAddress() + " " + m.getHouse())
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_orange))

                );
            }
        } else {
            Toast.makeText(this, NO_OBJECT_IN_CITY_ERROR, Toast.LENGTH_SHORT).show();
        }
    }
}