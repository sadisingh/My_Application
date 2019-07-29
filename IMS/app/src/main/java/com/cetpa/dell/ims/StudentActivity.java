package com.cetpa.dell.ims;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class StudentActivity extends Activity {

    private static int regNo;
    private static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    @Override
    protected void onResume() {
        super.onResume();

        step1();
    }

    private void submit(){
        EditText editText= (EditText) findViewById(R.id.add_edt_name);
        String nameS=editText.getText().toString();
        if (nameS.isEmpty()){
            editText.setError("please Enter Name");
            editText.setFocusable(true);
            return;
        }
        editText= (EditText) findViewById(R.id.add_edt_fatherName);
        String Fname=editText.getText().toString();
        if (Fname.isEmpty()){
            editText.setError("please Enter FatherName");
            editText.setFocusable(true);
            return;
        }
        editText= (EditText) findViewById(R.id.add_edt_address);
        String address=editText.getText().toString();
        if (address.isEmpty()){
            editText.setError("please Enter Address");
            editText.setFocusable(true);
            return;
        }
        editText= (EditText) findViewById(R.id.add_edt_mobile);
        String mobile=editText.getText().toString();
        if (mobile.isEmpty()){
            editText.setError("please Enter Mobile");
            editText.setFocusable(true);
            return;
        }
        Spinner sp= (Spinner) findViewById(R.id.add_sp_course);
        String course=sp.getSelectedItem().toString();
        name=nameS;
        StudentDB db=new StudentDB(StudentActivity.this);
        db.insertStudent(nameS, Fname, address, mobile, course);
        step2();
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_btn_cancel:
                Intent back=new Intent(StudentActivity.this,MainActivity.class);
                startActivity(back);
                break;
            case R.id.add_btn_ok:
                Intent odBck=new Intent(StudentActivity.this,MainActivity.class);
                startActivity(odBck);
                break;
            case R.id.add_btn_submit:
                submit();
                break;
        }
    }

    private void step1(){
        LinearLayout layout= (LinearLayout) findViewById(R.id.add_ll_bottom);
        layout.setVisibility(View.VISIBLE);
        layout= (LinearLayout) findViewById(R.id.add_ll_new);
        layout.setVisibility(View.VISIBLE);
        layout= (LinearLayout) findViewById(R.id.add_ll_reg);
        layout.setVisibility(View.GONE);

    }

    private void step2(){
        LinearLayout layout= (LinearLayout) findViewById(R.id.add_ll_bottom);
        layout.setVisibility(View.GONE);
        layout= (LinearLayout) findViewById(R.id.add_ll_new);
        layout.setVisibility(View.GONE);
        layout= (LinearLayout) findViewById(R.id.add_ll_reg);
        layout.setVisibility(View.VISIBLE);
        TextView hiname=  (TextView)findViewById(R.id.add_tv_hiname);
        TextView sucess=  (TextView)findViewById(R.id.add_tv_sucessfull);
        TextView reg=  (TextView)findViewById(R.id.add_tv_regitration);
        StudentDB db=new StudentDB(StudentActivity.this);

        ArrayList<StudentView> dt= (ArrayList<StudentView>) db.getStudentNameBY(name);
        StudentView sv=dt.get(0);
        regNo=sv.getStudent_REGISTRATION();
        if(regNo>0){
            hiname.setText("HI "+name);
            sucess.setText("Your Addmisstion is sucessfull....");
            reg.setText("Registration No : "+regNo);
        }else{
            hiname.setText("HI "+name);
            sucess.setText("Your Addmisstion is Not sucessfull....");
            reg.setText("Registration No : ");
        }
    }

}