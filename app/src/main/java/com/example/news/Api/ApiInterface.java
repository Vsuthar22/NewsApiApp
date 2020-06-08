package com.example.news.Api;

import com.example.news.models.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<news> getnews(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
