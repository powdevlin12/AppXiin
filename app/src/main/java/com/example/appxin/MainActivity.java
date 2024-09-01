package com.example.appxin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.appxin.actionbart.ActionBar;
import com.example.appxin.englishapp.ActivityEnglishApp;
import com.example.appxin.fortythree.ActivityFrom;
import com.example.appxin.gridview.ActivityGridView;
import com.example.appxin.linearLayoutCaculator.ActivityCaculator;
import com.example.appxin.listviewcontact.ActivityContact;
import com.example.appxin.retrofitlearn.ActivityRetrofit;
import com.example.appxin.sqlite.Sqlite;
import com.example.appxin.sqlite2.Sqlite2;
import com.example.appxin.startActivityForResult.ActivityOne;
import com.example.appxin.todoapp.ActivityLogin;
import com.example.appxin.todoapp.SplashActivity;
import com.example.appxin.viewpager.ActivityViewPager;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver chargerReceiver;
    private Button btnJump, btnJump43, btnStartActivityForResult, btnCaculator, btnListViewContact, btnGridView, btnEnglishApp, btnViewPager, btnRetrofit, btnTodoApp, btnActionBar, btnSqLite, btnSqlite2;
    private static final int PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"AppXiin");
        filePath.mkdirs();

        File dir = getDatabasePath("myproduct.db");

        Log.i("AppXinLog", "DB path : " + dir.getAbsolutePath());
        btnJump = this.findViewById(R.id.btn_jump);
        btnJump43 = this.findViewById(R.id.btn_jump_43);
        btnStartActivityForResult = this.findViewById(R.id.btnStartActivityForResult);
        btnCaculator = this.findViewById(R.id.btnLinearLayout);
        btnListViewContact = this.findViewById(R.id.btnListView);
        btnGridView = this.findViewById(R.id.btnGridView);
        btnEnglishApp = this.findViewById(R.id.btn_english_app);
        btnViewPager = this.findViewById(R.id.btnViewPager);
        btnRetrofit = this.findViewById(R.id.btnRetrofit);
        btnTodoApp = this.findViewById(R.id.btn_todo_app);
        btnActionBar = this.findViewById(R.id.btnActionBar);
        btnSqLite = this.findViewById(R.id.btnSqlLite);
        btnSqlite2 = this.findViewById(R.id.btnSqlite2);

        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Activity2.class);
                startActivity(i);
            }
        });

        btnJump43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityFrom.class);
                startActivity(i);
            }
        });

        btnStartActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityOne.class);
                startActivity(i);
            }
        });

        btnCaculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityCaculator.class);
                startActivity(i);
            }
        });

        btnListViewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityContact.class);
                startActivity(i);
            }
        });

        btnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityGridView.class);
                startActivity(i);
            }
        });

        btnEnglishApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityEnglishApp.class);
                startActivity(i);
            }
        });

        btnViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityViewPager.class);
                startActivity(i);
            }
        });

        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ActivityRetrofit.class);
                startActivity(i);
            }
        });

        btnTodoApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ActivityLogin.class));
            }
        });

        btnActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ActionBar.class));
            }
        });

        btnSqLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Sqlite.class);
                startActivity(i);
            }
        });

        btnSqlite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Sqlite2.class);
                startActivity(i);
            }
        });

        chargerReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // TODO: Awesome things
                Bundle bundle = intent.getExtras();

                String messages = "";
                if (bundle != null) {
                    Object[] pdus = (Object[]) bundle.get("pdus");

                    for(int i=0; i<pdus.length; i ++) {
                        SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        messages += message.getDisplayOriginatingAddress();
                        messages += " " + message.getMessageBody()+"\n";
                    }
                }

                Toast.makeText(context,  messages, Toast.LENGTH_LONG).show();

            }
        };

//        registerReceiver(
//                chargerReceiver,
//                new IntentFilter("android.provider.Telephony.SMS_RECEIVED")
//        );



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Quyền đã được cấp
                Toast.makeText(this, "Quyền nhận và đọc SMS đã được cấp", Toast.LENGTH_SHORT).show();
            } else {
                // Quyền bị từ chối
                Toast.makeText(this, "Quyền nhận và đọc SMS bị từ chối", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onRestart() {
        Log.i("AppXinLog", "Activity 1 :onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("AppXinLog", "Activity 1 :onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("AppXinLog", "Activity 1 :onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("AppXinLog", "Activity 1 :onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("AppXinLog", "Activity 1 :onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("AppXinLog", "Activity 1 :onDestroy");
//        unregisterReceiver(chargerReceiver);
    }

    public static class SMSReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle bundle = intent.getExtras();

            String messages = "";
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");

                for(int i=0; i<pdus.length; i ++) {
                    SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    messages += message.getDisplayOriginatingAddress();
                    messages += " " + message.getMessageBody()+"\n";
                }
            }

            Toast.makeText(context,  messages, Toast.LENGTH_LONG).show();

        }
    }
}