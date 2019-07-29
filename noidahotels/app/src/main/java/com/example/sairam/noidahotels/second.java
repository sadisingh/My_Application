package com.example.sairam.noidahotels;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class second extends AppCompatActivity {
    ListView lv;
    Adapter ad;
   TextView tv;
    String name[] = {"Ginger Hotel", "Sandal Suites Hotel", "Fortune Inn GraZia", "Radisson", "FabHotel Silver Inn"};
    Integer image[] = {R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14, R.drawable.img15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.list1);
        custom c=new custom(second.this,name,image);
        lv.setAdapter(c);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long id) {
                switch (i) {
                    case0:

                        Intent intent = new Intent(second.this, info.class);
                        startActivity(intent);
                        Toast.makeText(second.this, "Ginger Hotel", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case1:

                        Toast.makeText(second.this, "Sandal Suites Hotel", Toast.LENGTH_SHORT).show();
                        break;

                    case2:

                        Toast.makeText(second.this, "Fortune Inn Grazia", Toast.LENGTH_SHORT).show();
                        break;
                        case3:

                            Toast.makeText(second.this, "Radisson", Toast.LENGTH_SHORT).show();
                            break;

                        case4:

                            Toast.makeText(second.this, "FabHotel Silver Inn", Toast.LENGTH_SHORT).show();

                            break;







































