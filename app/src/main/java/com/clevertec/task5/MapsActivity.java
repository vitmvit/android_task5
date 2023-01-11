package com.clevertec.task5;

import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.clevertec.task5.api.service.ApiService;
import com.clevertec.task5.api.service.impl.ApiServiceImpl;
import com.clevertec.task5.databinding.ActivityMapsBinding;
import com.clevertec.task5.dto.ApiData;
import com.clevertec.task5.dto.AtmDto;
import com.clevertec.task5.dto.FilialDto;
import com.clevertec.task5.dto.InfoboxDto;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import static com.clevertec.task5.constants.Constants.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private List<AtmDto> atmDtoList = new ArrayList<>();
    private List<FilialDto> filialDtoList = new ArrayList<>();
    private List<InfoboxDto> infoboxDtoList = new ArrayList<>();

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

    public void setApiDataList(List<? extends ApiData> apiDataList) {
        for (ApiData apiData : apiDataList) {
            if (apiData instanceof AtmDto) {
                atmDtoList.add((AtmDto) apiData);
                addMarkersAtm(atmDtoList);
            } else if (apiData instanceof FilialDto) {
                filialDtoList.add((FilialDto) apiData);
                addMarkersFilial(filialDtoList);
            } else if (apiData instanceof InfoboxDto) {
                infoboxDtoList.add((InfoboxDto) apiData);
                addMarkersInfobox(infoboxDtoList);
            }
        }
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

        LatLng gomel = new LatLng(GOMEL_LATITUDE_COORD, GOMEL_LONGITUDE_COORD);
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(gomel)
                .zoom(9f)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), null);
        mMap.setTrafficEnabled(true);

        ApiService apiService = new ApiServiceImpl(this);
        apiService.getAtms(DEFAULT_CITY);
    }

    public void addMarkersAtm(List<AtmDto> list) {
        if (list != null && list.size() != 0) {
            for (AtmDto bank : list) {
                mMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(Double.parseDouble(bank.getGpsX()), Double.parseDouble(bank.getGpsY())))
                                .title(ATM_TITLE)
                                .snippet(bank.getAddressType() + " " + bank.getAddress() + " " + bank.getHouse())
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_blue))

                );
            }
        } else {
            Toast.makeText(this, NO_ATMS_IN_CITY_ERROR, Toast.LENGTH_SHORT).show();
        }
    }

    public void addMarkersInfobox(List<InfoboxDto> list) {
        if (list != null && list.size() != 0) {
            for (InfoboxDto bank : list) {
                mMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(Double.parseDouble(bank.getGpsX()), Double.parseDouble(bank.getGpsY())))
                                .title(INFOBOX_TITLE)
                                .snippet(bank.getAddressType() + " " + bank.getAddress() + " " + bank.getHouse())
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_orange))
                );
            }
        } else {
            Toast.makeText(this, NO_INFOBOXS_IN_CITY_ERROR, Toast.LENGTH_SHORT).show();
        }
    }

    public void addMarkersFilial(List<FilialDto> list) {
        if (list != null && list.size() != 0) {
            for (FilialDto bank : list) {
                mMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(Double.parseDouble(bank.getGpsX()), Double.parseDouble(bank.getGpsY())))
                                .title(FILIAL_TITLE)
                                .snippet(bank.getStreetType() + " " + bank.getStreet() + " " + bank.getHomeNumber())
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_red))
                );
            }
        } else {
            Toast.makeText(this, NO_FILIALS_IN_CITY_ERROR, Toast.LENGTH_SHORT).show();
        }
    }
}