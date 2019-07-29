package com.example.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Sanjubook extends AppCompatActivity {

    String time[] = {"10:40 AM", "11:50 AM", "1:50 PM", "3:00 PM", "5:20 PM", "6:40 PM", "8:20 PM", "10:20 PM", "11:50 PM"};
    String cost[] = {"125", "175", "250", "325"};
    String ppl[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    Spinner sp1,sp2,sp3;
    EditText editText,editText2,editText3;
    String ss1,ss2,ss3,ss4,ss5,ss6;
    // array
    ArrayAdapter<String> advp1;
    ArrayAdapter<String> advp2;
    ArrayAdapter<String> advp3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanjubook);
        editText=findViewById(R.id.username);
        editText2=findViewById(R.id.Con1);
        editText3=findViewById(R.id.address);
        sp1=findViewById(R.id.spinner1);
        sp2=findViewById(R.id.spinner2);
        sp3=findViewById(R.id.spinner3);
        advp1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,time);
        advp2=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,cost);
        advp3=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,ppl);
        sp1.setAdapter(advp1);
        sp2.setAdapter(advp2);
        sp3.setAdapter(advp3);
        findViewById(R.id.done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun();
            }
        });




    }
    public void fun(){

        ss1=editText.getText().toString();
        ss2=editText2.getText().toString();
        ss3=editText3.getText().toString();
        ss4=sp1.getSelectedItem().toString();
        ss5=sp2.getSelectedItem().toString();
        ss6=sp3.getSelectedItem().toString();
        Intent i=new Intent(Sanjubook.this,Confirm.class);
        i.putExtra("a",ss1);
        i.putExtra("b",ss2);
        i.putExtra("c",ss3);
        i.putExtra("d",ss4);
        i.putExtra("e",ss5);
        i.putExtra("f",ss6);

        startActivity(i);

    }
}
