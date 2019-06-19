package com.dubaiwg.internship.task.logintask.service.rest;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String BASE_URL = "https://www.yalladealz.com/api/";
    private static Retrofit instance = null;



    public static Retrofit getClient() {
         Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }

        return instance;

    }
}
