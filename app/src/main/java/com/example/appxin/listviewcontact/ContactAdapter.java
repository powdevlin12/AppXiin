package com.example.appxin.listviewcontact;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appxin.R;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ContactModel> arrContact;
    private IContactInfo contactInfo;
    public ContactAdapter(Context context, ArrayList<ContactModel> arr, IContactInfo contactInfo) {
        this.context= context;
        this.arrContact = arr;
        this.contactInfo = contactInfo;
    }

    @Override
    public int getCount() {
        if (this.arrContact != null) {
            return this.arrContact.size();
        }

        return 0;
    }

    @Override
    public Object getItem(int position) {
        return this.arrContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;

        if (rowView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//            rowView = inflater.inflate(R.layout.item_contact_layout, parent, false);
            rowView = inflater.inflate(R.layout.item_contact_grid_view, parent, false);

            holder = new ViewHolder();
             holder.img = (ImageView) rowView.findViewById(R.id.img_contact);
             holder.txtName = (TextView) rowView.findViewById(R.id.txt_name_contact);
             holder.txtPhone = (TextView) rowView.findViewById(R.id.txt_phone_contact);
             holder.phone = (ImageView) rowView.findViewById(R.id.img_call);

             holder.phone.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     ContactModel contact = arrContact.get(position);
//                     ((ActivityContact) context).updateUserInfo(contact);
                     contactInfo.updateUserSelect(contact);
                     Toast.makeText(ContactAdapter.this.context, "Call to : "+contact.getPhone(), Toast.LENGTH_SHORT).show();
                 }
             });
            rowView.setTag(holder);
        }
        else {
            holder = (ViewHolder) rowView.getTag();
            Log.i("AppXinLog", "holder "+ holder);
        }


        ContactModel model = arrContact.get(position);


        holder.txtName.setText(model.getName());
        holder.txtPhone.setText(model.getPhone());

        if (model.getImg() == 0) {
            holder.img.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            holder.img.setImageResource(R.drawable.ic_launcher_foreground);
        }
        return rowView;
    }

    static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtPhone;
        ImageView phone;

    }
}
