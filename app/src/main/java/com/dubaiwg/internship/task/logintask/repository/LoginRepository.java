package com.dubaiwg.internship.task.logintask.repository;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import com.dubaiwg.internship.task.logintask.MainActivity;
import com.dubaiwg.internship.task.logintask.R;
import com.dubaiwg.internship.task.logintask.service.LoginBody;
import com.dubaiwg.internship.task.logintask.service.model.LoginResponse;
import com.dubaiwg.internship.task.logintask.service.rest.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.dubaiwg.internship.task.logintask.service.rest.APIClient.getClient;

public class LoginRepository {
    private static final String TAG = LoginRepository.class.getName();
    private APIService apiService;
    private Application application;

    public LoginRepository(Application application) {
        apiService = getClient().create(APIService.class);
        this.application = application;
    }

    public void login(LoginBody loginBody) {
        if (isInternetConnected()) {
            apiService.login(loginBody)
                    .enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful()) {
                                LoginResponse responseBody = response.body();
                                Toast.makeText(application, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                                if (responseBody.isSuccess()) {
                                    Intent in = new Intent(application, MainActivity.class);
                                    application.startActivity(in);

                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.e(TAG, "onFailure: ", t);


                        }
                    });
        } else {
            Toast.makeText(application, application.getString(R.string.internet_connection_error), Toast.LENGTH_SHORT).show();
        }


    }

    private boolean isInternetConnected() {

        ConnectivityManager manager = (ConnectivityManager)
                application.getSystemService(Context.CONNECTIVITY_SERVICE);

        return manager.getActiveNetworkInfo() != null;
    }


}
