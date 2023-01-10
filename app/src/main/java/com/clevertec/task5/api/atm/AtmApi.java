package com.clevertec.task5.api.atm;

import com.clevertec.task5.dto.AtmDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface AtmApi {

    @GET("atm")
    Call<List<AtmDto>> getAtm();

    @GET("atm?")
    Call<List<AtmDto>> getAtm(@Query("city") String cityId);
}
