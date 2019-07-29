package com.bhatt.vishal.ignou;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Student_Detail extends Activity implements View.OnClickListener{
    private EditText editTextId;
    private Button buttonGet,update,delete;
    private ProgressDialog loading;
    EditText a,b,c,d,e,f;
    Toolbar toolbar;
    String st1,st2,st3,st4,st5,st6;
    TextInputLayout signupInputLayoutName,signupInputPassword,signupInputPassword1,signupInputPassword2,signupInputPassword3,
    signupInputPassword4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__detail);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

        }
        a=(EditText) findViewById(R.id.t1);
        b=(EditText)findViewById(R.id.t2);
        c=(EditText)findViewById(R.id.t3);
        d=(EditText)findViewById(R.id.t4);
        e=(EditText)findViewById(R.id.t5);
        f=(EditText)findViewById(R.id.t6);
        signupInputLayoutName = (TextInputLayout) findViewById(R.id.signup_input_layout_name);
        signupInputPassword= (TextInputLayout) findViewById(R.id.signup_input_layout_password);
        signupInputPassword1= (TextInputLayout) findViewById(R.id.signup_input_layout_password1);
        signupInputPassword2= (TextInputLayout) findViewById(R.id.signup_input_layout_password2);
        signupInputPassword3= (TextInputLayout) findViewById(R.id.signup_input_layout_password3);
        signupInputPassword4= (TextInputLayout) findViewById(R.id.signup_input_layout_password4);

        delete=(Button)findViewById(R.id.delete);
        update=(Button)findViewById(R.id.update);
        editTextId = (EditText) findViewById(R.id.editTextId);
        buttonGet = (Button) findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st1 = a.getText().toString();
                st2 = b.getText().toString();
                st3 = c.getText().toString();
                st4 = d.getText().toString();
                st5 = e.getText().toString();
                st6 = f.getText().toString();
                dele();

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st1 = a.getText().toString();
                st2 = b.getText().toString();
                st3 = c.getText().toString();
                st4 = d.getText().toString();
                st5 = e.getText().toString();
                st6 = f.getText().toString();
                if (st1.isEmpty() || st2.isEmpty() || st3.isEmpty() || st4.isEmpty() || st5.isEmpty() || st6.isEmpty()) {
                    Toast.makeText(Student_Detail.this, "no edit text", Toast.LENGTH_LONG).show();
                } else {
                    upda();
                }
            }
        });
    }
    private void getData() {
        String id = editTextId.getText().toString().trim();
        if (id.equals(" ")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        }
        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);
        String url = Config.DATA_URL+editTextId.getText().toString().trim();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Student_Detail.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

                requestQueue.add(stringRequest);
    }
    private void showJSON(String response){

        String name=" ";
        String password=" ";
        String address = " ";
        String phone=" ";
        String company=" ";
        String biohis = " ";
        
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(Config.KEY_NAME);
            password= collegeData.getString(Config. KEY_ADDRESS1);
            address = collegeData.getString(Config.KEY_VC1);
            phone= collegeData.getString(Config.KEY_NAME2);
            company = collegeData.getString(Config.kEY1);
            biohis = collegeData.getString(Config.KEY2);

        } catch (JSONException e)
        {
            e.printStackTrace();
    }
        a.setText(name);
        b.setText(password);
        c.setText(address);
        d.setText(phone);
        e.setText(company);
        f.setText(biohis);
    }
    @Override
    public void onClick(View v) {

        getData();
    }
    public void dele(){
        //PD.show();
        RequestQueue rq= Volley.newRequestQueue(Student_Detail.this);
        String url="http://student-database.000webhostapp.com/student/delete.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (s.trim().equalsIgnoreCase("delete")) {

                    Toast.makeText(Student_Detail.this, s, Toast.LENGTH_SHORT).show();//openProfile();
                } else {
                    Toast.makeText(Student_Detail.this, s, Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Student_Detail.this, "DeleteFile" , Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Student_Detail.this, "errors...." +volleyError.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()  {
                HashMap<String,String> hm1 = new HashMap<String,String>();
                hm1.put("n", st1);
                hm1.put("p", st2);
                hm1.put("a", st3);
                hm1.put("ph", st4);
                hm1.put("co", st5);
                hm1.put("b", st6);
                return hm1;
            }
        };
        rq.add(sr);
    }
    public void upda(){
        //PD.show();
        RequestQueue rq= Volley.newRequestQueue(Student_Detail.this);
        String url="http://student-database.000webhostapp.com/student/update.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (s.trim().equalsIgnoreCase("success")) {

                    Toast.makeText(Student_Detail.this, s, Toast.LENGTH_SHORT).show();
                    //openProfile();
                } else {
                    Toast.makeText(Student_Detail.this, s, Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Student_Detail.this, "updated file" , Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Student_Detail.this, "errors...." +volleyError.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()  {
                HashMap<String,String> hm1 = new HashMap<String,String>();
                hm1.put("n", st1);
                hm1.put("p", st2);
                hm1.put("a", st3);
                hm1.put("ph", st4);
                hm1.put("co", st5);
                hm1.put("b", st6);
                return hm1;
            }
        };
        rq.add(sr);
    }


}
