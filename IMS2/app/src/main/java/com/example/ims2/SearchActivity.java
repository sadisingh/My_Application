package com.example.ims2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_search);
    }
    @Override
    protected void onResume() {
        super.onResume();
        step1();
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.search_btn_allStudent:
                Intent allstudent=new Intent(SearchActivity.this,SearchAllStudent.class);
                startActivity(allstudent);
                break;
            case R.id.search_btn_search:
                EditText regText=(EditText)findViewById(R.id.search_edt_serchRegitration);
                String reg=regText.getText().toString();
                if(reg.isEmpty()){
                    regText.setError("Please Enter your Registration ID");
                    regText.setFocusable(true);
                    return;
                }
                serchResult(reg);
                registrationIdClear();
                break;
            case R.id.search_btn_edit:
                editStudent();
                break;
            case R.id.search_btn_delete:

                TextView textView=(TextView)findViewById(R.id.search_tv_registrationNO);
                String regd=textView.getText().toString();
                StudentDB db=new StudentDB(SearchActivity.this);
                db.deleteStudent(regd);
                Toast.makeText(SearchActivity.this, "Record Deleted Successfully", Toast.LENGTH_SHORT).show();
                Intent p1=new Intent(SearchActivity.this,MainActivity.class);
                startActivity(p1);
                break;

            case R.id.search_btn_back:
                Intent p=new Intent(SearchActivity.this,MainActivity.class);
                startActivity(p);
                break;
        }

    }
    private void registrationIdClear(){
        EditText regTextdd=(EditText)findViewById(R.id.search_edt_serchRegitration);
        regTextdd.setText("");
    }

    private void editStudent(){
        TextView text=(TextView)findViewById(R.id.search_tv_registrationNO);
        String regis=text.getText().toString();
        EditText editText=(EditText)findViewById(R.id.search_edt_name);
        String name=editText.getText().toString();
        if(name.isEmpty())
        {
            editText.setError("Please Enter Edit Name");
            editText.setFocusable(true);
            return;
        }
        editText=(EditText)findViewById(R.id.search_edt_fatherName);
        String fname=editText.getText().toString();
        if(fname.isEmpty()) {
            editText.setError("Please Enter Edit Father Name");
            editText.setFocusable(true);
            return;
        }
        editText=(EditText)findViewById(R.id.search_edt_address);
        String address=editText.getText().toString();
        if(address.isEmpty()) {
            editText.setError("Please Enter Edit Address");
            editText.setFocusable(true);
            return;
        }
        editText=(EditText)findViewById(R.id.search_edt_course);
        String course=editText.getText().toString();
        if(course.isEmpty()) {
            editText.setError("Please Enter Edit Course");
            editText.setFocusable(true);
            return;
        }
        editText=(EditText)findViewById(R.id.search_edt_mobile);
        String mobile=editText.getText().toString();
        if(mobile.isEmpty()) {
            editText.setError("Please Enter Edit Mobile No.");
            editText.setFocusable(true);
            return;
        }
        StudentDB db=new StudentDB(SearchActivity.this);
        db.editStudent(regis,name,fname,address,mobile,course);
        Toast.makeText(SearchActivity.this,"Successfully Updated....",Toast.LENGTH_LONG).show();
    }


    private void serchResult(String regID){
        StudentDB db=new StudentDB(SearchActivity.this);
        StudentView st= (StudentView) db.getStudentREGBY(regID);
        if (st.getStudent_REGISTRATION()==-1){
            Toast.makeText(SearchActivity.this,"Not Found",Toast.LENGTH_LONG).show();
            return;
        }
        TextView text=(TextView)findViewById(R.id.search_tv_registrationNO);
        text.setText(""+st.getStudent_REGISTRATION());
        EditText editText=(EditText)findViewById(R.id.search_edt_name);
        editText.setText(""+st.getStudent_name());
        editText=(EditText)findViewById(R.id.search_edt_fatherName);
        editText.setText(""+st.getStudent_FATHER_NAME());
        editText=(EditText)findViewById(R.id.search_edt_address);
        editText.setText(""+st.getStudent_Address());
        editText=(EditText)findViewById(R.id.search_edt_course);
        editText.setText(""+st.getStudent_Course());
        editText=(EditText)findViewById(R.id.search_edt_mobile);
        editText.setText(""+st.getStudent_Phone());
        step2();
    }
    private void step1(){
        LinearLayout layout=(LinearLayout)findViewById(R.id.search_ll_editOption);
        layout.setVisibility(View.VISIBLE);
        layout=(LinearLayout)findViewById(R.id.search_ll_bottom);
        layout.setVisibility(View.GONE);
        layout=(LinearLayout)findViewById(R.id.search_ll_searchOption);
        layout.setVisibility(View.GONE);
    }
    private void step2(){
        LinearLayout layout=(LinearLayout)findViewById(R.id.search_ll_editOption);
        layout.setVisibility(View.GONE);
        layout=(LinearLayout)findViewById(R.id.search_ll_bottom);
        layout.setVisibility(View.VISIBLE);
        layout=(LinearLayout)findViewById(R.id.search_ll_searchOption);
        layout.setVisibility(View.VISIBLE);
    }
}

