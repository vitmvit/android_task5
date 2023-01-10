package com.clevertec.task5.api.atm.impl;

import android.widget.Toast;
import com.clevertec.task5.MapsActivity;
import com.clevertec.task5.api.atm.AtmApiProvider;
import com.clevertec.task5.api.atm.AtmApiService;
import com.clevertec.task5.dto.AtmDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Collections;
import java.util.List;

import static com.clevertec.task5.constants.Constants.UNKNOWN_PARSING_DATA_ERROR;

public class AtmApiServiceImpl implements AtmApiService {

    private final MapsActivity mapsActivity;
    private final AtmApiProvider atmApiProvider;

    public AtmApiServiceImpl(MapsActivity mapsActivity) {
        this.mapsActivity = mapsActivity;
        atmApiProvider = new AtmApiProviderImpl();
    }

    public void getAtms(String city) {
        Call<List<AtmDto>> call = atmApiProvider.getAtmApi().getAtm(city);
        call.enqueue(new Callback<List<AtmDto>>() {
            @Override
            public void onResponse(Call<List<AtmDto>> call, Response<List<AtmDto>> response) {
                mapsActivity.addMarkersAtm(
                        response.isSuccessful()
                                ? response.body()
                                : Collections.emptyList()
                );
            }

            @Override
            public void onFailure(Call<List<AtmDto>> call, Throwable t) {
                Toast.makeText(mapsActivity, UNKNOWN_PARSING_DATA_ERROR, Toast.LENGTH_LONG).show();
            }
        });
    }
}
