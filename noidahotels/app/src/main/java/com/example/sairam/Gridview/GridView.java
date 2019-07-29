package com.example.sairam.Gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.sairam.noidahotels.R;
import com.example.sairam.noidahotels.custom;

class MainActivity extends AppCompatActivity {
    GridView lv;
    String name[]={"vivek","vibhor","vish","yash","Ram"};
    Integer image[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.grid);
        custom c=new custom(MainActivity.this,name,image);
        lv.setAdapter(c);
    }
}
