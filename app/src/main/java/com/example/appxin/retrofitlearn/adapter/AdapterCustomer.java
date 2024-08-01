package com.example.appxin.retrofitlearn.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appxin.R;
import com.example.appxin.retrofitlearn.models.Customer;

import java.util.List;

public class AdapterCustomer extends BaseAdapter {
    private Context context;
    private List<Customer> arrCustomer;

    public AdapterCustomer(Context context, List<Customer> arrCustomer) {
        this.context = context;
        this.arrCustomer = arrCustomer;
    }

    @Override
    public int getCount() {
        return this.arrCustomer.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return arrCustomer.get(position).getId();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;

        if (rowView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            rowView= inflater.inflate(R.layout.item_customer, parent, false);

            holder = new ViewHolder();

            holder.txtName = (TextView) rowView.findViewById(R.id.txt_name);
            holder.txtEmail = (TextView) rowView.findViewById(R.id.txt_email);
            holder.txtAddress = (TextView) rowView.findViewById(R.id.txt_address);
            holder.txtPhone = (TextView) rowView.findViewById(R.id.txt_phone);
            holder.txtCompany = (TextView) rowView.findViewById(R.id.txt_company);
            holder.txtWebsite = (TextView) rowView.findViewById(R.id.txt_website);

            rowView.setTag(holder);
        } else  {
            holder = (ViewHolder) rowView.getTag();
        }

        Customer customer = arrCustomer.get(position);
        holder.txtEmail.setText(customer.getEmail());
        holder.txtName.setText(customer.getName());
        holder.txtAddress.setText(customer.getAddress().getStreet() + customer.getAddress().getCity());
        holder.txtCompany.setText(customer.getCompany().getName());
        holder.txtPhone.setText(customer.getPhone());
        holder.txtWebsite.setText(customer.getWebsite());

        return rowView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtEmail;
        TextView txtAddress;
        TextView txtPhone;
        TextView txtCompany;
        TextView txtWebsite;
    }
}
