package com.example.signup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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



public class login extends Fragment {
  EditText e3,e4;
  Button b2;
  View v;
  String s11,s12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login, container, false);
        e3 = v.findViewById(R.id.e3);
        e4 = v.findViewById(R.id.e4);
        b2 = v.findViewById(R.id.b1);
        b2 = v.findViewById(R.id.sign1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s11 = e3.getText().toString();
                s12 = e4.getText().toString();
                Login();

            }
        });
        return v;
    }
    public void Login(){
        RequestQueue rq= Volley.newRequestQueue(getActivity());
        String url="https://studentmanagment1234qq.000webhost.com/loginphp/login.php";
                StringRequest sr=new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){

            public void onResponse(String response){
                if(response=="Success"){
                Toast.makeText(getActivity(), "signup", Toast.LENGTH_SHORT).show();

            }
                else{
                Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
            }

        }
    },new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error){
            Toast.makeText(getActivity(), "not login", Toast.LENGTH_SHORT).show();
        }
    }){
        protected Map<String,String> getParams()throws AuthFailureError {
            HashMap<String,String> hm1=new HashMap<String,String>();
            hm1.put ("n",s11);
            hm1.put ("p",s12);
            return hm1;

        }
    };
    rq.add(sr);
}
}




