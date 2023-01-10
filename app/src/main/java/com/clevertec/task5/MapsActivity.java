package com.clevertec.task5;

import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.clevertec.task5.api.AtmApiService;
import com.clevertec.task5.api.impl.AtmApiServiceImpl;
import com.clevertec.task5.databinding.ActivityMapsBinding;
import com.clevertec.task5.dto.AtmDto;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        AtmApiService atmAnswer = new AtmApiServiceImpl(this);
        atmAnswer.getAtms(DEFAULT_CITY);
        LatLng gomel = new LatLng(DEFAULT_LATITUDE_COORD, DEFAULT_LONGITUDE_COORD);
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(gomel)
                .zoom(8f)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), null);
        mMap.setTrafficEnabled(true);
    }

    public void addMarkersAtm(List<AtmDto> list) {

        if (list != null && list.size() != 0) {
            for (AtmDto bank : list) {
                mMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(Double.parseDouble(bank.getGpsX()), Double.parseDouble(bank.getGpsY())))
                                .title(bank.getAddressType() + " " + bank.getAddress() + " " + bank.getHouse())
                                .snippet(bank.getInstallPlace())
                );
            }
        } else {
            Toast.makeText(this, NO_ATMS_IN_CITY_ERROR, Toast.LENGTH_SHORT).show();
        }
    }
}