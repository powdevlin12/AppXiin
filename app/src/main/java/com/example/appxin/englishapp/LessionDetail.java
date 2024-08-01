package com.example.appxin.englishapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.appxin.MainActivity;
import com.example.appxin.R;

public class LessionDetail extends AppCompatActivity {
    private ViewPager viewPager;
    private LessionDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lession_detail);

        Bundle extrasData = getIntent().getExtras();
        int positionItemClick = extrasData.getInt("position");
        int mode = extrasData.getInt("mode");

        viewPager = (ViewPager) this.findViewById(R.id.viewpager_lession_detail);

        if (mode == ActivityEnglishApp.NORMAL_MODE) {
        adapter = new LessionDetailAdapter(this, ActivityEnglishApp.arrLession);
        } else {
            adapter = new LessionDetailAdapter(this, ActivityEnglishApp.arrLessionSearch);
        }

        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(positionItemClick);
    }
}