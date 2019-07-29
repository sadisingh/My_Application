package com.example.sairam.twomultiply;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
    Spinner sp;
    Spinner sp1;

    String num[]={"1","2","3","4"};
String prices[]={"200","300","400","500"};
ArrayAdapter<String> adp,adp1;
double s1,s2,s3;
TextView tv;
Button b1;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewId(R.id.text);
         b1=findViewById(R.id.but);
         b1.setOnClickListener(new.View OnCickListener

         sp=findViewById(R.id.spin);
         sp1=findViewById(R.id.spin1);
         adp=new ArrayAdapter<String>(.this,android.R.layout.simple_list_item_1,num);
           adp1=n ew ArrayAdapter<String>(.this,android.R.layout.simple_list_item_1,prices);
           sp.setAdapter(adp);
    sp1.setAdapter(adp1);
    s1=(Double.parseDouble(sp.getSelected().toString()));
    s2=(Double.parseDouble(sp1.getSelected().toString()));
     s3=s1*s2;
     tv.setText(String.valueof(s3));
}
}




}
