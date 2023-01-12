package com.clevertec.task5.api.service.impl;

import android.annotation.SuppressLint;
import android.widget.Toast;
import com.clevertec.task5.MapsActivity;
import com.clevertec.task5.api.AtmApi;
import com.clevertec.task5.api.FilialApi;
import com.clevertec.task5.api.InfoboxApi;
import com.clevertec.task5.api.provider.ApiProvider;
import com.clevertec.task5.api.service.ApiService;
import com.clevertec.task5.dto.ApiData;
import com.clevertec.task5.dto.impl.AtmDto;
import com.clevertec.task5.dto.impl.FilialDto;
import com.clevertec.task5.dto.impl.InfoboxDto;
import com.clevertec.task5.model.Markers;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

import static com.clevertec.task5.constants.Constants.*;

public class ApiServiceImpl implements ApiService {

    private final MapsActivity mapsActivity;
    private final AtmApi atmApi;
    private final FilialApi filialApi;
    private final InfoboxApi infoboxApi;

    public ApiServiceImpl(MapsActivity mapsActivity) {
        this.mapsActivity = mapsActivity;
        atmApi = new ApiProvider().getRetrofit(BASE_URL).create(AtmApi.class);
        filialApi = new ApiProvider().getRetrofit(BASE_URL).create(FilialApi.class);
        infoboxApi = new ApiProvider().getRetrofit(BASE_URL).create(InfoboxApi.class);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("UnusedReturnValue")
    public void getAtms(String city) {

        Observable<List<AtmDto>> call1 = atmApi.getAtm(city);
        Observable<List<FilialDto>> call2 = filialApi.getFilial(city);
        Observable<List<InfoboxDto>> call3 = infoboxApi.getInfobox(city);

        Observable.merge(call1, call2, call3)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(List<? extends ApiData> apiDataList) {
        if (apiDataList != null && apiDataList.size() != 0) {
            List<Markers> markers = new ArrayList<>();
            for (ApiData apiData : apiDataList) {

                Markers m = new Markers(typeObject(apiData),
                        ((AtmDto) apiData).getAddressType(),
                        ((AtmDto) apiData).getAddress(),
                        ((AtmDto) apiData).getHouse(),
                        ((AtmDto) apiData).getGpsX(),
                        ((AtmDto) apiData).getGpsY());
                markers.add(m);
            }
            mapsActivity.setApiDataList(markers);
        } else {
            Toast.makeText(mapsActivity, NO_OBJECT_IN_CITY_ERROR, Toast.LENGTH_LONG).show();
        }
    }

    private void handleError(Throwable t) {
        Toast.makeText(mapsActivity, DATA_LOADING_ERROR, Toast.LENGTH_LONG).show();
    }

    private String typeObject(ApiData apiData) {

        if (apiData instanceof AtmDto) {
            return ATM_TITLE;
        } else if (apiData instanceof FilialDto) {
            return FILIAL_TITLE;
        } else if (apiData instanceof InfoboxDto) {
            return INFOBOX_TITLE;
        }
        return DEFAULT_TITLE;
    }
}
