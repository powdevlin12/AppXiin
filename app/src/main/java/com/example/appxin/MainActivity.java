package com.example.appxin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.englishapp.ActivityEnglishApp;
import com.example.appxin.fortythree.ActivityFrom;
import com.example.appxin.gridview.ActivityGridView;
import com.example.appxin.linearLayoutCaculator.ActivityCaculator;
import com.example.appxin.listviewcontact.ActivityContact;
import com.example.appxin.startActivityForResult.ActivityOne;
import com.example.appxin.viewpager.ActivityViewPager;

public class MainActivity extends AppCompatActivity {
    private Button btnJump, btnJump43, btnStartActivityForResult, btnCaculator, btnListViewContact, btnGridView, btnEnglishApp, btnViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("AppXinLog", "Activity 1 : onCreate");
        btnJump = this.findViewById(R.id.btn_jump);
        btnJump43 = this.findViewById(R.id.btn_jump_43);
        btnStartActivityForResult = this.findViewById(R.id.btnStartActivityForResult);
        btnCaculator = this.findViewById(R.id.btnLinearLayout);
        btnListViewContact = this.findViewById(R.id.btnListView);
        btnGridView = this.findViewById(R.id.btnGridView);
        btnEnglishApp = this.findViewById(R.id.btn_english_app);
        btnViewPager = this.findViewById(R.id.btnViewPager);

        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Activity2.class);
                startActivity(i);
            }
        });

        btnJump43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityFrom.class);
                startActivity(i);
            }
        });

        btnStartActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityOne.class);
                startActivity(i);
            }
        });

        btnCaculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityCaculator.class);
                startActivity(i);
            }
        });

        btnListViewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityContact.class);
                startActivity(i);
            }
        });

        btnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityGridView.class);
                startActivity(i);
            }
        });

        btnEnglishApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityEnglishApp.class);
                startActivity(i);
            }
        });

        btnViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityViewPager.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onRestart() {
        Log.i("AppXinLog", "Activity 1 :onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("AppXinLog", "Activity 1 :onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("AppXinLog", "Activity 1 :onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("AppXinLog", "Activity 1 :onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("AppXinLog", "Activity 1 :onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("AppXinLog", "Activity 1 :onDestroy");
    }
}