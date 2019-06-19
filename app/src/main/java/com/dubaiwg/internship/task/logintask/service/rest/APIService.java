package com.dubaiwg.internship.task.logintask.service.rest;

import com.dubaiwg.internship.task.logintask.service.LoginBody;
import com.dubaiwg.internship.task.logintask.service.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("login")
    Call<LoginResponse> login(@Body LoginBody loginBody);
}
