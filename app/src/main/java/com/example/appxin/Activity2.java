package com.example.appxin;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("AppXinLog", "Activity 2 :onRestart");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    @Override
    protected void onRestart() {
        Log.i("AppXinLog", "Activity 2 :onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("AppXinLog", "Activity 2 :onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("AppXinLog", "Activity 2 :onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("AppXinLog", "Activity 2 :onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("AppXinLog", "Activity 2 :onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("AppXinLog", "Activity 2 :onDestroy");
    }
}