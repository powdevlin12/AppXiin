package com.example.appxin.viewpager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.appxin.R;

public class ActivityViewPager extends AppCompatActivity {
    private int[] arrImage = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5};

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = this.findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(arrImage, this);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
    }
}