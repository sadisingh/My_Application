package com.example.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sanjuimage extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanjuimage);
        b1 = findViewById(R.id.buttonone);
      //  s = t.getText().toString();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sanjuimage.this, Sanjubook.class);
                startActivity(i);
                Toast.makeText(Sanjuimage.this, "Registered", Toast.LENGTH_SHORT).show();




            }
        });
    }


}
