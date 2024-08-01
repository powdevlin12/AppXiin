package com.example.appxin.retrofitlearn;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;
import com.example.appxin.retrofitlearn.adapter.AdapterCustomer;
import com.example.appxin.retrofitlearn.apis.ApiService;
import com.example.appxin.retrofitlearn.models.Customer;
import com.example.appxin.retrofitlearn.models.Post;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRetrofit extends AppCompatActivity {

    private Button btnCallApi;

    private ListView lvCustomer;

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
//
//        Job job = new Job("1","Coder");
//        List<Favourite> favouriteList = new ArrayList<Favourite>();
//
//        favouriteList.add(new Favourite(1, "Code"));
//        favouriteList.add(new Favourite(1, "Sleep"));
//
//
//        User user = new User(1, "Tran Thu Dat", false,job,  favouriteList);
//
//        Gson gson = new Gson();
//        String strJson = gson.toJson(user);
//
//        Log.i("AppXinRetrofit", strJson);

        lvCustomer = (ListView) this.findViewById(R.id.lv_customer);
        btnCallApi = this.findViewById(R.id.btn_callApi);
        progressBar = this.findViewById(R.id.progressBar_cyclic);

        btnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                createPost();
//                callApi();
            }
        });
    }

    private void callApi() {
        ApiService.apiService.getCustomer().enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                Toast.makeText(ActivityRetrofit.this, "Call api Success", Toast.LENGTH_SHORT).show();

                List<Customer> listCustomer = response.body();

                if (listCustomer != null && response.isSuccessful()) {
                    AdapterCustomer adapter = new AdapterCustomer((Context) ActivityRetrofit.this, listCustomer);
                    lvCustomer.setAdapter(adapter);
                    Toast.makeText(ActivityRetrofit.this, "Call Api Success", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                Toast.makeText(ActivityRetrofit.this, "Call api Error", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }

        });
    }

    private void createPost() {
        Post post = new Post(1,101,"Tran Dat", "Hello cac ban");
        ApiService.apiService.createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.i("AppXinLog", "create post" + response.isSuccessful());
                if (response.isSuccessful()) {
                    Post post = response.body();
                    Log.i("AppXinLog", post.toString());
                    Toast.makeText(getApplicationContext(), "Post thanh cong ne", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

//                    Toast.makeText(ActivityRetrofit.this, post.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.i("AppXinLog", "Failuare create post");
                progressBar.setVisibility(View.GONE);

                Toast.makeText(ActivityRetrofit.this, "Call api Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}