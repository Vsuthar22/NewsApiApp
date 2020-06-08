package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.news.Api.ApiClient;
import com.example.news.models.Adapter;
import com.example.news.models.Articles;
import com.example.news.models.news;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Headlines extends AppCompatActivity {
    final String API_KEY = "3982872f055145ebae0edd5f0bdcbc4f";
    Adapter adapter;
    RecyclerView recyclerView;
    List<Articles> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String country = getCountry();
        retriveJason(country, API_KEY);
    }

    public void retriveJason(String country, String apiKey) {
        Call<news> call = ApiClient.getInstance().getApi().getnews(country, apiKey);
        call.enqueue(new Callback<news>() {
            @Override
            public void onResponse(Call<news> call, Response<news> response) {
                if (response.isSuccessful() && response.body() != null) {
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new Adapter(Headlines.this, articles);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<news> call, Throwable t) {
                Toast.makeText(Headlines.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    public String getCountry() {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }

}

