package com.example.ignou;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class Years extends Activity implements Animation.AnimationListener {
   Button b1,b2,b3,b4;
   ImageView imganim;
    Toolbar toolbar;
    Animation slideLeft, slideRight, slideTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_years);
        FirebaseAuth.getInstance().getCurrentUser();
        slideLeft = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_left);
        slideLeft.setAnimationListener(this);
        slideRight = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_right);
        slideRight.setAnimationListener(this);
        slideTop = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_in);
        slideTop.setAnimationListener(this);
       /* slideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_in);
        slideDown.setAnimationListener(this);*/
        imganim=(ImageView)findViewById(R.id.imganimation);
        imganim.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable)imganim.getBackground()).start();
            }
        });

        //initToolBar();
        b1=(Button)findViewById(R.id.bca);
        b2=(Button)findViewById(R.id.mca);
        b3=(Button)findViewById(R.id.bba);
        b4=(Button)findViewById(R.id.mba);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Years.this,Register.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Years.this,Register.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Years.this,Register.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Years.this,Register.class);
                startActivity(i);
            }
        });

    }
   /* public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar3);
        toolbar.setTitle(R.string.sp12);
        //setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_local_library_black_24dp);

     }*/
    @Override
    protected void onStart() {
        super.onStart();

        b1.setVisibility(View.VISIBLE);
        b1.startAnimation(slideLeft);
        b2.setVisibility(View.VISIBLE);
        b2.startAnimation(slideRight);
        b3.setVisibility(View.VISIBLE);
        b3.startAnimation(slideLeft);
        b4.setVisibility(View.VISIBLE);
        b4.startAnimation(slideTop);

    }
    @Override
    public void onAnimationStart(Animation animation) {

    }
    @Override
    public void onAnimationEnd(Animation animation) {

    }
    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.signout,menu);
        return true;

    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_sign_out) {

        }
        return true;
    }*/

   /* @Override
    public void onBackPressed() {
        //super.onBackPressed();
        new AlertDialog.Builder(this).setMessage("Do you want to Logout?")
                .setTitle("LogOut")
                .setIcon(R.drawable.ignoulogo1)
                .setCancelable(false)
                .setPositiveButton("LogOut", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Years.this,Login.class);
                        startActivity(i);

                                        // Close activity
                                       // finish();

                        }
                }) .setNegativeButton("No",null)
                .show();
    }*/
}
