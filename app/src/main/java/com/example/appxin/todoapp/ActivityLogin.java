package com.example.appxin.todoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;
import com.example.appxin.todoapp.UtilsService.SharedPreferenceClass;
import com.example.appxin.todoapp.UtilsService.TodoApiService;
import com.example.appxin.todoapp.UtilsService.UtilService;
import com.example.appxin.todoapp.models.ResponseError;
import com.example.appxin.todoapp.models.User;
import com.example.appxin.todoapp.models.login.LoginBody;
import com.example.appxin.todoapp.models.login.SuccessLogin;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {
    private TextView txtNavigateRegister;
    private EditText edtName, edtPassword;
    private Button btnLogin;

    private String name, password;

    private ProgressBar progressBar;

    UtilService utilService;

    SharedPreferenceClass sharedPreferenceClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        utilService = new UtilService();
        txtNavigateRegister = this.findViewById(R.id.txt_navigate_register);
        btnLogin = this.findViewById(R.id.btn_login);
        edtName = this.findViewById(R.id.edt_name_todo);
        edtPassword = this.findViewById(R.id.edt_password_todo);
        progressBar = this.findViewById(R.id.progress_bar_todo);
        sharedPreferenceClass = new SharedPreferenceClass(this);

        txtNavigateRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityRegister.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                name = edtName.getText().toString();
                password = edtPassword.getText().toString();

                boolean valid = validate(view);

                if (valid) {
                    loginUser(view);
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences todo_pref = getSharedPreferences(SharedPreferenceClass.USER_PREF, MODE_PRIVATE);
        if (todo_pref.contains("token")) {
            startActivity(new Intent(this, ActivityTodoMain.class));
            finish();
        }
    }

    private boolean validate(View view) {
        if (TextUtils.isEmpty(name)) {
            utilService.showSnackBar(view, "Please enter your email");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            utilService.showSnackBar(view, "Please enter your password");
            return false;
        }

        return true;
    }

    private void loginUser(View v) {
        LoginBody loginBody = new LoginBody(name, password);

        TodoApiService.apiService.loginUser(loginBody).enqueue(new Callback<SuccessLogin>() {
            @Override
            public void onResponse(Call<SuccessLogin> call, Response<SuccessLogin> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(ActivityLogin.this, "Login success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(), ActivityTodoMain.class);
                    SuccessLogin successLogin = response.body();
                    sharedPreferenceClass.setValue_string("token", successLogin.getToken());
                    startActivity(i);
                    finish();
                } else {
                    try {
                        String errorBody = response.errorBody().string();
                        Gson gson = new Gson();
                        ResponseError responseError = gson.fromJson(errorBody, ResponseError.class);
                        Log.i("AppXinLog", "Error body: " + responseError.getMsg());
                        Toast.makeText(ActivityLogin.this,  responseError.getMsg(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<SuccessLogin> call, Throwable t) {
                Log.i("AppXinLog", "Create user error");
                Toast.makeText(ActivityLogin.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}