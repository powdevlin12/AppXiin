package com.example.appxin.todoapp.UtilsService;

import com.example.appxin.retrofitlearn.apis.ApiService;
import com.example.appxin.todoapp.models.Response;
import com.example.appxin.todoapp.models.User;
import com.example.appxin.todoapp.models.UserBody;
import com.example.appxin.todoapp.models.login.LoginBody;
import com.example.appxin.todoapp.models.login.SuccessLogin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TodoApiService {
//    http://10.0.2.2/api/todo/
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    TodoApiService apiService = new Retrofit.Builder()
            .baseUrl("http://172.16.1.191:3000/api/todo/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(TodoApiService.class);

    @POST("auth/register")
    Call<Response> createUser(@Body UserBody userBody);

    @POST("auth/login")
    Call<SuccessLogin> loginUser(@Body LoginBody loginBody);

}
