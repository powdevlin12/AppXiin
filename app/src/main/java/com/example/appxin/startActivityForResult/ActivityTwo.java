package com.example.appxin.startActivityForResult;

import android.app.Activity;
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

public class ActivityTwo extends AppCompatActivity {
    private EditText edtEmail, edtPwd;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        edtEmail = this.findViewById(R.id.edtEmail);
        edtPwd = this.findViewById(R.id.edtPwd);
        btnLogin = this.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtEmail.getText().toString().equals("dat") && edtPwd.getText().toString().equals("1")) {
                    Intent i = new Intent();
                    i.putExtra("MESSAGE", "LOGIN SUCCESS");
                    setResult(Activity.RESULT_OK, i);
                    finish();
                } else {
                    Intent i = new Intent();
                    i.putExtra("MESSAGE", "LOGIN FALSE");
                    setResult(Activity.RESULT_CANCELED, i);
                    finish();
                }
            }
        });

    }
}