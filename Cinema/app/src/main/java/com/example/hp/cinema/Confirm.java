package com.example.hp.cinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class Confirm extends AppCompatActivity {
    TextView ty1,ty2,ty3,ty4,ty5,ty6;
    Button confirm;
    String s1,s2,s3,s4,s5,s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
         ty1=findViewById(R.id.user);
        ty2= findViewById(R.id.una);
        ty3= findViewById(R.id.mob);
        ty4= findViewById(R.id.time);
        ty5= findViewById(R.id.pers);
        ty6= findViewById(R.id.cost);
        confirm=findViewById(R.id.bt);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=ty1.getText().toString();
                s2=ty2.getText().toString();
                s3=ty3.getText().toString();
                s4=ty4.getText().toString();
                s5=ty5.getText().toString();
                s6=ty6.getText().toString();
                if (s1.isEmpty()&&s2.isEmpty()&&s3.isEmpty()&&s4.isEmpty()&&s5.isEmpty()&&s6.isEmpty()){
                    Toast.makeText(Confirm.this, "Please Fill This Form", Toast.LENGTH_SHORT).show();
                }else {
                    confirm();
                }

            }
        });




        ty1.setText(getIntent().getStringExtra("a"));
        ty2.setText(getIntent().getStringExtra("b"));
        ty3.setText(getIntent().getStringExtra("c"));
        ty4.setText(getIntent().getStringExtra("d"));
        ty5.setText(getIntent().getStringExtra("e"));
        ty6.setText(getIntent().getStringExtra("f"));

    }
    public  void  confirm(){
        RequestQueue rq= Volley.newRequestQueue(Confirm.this);
        String url="http://studentiddb.000webhostapp.com/book/register.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Confirm.this, "SUCCESS...", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Confirm.this, "NOT SUCCESS...", Toast.LENGTH_SHORT).show();
            }
        })
        {@Override
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap<String,String> hml=new HashMap<String, String>();
            hml.put("u",s1);
            hml.put("c",s2);
            hml.put("ad",s3);
            hml.put("t",s4);
            hml.put("p",s5);
            hml.put("pe",s6);
            return hml;
        }

        };
        rq.add(sr);
    }



    }

//ranu@cetpainfotech.com

