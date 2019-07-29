package com.example.sairam.option_menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sairam.noidahotels.R;
import com.example.sairam.noidahotels.second;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.abc,menu);
        return true;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        switch(i) {

            case0:
            Intent i = new Intent(second.this, GridView.class);
            Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show();
            startActivity(i);
            case1:
            Intent i = new Intent(second.this, direction.class);
            startActivity(i);
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            break;
        }
    }
}



