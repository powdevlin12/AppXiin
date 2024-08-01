package com.example.appxin.englishapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appxin.R;

import java.util.ArrayList;

public class LessionDetailAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<LessionModel> arr;


    public LessionDetailAdapter(Context context, ArrayList<LessionModel> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return this.arr.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.lession_detail_item, container, false);

        // find view by id
        WebView webview = (WebView) view.findViewById(R.id.webview);
        String url = "file:///android_asset/"+arr.get(position).lessionName+".htm";
        url.replace(" ","%20");
        webview.loadUrl(url);

        // show room control
        webview.getSettings().setBuiltInZoomControls(true);

        container.addView(view);

        return view;
    }
}
