package com.training.myweatherapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TimeAPI {
    @GET("timezone/{area}/{location}")
    Call<TimeResponse> getTime(
            @Path("area") String area,
            @Path("location") String location
    );
}
