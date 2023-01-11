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
import com.clevertec.task5.dto.AtmDto;
import com.clevertec.task5.dto.FilialDto;
import com.clevertec.task5.dto.InfoboxDto;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class ApiServiceImpl implements ApiService {

    private final MapsActivity mapsActivity;
    private final AtmApi atmApi;
    private final FilialApi filialApi;
    private final InfoboxApi infoboxApi;

    public ApiServiceImpl(MapsActivity mapsActivity) {
        this.mapsActivity = mapsActivity;
        atmApi = new ApiProvider().getRetrofit("https://belarusbank.by/api/").create(AtmApi.class);
        filialApi = new ApiProvider().getRetrofit("https://belarusbank.by/api/").create(FilialApi.class);
        infoboxApi = new ApiProvider().getRetrofit("https://belarusbank.by/api/").create(InfoboxApi.class);
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

    private void handleResults(List<? extends ApiData> list) {
        if (list != null && list.size() != 0) {
            mapsActivity.setApiDataList(list);
        } else {
            Toast.makeText(mapsActivity, "NO RESULTS FOUND", Toast.LENGTH_LONG).show();
        }
    }

    private void handleError(Throwable t) {
        Toast.makeText(mapsActivity, "ERROR IN FETCHING API RESPONSE. Try again", Toast.LENGTH_LONG).show();
    }
}
