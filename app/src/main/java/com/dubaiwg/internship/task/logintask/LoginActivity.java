package com.dubaiwg.internship.task.logintask;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.dubaiwg.internship.task.logintask.service.LoginBody;
import com.dubaiwg.internship.task.logintask.viewmodel.LoginViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_password)
    EditText inputPassword;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @OnClick(R.id.btn_login)
    public void login() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        if (email.isEmpty()){
            inputEmail.setError(getString(R.string.email_error));
            return;
        }

        if (password.isEmpty()){
            inputPassword.setError(getString(R.string.password_error));
            return;
        }

        LoginBody loginBody = new LoginBody();
        loginBody.setEmail(email);
        loginBody.setPassword(password);


        viewModel.login(loginBody);
    }
}
