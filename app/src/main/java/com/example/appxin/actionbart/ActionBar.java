package com.example.appxin.actionbart;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

public class ActionBar extends AppCompatActivity {
    private Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        myToolbar = this.findViewById(R.id.tlb_actionbar);
        myToolbar.setTitle("My toolbar");
        myToolbar.setSubtitle("You have 12 new messages");

        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id  = item.getItemId();

        if (id == R.id.refresh) {
            Toast.makeText(this, "Click refresh item", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.share) {
            Toast.makeText(this, "Click share item", Toast.LENGTH_SHORT).show();

        } else if(id == R.id.random1) {
            Toast.makeText(this, "Click random1 item", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Click random2 item", Toast.LENGTH_SHORT).show();

        }
        return true;
    }
}