package com.dubaiwg.internship.task.logintask.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.dubaiwg.internship.task.logintask.repository.LoginRepository;
import com.dubaiwg.internship.task.logintask.service.LoginBody;

public class LoginViewModel extends AndroidViewModel {
    private LoginRepository repository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = new LoginRepository(application);
    }

    public void login(LoginBody loginBody) {
        repository.login(loginBody);
    }


}
