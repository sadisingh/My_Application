package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button registerbuton;
    Button show;
    EditText name, address, id, qualification, contact;
    String s1, s2, s3, s4, s5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.userid);
        name=findViewById(R.id.name);
        address = findViewById(R.id.add);
        qualification = findViewById(R.id.qua);
        contact = findViewById(R.id.con);
        show = findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,fetch.class);
                startActivity(i);
            }
        });
        registerbuton = findViewById(R.id.register);
        registerbuton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                s1 = id.getText().toString();
                s3 = address.getText().toString();
                s2 = name.getText().toString();
                s4 = qualification.getText().toString();
                s5 = contact.getText().toString();

                register();

            }
        });
    }


    public void register() {
        RequestQueue rq = Volley.newRequestQueue(MainActivity.this);
        String url = "https://studentmanagment1234qq.000webhostapp.com/studentandroid/register.php";
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_SHORT).show();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "error"+error.toString(), Toast.LENGTH_SHORT).show();
            }


        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("i", s1);
                hm.put("n", s2);
                hm.put("a", s3);
                hm.put("q", s4);
                hm.put("m", s5);
                return hm;
            }
        };

        rq.add(sr);
    }
}