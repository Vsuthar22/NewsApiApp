package com.example.news.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    public static ApiClient api = null;
    public static final String BASE_URL = "https://newsapi.org/v2/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiClient getInstance() {
        if (api == null) {
            api = new ApiClient();
        }
        return api;
    }

    public ApiInterface getApi() {
        return retrofit.create(ApiInterface.class);

    }
}
