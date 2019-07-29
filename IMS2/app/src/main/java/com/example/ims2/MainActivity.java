package com.example.ims2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
     Button BtnCourse,BtnQuery;
     Button BtnStudent,BtnExit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnCourse=(Button)findViewById(R.id.button2);
        BtnExit=(Button)findViewById(R.id.button4);
        BtnQuery=(Button)findViewById(R.id.button3);
        BtnStudent=(Button)findViewById(R.id.button);

        BtnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,CourseActivity.class);
                startActivity(intent);

            }
        });
        BtnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,StudentActivity.class);
                startActivity(intent);

            }
        });
        BtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        BtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishAffinity();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.finish();
    }
}
