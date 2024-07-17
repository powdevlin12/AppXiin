package com.example.appxin.startActivityForResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

import java.util.Objects;

public class ActivityOne extends AppCompatActivity {
    private Button btnLogin;
    private TextView txtLogin;
    private static final int REQUEST_CODE_ACTIVITY_ONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        btnLogin = this.findViewById(R.id.btnLogin);
        txtLogin = this.findViewById(R.id.txtLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityTwo.class);
                startActivityForResult(i, REQUEST_CODE_ACTIVITY_ONE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ACTIVITY_ONE) {
            assert data != null;
            String message = Objects.requireNonNull(data.getExtras()).getString("MESSAGE");
            txtLogin.setText(message);
            switch (resultCode) {
                case Activity.RESULT_OK:
                    btnLogin.setVisibility(View.INVISIBLE);
                    break;
                case Activity.RESULT_CANCELED:
                    break;
                default: break;
            }
        } else  {
            Toast.makeText(getApplicationContext(), "Not activity one send data",
                    Toast.LENGTH_LONG).show();
        }
    }
}