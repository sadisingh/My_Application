package com.example.sairam.alert_box;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1.findViewById(R.id.click);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle("Game")
                        .setMessage("do you want to close this app")
                         .setView(R.layout.activity_login)
                        .setIcon(R.mipmap.ic_launcher)
                         .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 finish();
                             }
                         })

             .setNegativeButton("no",  null).show();
        }

        });
    }
      public void onBackPressed(){
        new AlertDialog.Builder(MainActivity.this).setTitle("Game")
        .setMessage("do you want to close this app")
        .setIcon(R.mipmap.ic_launcher)
        .setView(R.layout.activity_app)
        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("no",null).show();

}

    }