package com.example.signup;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class sign extends Fragment {
    EditText e1, e2;
    Button b8;
    View v;
   String s1,s2,s3;
    public sign() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sign, container, false);
        e1 = v.findViewById(R.id.e1);
        e2 = v.findViewById(R.id.e2);
        b8 = v.findViewById(R.id.b0);
        b8 = v.findViewById(R.id.sign1);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             s1=e1.getText().toString();
             s2=e2.getText().toString();
             s3=b8.getText().toString();

            }
        });
        return v;

    }
public void register(){
    RequestQueue rq= Volley.newRequestQueue(getActivity());
    String url="https://studentmanagment1234qq.000webhost.com/loginphp/register.php";
   StringRequest sr=new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){

    public void onResponse(String response){
        Toast.makeText(getActivity(), "dataregister", Toast.LENGTH_SHORT).show();

    }
},new Response.ErrorListener(){
        @Override
                public void onErrorResponse(VolleyError error){
            Toast.makeText(getActivity(), "notlogin", Toast.LENGTH_SHORT).show();
        }
    }){
        protected Map<String,String>getParams()throws AuthFailureError {
            HashMap<String,String>hm1=new HashMap<String,String>();
            hm1.put ("n",s1);
            hm1.put ("p",s2);
            hm1.put ("m",s3);
            return hm1;

        }
        };
    rq.add(sr);
}
}


