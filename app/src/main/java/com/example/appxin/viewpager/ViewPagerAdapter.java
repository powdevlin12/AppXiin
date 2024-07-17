package com.example.appxin.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appxin.R;

public class ViewPagerAdapter extends PagerAdapter {
    private int[] arrImg;
    private Context context;

    public ViewPagerAdapter(int[] arrImg, Context context) {
        this.arrImg = arrImg;
        this.context = context;
    }

    // Do dai cua mang truyen vao
    @Override
    public int getCount() {
        return this.arrImg.length;
    }

    // Trong viewpager se co co che tai se dung nhu convertView -> khi 1 doi tuong moi tao ra no se kiem tra nhung doi tuong truoc da co chua, tranh du thua, tra true neu da ton tai, false neu chua ton tai.
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    // giai phong bo nho cac phan  tu da an di
    // view pager add tat ca view con vao container, khi destroy phai remote item do ra khoi container.
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    // tuong tu ham getView trong listView
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.view_pager_item, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.img_view_pager);
        img.setImageResource(arrImg[position]);

        container.addView(view);
        return view;
    }
}
