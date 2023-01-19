package com.clevertec.task5.api.service.impl;

import android.annotation.SuppressLint;
import android.os.Build;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
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
import com.clevertec.task5.model.Marker;
import com.clevertec.task5.util.MarkerUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.clevertec.task5.constants.Constants.*;

public class ApiServiceImpl implements ApiService {

    private final MapsActivity mapsActivity;
    private final AtmApi atmApi;
    private final FilialApi filialApi;
    private final InfoboxApi infoboxApi;
    private final List<Marker> markers = new ArrayList<>();

    public ApiServiceImpl(MapsActivity mapsActivity) {
        this.mapsActivity = mapsActivity;
        atmApi = new ApiProvider().getRetrofit(BASE_URL).create(AtmApi.class);
        filialApi = new ApiProvider().getRetrofit(BASE_URL).create(FilialApi.class);
        infoboxApi = new ApiProvider().getRetrofit(BASE_URL).create(InfoboxApi.class);
    }

    @SuppressLint("CheckResult")
    public void getAtms(String city) {

        Observable<List<AtmDto>> call1 = atmApi.getAtm(city);
        Observable<List<FilialDto>> call2 = filialApi.getFilial(city);
        Observable<List<InfoboxDto>> call3 = infoboxApi.getInfobox(city);

        Observable
                .merge(call1, call2, call3)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<? extends ApiData>>() {

                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull List<? extends ApiData> apiDataList) {
                        for (ApiData apiData : apiDataList) {
                            markers.add(new Marker(
                                    MarkerUtils.getTypeObject(apiData),
                                    MarkerUtils.getAddressType(apiData),
                                    MarkerUtils.getAddress(apiData),
                                    MarkerUtils.getHouse(apiData),
                                    MarkerUtils.getGpsX(apiData),
                                    MarkerUtils.getGpsY(apiData),
                                    MarkerUtils.findDistance(apiData, DEFAULT_LATITUDE_COORD, DEFAULT_LONGITUDE_COORD)
                            ));
                        }
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        Toast.makeText(mapsActivity, DATA_LOADING_ERROR, Toast.LENGTH_LONG).show();
                    }

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onComplete() {
                        mapsActivity.setApiDataList(markers);
                    }
                });
    }
}
