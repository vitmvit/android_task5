package com.clevertec.task5.api;

import com.clevertec.task5.dto.FilialDto;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface FilialApi {

    @GET("filials_info?")
    Observable<List<FilialDto>> getFilial(@Query("city") String city);
}
