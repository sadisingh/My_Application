package com.bhatt.vishal.ignou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Register extends Activity {

    ImageView i1, i2, i3, i4, i5, i6;
   // Toolbar toolbar;
    //AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        i1 = (ImageView) findViewById(R.id.img1);
        //initToolBar();
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, ImgReg.class);
                intent.putExtra("imag", R.drawable.img22);
                startActivity(intent);
            }
        });
        i2 = (ImageView) findViewById(R.id.img2);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, ImgReg.class);
                intent.putExtra("imag", R.drawable.img22);
                startActivity(intent);
            }
        });
        i3 = (ImageView) findViewById(R.id.img3);
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, ImgReg.class);
                intent.putExtra("imag", R.drawable.img33);
                startActivity(intent);
            }
        });
        i4 = (ImageView) findViewById(R.id.img4);
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, ImgReg.class);
                intent.putExtra("imag", R.drawable.img44);
                startActivity(intent);
            }
        });
        i5 = (ImageView) findViewById(R.id.img5);
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, ImgReg.class);
                intent.putExtra("imag", R.drawable.img55);
                startActivity(intent);
            }
        });
        i6 = (ImageView) findViewById(R.id.img6);
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, ImgReg.class);
                intent.putExtra("imag", R.drawable.img66);
                startActivity(intent);

            }
        });
    }
    /*public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle(R.string.sp11);
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Register.this,Years.class);
                startActivity(j);
               // Toast.makeText(Register.this, "back..", Toast.LENGTH_SHORT).show();
            }
        });

    }*/
}












