package com.example.appxin.englishapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

import java.util.ArrayList;

public class ActivityEnglishApp extends AppCompatActivity {

    private ArrayList<LessionModel> arrLession = new ArrayList<LessionModel>();
    private ListView lstLession;

    private  LessionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_app);
        initData();

//        SET ADAPTER
        lstLession = this.findViewById(R.id.lst_lession);
         adapter = new LessionAdapter(this, arrLession);
         lstLession.setAdapter(adapter);

//         HANDLE EVENT
        lstLession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void initData() {
        arrLession.add(new LessionModel(1, "About"));
        arrLession.add(new LessionModel(2, "Asking queions 1"));
        arrLession.add(new LessionModel(3, "Asking questions 2"));
        arrLession.add(new LessionModel(4, "Can have and could have"));
        arrLession.add(new LessionModel(5, "Can"));
        arrLession.add(new LessionModel(6, "For"));
        arrLession.add(new LessionModel(7, "For 2"));
        arrLession.add(new LessionModel(8, "Going to or will"));
        arrLession.add(new LessionModel(9, "Had better"));
        arrLession.add(new LessionModel(10, "Could"));
    }
}