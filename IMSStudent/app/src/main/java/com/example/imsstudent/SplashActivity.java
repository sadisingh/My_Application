package com.example.imsstudent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    public class SplashActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);

            Thread t = new Thread(){
                public void run(){
                    try{
                        sleep(3000);
                    }catch(InterruptedException e){
                        //handle your exception here
                    }finally{
                        Intent i= new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            };
            t.start();
        }
    }

