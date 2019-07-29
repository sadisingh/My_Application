package com.example.sairam.frame_animation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView im;
  MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im=findViewById(R.id. images);
        mp=MediaPlayer.create(MainActivity.this,R.raw.mario);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent i=new Intent(MainActivity.this,second.class);
                startActivity(i);
                mp.stop();
                finish();
           }
       },   5000);

        im = findViewById(R.id.images);
        im.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) im.getBackground()).start();
                 mp.start();
            }
        });


    }

    @Override
    public void onBackPressed() {
       ///super.onBackPressed();
         mp.start();
    }
}
