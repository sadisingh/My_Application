package com.example.sairam.autocomplete_textview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView actv;
    String[] t = {"vibhor", "vishal", "vibhu", "vish", "abhishek"};
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         actv=findViewById(R.id.auto);
        adp = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,t);
       actv.setAdapter(adp);
        actv.setThreshold(1);

    }
}