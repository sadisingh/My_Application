package com.example.connectfirebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

   public class MainActivity extends AppCompatActivity {
EditText txtname,txtage,txtphone,txtheight;
    Button btnsave;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
         txtname=(EditText)findViewId(R.id.txtname)


    }
}
