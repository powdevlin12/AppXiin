package com.example.appxin.fortythree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

public class ActivityFrom extends AppCompatActivity {
    private Button btnJumpReceiver;
    private EditText edtYourName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);

        btnJumpReceiver = this.findViewById(R.id.btnJumReceiver);
        edtYourName = this.findViewById(R.id.edtName);

        btnJumpReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityReceiver.class);
                i.putExtra("NAME", edtYourName.getText().toString());
                startActivity(i);
            }
        });
    }
}