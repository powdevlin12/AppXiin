package com.example.appxin.englishapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appxin.R;

import java.util.ArrayList;

public class LessionAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<LessionModel> arrLession;

    public LessionAdapter(Context context, ArrayList<LessionModel> arrLession) {
        this.context = context;
        this.arrLession = arrLession;
    }

    @Override
    public int getCount() {
        return this.arrLession.size();
    }

    @Override
    public Object getItem(int position) {
        return arrLession.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrLession.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View rowView = inflater.inflate(R.layout.lession_item, parent, false);

        TextView txtLessionName = (TextView) rowView.findViewById(R.id.txt_lession);
        txtLessionName.setText(this.arrLession.get(position).lessionName);

        return rowView;
    }
}
