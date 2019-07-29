package com.example.sairam.vehicle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BikeList extends AppCompatActivity {
    ListView lv;
    String s2[]={"FZS","HONDA","hero", "splender","apache"};
    ArrayAdapter<String> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bikelist);
        lv=findViewById(R.id.list2);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s2);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i) {
                    case 0:

                        Intent intent = new Intent(BikeList.this, Bikeimages.class);
                        startActivity(intent);
                        Toast.makeText(BikeList.this, "bmw", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        Toast.makeText(BikeList.this, "HONDA", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(BikeList.this, "HERO", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(BikeList.this, "splender", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(BikeList.this, "apache", Toast.LENGTH_SHORT).show();
                        break;

                }



            }
        });







}
}
