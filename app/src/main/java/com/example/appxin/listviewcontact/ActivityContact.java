package com.example.appxin.listviewcontact;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

import java.util.ArrayList;

public class ActivityContact extends AppCompatActivity implements IContactInfo {

    private ArrayList<ContactModel> arrContacts = new ArrayList<ContactModel>();
    private ListView lstContact;

    // update model
    private ImageView imgSelectAvatar;
    private TextView txtSelectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initData();

        lstContact = (ListView) this.findViewById(R.id.lst_contact);
        ContactAdapter adapter = new ContactAdapter(this, arrContacts, this);

        lstContact.setAdapter(adapter);

        lstContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contact = arrContacts.get(position);
                Toast.makeText(parent.getContext(), "Click vao "+ contact.getName(), Toast.LENGTH_LONG).show();
            }
        });

        imgSelectAvatar = (ImageView) this.findViewById(R.id.img_user_select);
        txtSelectName = (TextView) this.findViewById(R.id.txt_user_select);

    }

    private void initData() {
        arrContacts.add(new ContactModel("Tran dat", "0941374589", 0));
        arrContacts.add(new ContactModel("Tran dat 1", "0941374589", 2));
        arrContacts.add(new ContactModel("Tran dat 2", "0941374589", 0));
        arrContacts.add(new ContactModel("Tran dat 3", "0941374589", 4));
        arrContacts.add(new ContactModel("Tran dat 4", "0941374589", 0));
        arrContacts.add(new ContactModel("Tran dat 5", "0941374589", 0));
        arrContacts.add(new ContactModel("Tran dat", "0941374589", 0));
        arrContacts.add(new ContactModel("Tran dat 1", "0941374589", 2));
        arrContacts.add(new ContactModel("Tran dat 2", "0941374589", 0));
        arrContacts.add(new ContactModel("Tran dat 3", "0941374589", 4));
        arrContacts.add(new ContactModel("Tran dat 4", "0941374589", 0));
        arrContacts.add(new ContactModel("Tran dat 5", "0941374589", 6));
        arrContacts.add(new ContactModel("Tran dat", "0941374589", 1));
        arrContacts.add(new ContactModel("Tran dat 122", "0941374589", 22));
        arrContacts.add(new ContactModel("Tran dat 2", "0941374589", 3));
        arrContacts.add(new ContactModel("Tran dat 3", "0941374589", 4));
        arrContacts.add(new ContactModel("Tran dat 4", "0941374589", 5));
        arrContacts.add(new ContactModel("Tran dat 5", "0941374589", 6));
    }
    // phai de public de ben adapter goi duoc
    public void updateUserInfo(ContactModel contact) {
//        this.imgSelectAvatar.setImageResource(contact.getImg());
        this.txtSelectName.setText(contact.getName());
    }

    @Override
    public void updateUserSelect(ContactModel contact) {
        this.txtSelectName.setText(contact.getName());
    }
}