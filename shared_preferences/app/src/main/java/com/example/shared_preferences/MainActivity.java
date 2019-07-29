package com.example.shared_preferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SharedPreferences pref;
EditText e1,e2;
Button b1,b2,b3,b4;
String prefName="luck";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e1);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putInt("ID",Integer.parseInt(e1.getText().toString()));
                editor.putString("Name",e2.getText().toString());
                editor.commit();
                Toast.makeText(getBaseContext(), "saved", Toast.LENGTH_SHORT).show();
            }
        });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pref=getSharedPreferences(prefName,MODE_PRIVATE);
                        String s1=String.valueOf(pref.getInt("ID",100));
                        String s2=pref.getString("Name","ABC");
               e1.setText(s1);
                e2.setText(s2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putInt("ID",Integer.parseInt(e1.getText().toString()));
                editor.putString("Name",e2.getText().toString());
                editor.commit();
                Toast.makeText(getBaseContext(), "update", Toast.LENGTH_SHORT).show();
            }
        });



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences(prefName,MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
               editor.clear();
               editor.commit();
            }
        });


    }
}
