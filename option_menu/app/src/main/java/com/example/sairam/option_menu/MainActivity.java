package com.example.sairam.option_menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.first:
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(i1);
            case R.id.second:
                Toast.makeText(this, "second", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:654789212"));
                startActivity(i3);
                break;
            case R.id.third:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i2);
                break;

        }

    }

}