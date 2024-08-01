package com.example.appxin.retrofitlearn.apis;

import com.example.appxin.retrofitlearn.models.Customer;
import com.example.appxin.retrofitlearn.models.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
//    https://jsonplaceholder.typicode.com/users
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("users")
    Call<List<Customer>> getCustomer();

    @POST("posts")
    Call<Post> createPost(@Body Post post);
}
