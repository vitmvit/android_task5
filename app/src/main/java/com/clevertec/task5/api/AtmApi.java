package com.clevertec.task5.api;

import com.clevertec.task5.dto.impl.AtmDto;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface AtmApi {

    @GET("atm?")
    Observable<List<AtmDto>> getAtm(@Query("city") String city);
}
