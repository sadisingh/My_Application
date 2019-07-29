package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fetch extends AppCompatActivity {
    Button u1, d1, f1;
    EditText id1, n1, add2, con1, q2;
    String s11, s12, s13, s14, s15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        id1 = findViewById(R.id.id1);
        n1 = findViewById(R.id.n1);
        add2 = findViewById(R.id.add2);
        con1 = findViewById(R.id.con1);
        q2 = findViewById(R.id.q2);
        s11 = id1.getText().toString();
        s12 = n1.getText().toString();
        s13 = add2.getText().toString();
        s14 = q2.getText().toString();
        s15 =con1.getText().toString();

        d1 = findViewById(R.id.d1);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        u1 = findViewById(R.id.u1);
        u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        f1 = findViewById(R.id.f1);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   getdata();
                s11 = id1.getText().toString();
            }
        });

    }

    public void getdata() {
        if (s11.equals(" ")) {
            Toast.makeText(this, "enter correct id", Toast.LENGTH_SHORT).show();
        }
        RequestQueue rd = Volley.newRequestQueue(fetch.this);
        String url = Config.DATA_URL + id1.getText().toString();
        StringRequest sr=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
           Showjson(response);
                Toast.makeText(fetch.this, "data fetch", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(fetch.this, "data not fetch", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void Showjson(String response)
    {
        String name1="";
        String address1="";
        String qualification1="";
        String mobile1="";
        try {
            JSONObject jr = new JSONObject(response);
            JSONArray jt = new JSONArray(Config.KEY_RESULT);
            JSONObject jm = jt.getJSONObject(0);
            name1=jm.getString(Config.KEY_NAME);
            address1=jm.getString(Config.KEY_ADDRESS);
            qualification1=jm.getString(Config.KEY_QUALIFICATION);
            mobile1=jm.getString(Config.KEY_MOBILE);

        }catch (JSONException e){
            e.printStackTrace();
        }
        n1.setText(name1);
        add2.setText(address1);
        q2.setText(qualification1);
        con1.setText(mobile1);
    }

}

