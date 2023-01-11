package com.clevertec.task5.api;

import com.clevertec.task5.dto.InfoboxDto;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface InfoboxApi {

    @GET("infobox?")
    Observable<List<InfoboxDto>> getInfobox(@Query("city") String city);
}
