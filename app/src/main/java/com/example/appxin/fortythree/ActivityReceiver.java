package com.example.appxin.fortythree;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

public class ActivityReceiver extends AppCompatActivity {
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        txtName = this.findViewById(R.id.txtName);
        Bundle bundle = getIntent().getExtras();
        String myName = bundle.getString("NAME", "");
        txtName.setText("Hiiii,  "+myName);
    }
}