package com.bhatt.vishal.ignou;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImgReg extends Activity {
    ImageView image;
    FragmentManager fm;
    Button click;
    //Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_reg);
        image = (ImageView) findViewById(R.id.imageView);
        click=(Button)findViewById(R.id.button5);
       // initToolBar();
        fm = getFragmentManager();
        Bundle extras = getIntent().getExtras();
        image.setImageResource(extras.getInt("key"));
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //android.support.v4.app.Fragment fra;
               //fra = new RegFrag();
                fm.beginTransaction().replace(R.id.frame,new RegFrag()).commit();
            }
        });
    }
    /*@SuppressLint("ResourceAsColor")
   *//* public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle(R.string.sp1);
        toolbar.setBackgroundColor(R.color.button_selectorcolor);
        //setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

    }*/`         `
}

