package com.example.appxin.englishapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

import java.util.ArrayList;

public class ActivityEnglishApp extends AppCompatActivity {
    public static final int NORMAL_MODE = 0;
    public static final int SEARCH_MODE = 1;
    public int currentMode = NORMAL_MODE;
    public static ArrayList<LessionModel> arrLession = new ArrayList<LessionModel>();
    public static ArrayList<LessionModel> arrLessionSearch = new ArrayList<LessionModel>();
    private ListView lstLession;
    private  LessionAdapter adapter;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_app);
        initData();

        lstLession = this.findViewById(R.id.lst_lession);
        edtSearch = this.findViewById(R.id.edtSearchLesson);

//        SET ADAPTER
         adapter = new LessionAdapter(this, arrLession);
         lstLession.setAdapter(adapter);

//         HANDLE EVENT
        lstLession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), LessionDetail.class);
                i.putExtra("position", position);
                i.putExtra("mode", currentMode);
                startActivity(i);
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchLesson();
            }
        });
    }

    private void searchLesson() {
        String searchText = edtSearch.getText().toString();
        boolean isSearch = !searchText.trim().isEmpty();

        if (isSearch) {
            arrLessionSearch.clear();
            for (int i=0; i < arrLession.size(); i ++ ) {
                if (arrLession.get(i).lessionName.toLowerCase().contains(searchText.trim().toLowerCase())) {
                    arrLessionSearch.add(arrLession.get(i));
                }
            }
            adapter = new LessionAdapter(this, arrLessionSearch);
            lstLession.setAdapter(adapter);
            currentMode = SEARCH_MODE;
        } else {
            adapter = new LessionAdapter(this, arrLession);
            lstLession.setAdapter(adapter);
            currentMode = NORMAL_MODE;
        }
    }

    private void initData() {
        arrLession.add(new LessionModel(1, "About"));
        arrLession.add(new LessionModel(2, "Asking questions 1"));
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