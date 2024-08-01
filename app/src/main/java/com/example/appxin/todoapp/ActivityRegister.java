package com.example.appxin.todoapp;

import android.content.Intent;
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
import com.example.appxin.retrofitlearn.ActivityRetrofit;
import com.example.appxin.retrofitlearn.models.Post;
import com.example.appxin.todoapp.UtilsService.TodoApiService;
import com.example.appxin.todoapp.UtilsService.UtilService;
import com.example.appxin.todoapp.models.User;
import com.example.appxin.todoapp.models.UserBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRegister extends AppCompatActivity {
    private TextView  txtNavigateLogin;
    private EditText edtName, edtEmail, edtPassword, edtConfirmPassword;
    private Button btnRegister;
    private String name, email ,password, confirmPasword;
    private ProgressBar progressBar;

    UtilService utilService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtNavigateLogin = this.findViewById(R.id.txt_navigate_login);
        edtName = this.findViewById(R.id.edt_name_register);
        edtEmail = this.findViewById(R.id.edt_email_register);
        edtPassword = this.findViewById(R.id.edt_password_register);
        edtConfirmPassword = this.findViewById(R.id.edt_password_confirm_register);
        btnRegister = this.findViewById(R.id.btn_register);
        progressBar = this.findViewById(R.id.progress_bar);
        utilService = new UtilService();

        txtNavigateLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityLogin.class);
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilService.hideKeyboard(v, ActivityRegister.this);

                name = edtName.getText().toString();
                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();
                confirmPasword = edtConfirmPassword.getText().toString();

                boolean isValid = validate(v);

                if (isValid) {
                    registerUser(v);
                }
            }
        });
    }

    private void registerUser(View v) {
        progressBar.setVisibility(View.VISIBLE);

        UserBody userBody = new UserBody(name, email, password);

        TodoApiService.apiService.createUser(userBody).enqueue(new Callback<com.example.appxin.todoapp.models.Response>() {
            @Override
            public void onResponse(Call<com.example.appxin.todoapp.models.Response> call, Response<com.example.appxin.todoapp.models.Response> response) {
                Log.i("AppXinLog", "onResponse");

                if (response.isSuccessful()) {
//                    User user = response.body();
//                    Log.i("AppXinLog", user.toString());
                    Toast.makeText(ActivityRegister.this, "Create user success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(), ActivityLogin.class);
                    startActivity(i);
                } else {
                    Log.i("AppXinLog", "Create user error " + response);
                }
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<com.example.appxin.todoapp.models.Response> call, Throwable t) {
                Log.i("AppXinLog", "Create user error");
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ActivityRegister.this, "Create user error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean validate(View view) {
        boolean isValid;
        boolean passwordValid;

        isValid = !TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPasword);

        passwordValid = password.equals(confirmPasword);

        if (!isValid) {
            utilService.showSnackBar(view, "Please enter input is empty ...");
            return false;
        }

        if (!passwordValid) {
            utilService.showSnackBar(view, "Password confirm is not equals password ...");
            return false;
        }

        return true;
    }
}