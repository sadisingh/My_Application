package com.example.signup;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
FrameLayout f1;
FragmentManager fm;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    b1.findViewById(R.id.sign1);
    b2.findViewById(R.id.log1);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fm.beginTransaction().replace(R.id.sign1, new sign());

        }
    });
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fm.beginTransaction().replace(R.id.log1, new login());
        }
    });


}
}
