package com.example.sairam.vehicle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CarList extends AppCompatActivity {
ListView lv;
String s1[]={"bmw","Audi","lamborghini","baleno"};
ArrayAdapter<String> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casrlist);
        lv=findViewById(R.id.list1);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s1);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Intent intent=new Intent(CarList.this,Carimages.class);
                        startActivity(intent);

                        Toast.makeText(CarList.this, "bmw", Toast.LENGTH_SHORT).show();
                        break;
                         case 1:
                        Toast.makeText(CarList.this, "audi", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(CarList.this, "lamberghini", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(CarList.this, "baleno", Toast.LENGTH_SHORT).show();
                        break;



                        }
            }
        });

    }
}
