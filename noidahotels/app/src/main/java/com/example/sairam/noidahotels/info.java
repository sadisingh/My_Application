package com.example.sairam.noidahotels;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Gallery;
import android.widget.Toast;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.info,Menu);
        getMenuInflater().inflate(R.menu.abc,menu);
        return true;
}

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        switch (item.getItemId()) {
            case R.id.first:
                Intent i = new Intent(info.this, Gallery.class);
                startActivity(i);
                Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                Toast.makeText(this, "Direction", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                 break;
        }

    }}

