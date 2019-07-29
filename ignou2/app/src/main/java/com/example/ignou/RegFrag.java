package com.example.ignou;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;

import java.util.HashMap;
import java.util.Map;


public class RegFrag extends Fragment  {

    View myview=null;
    EditText name,last,add,phon,comp,bio;
    Button register,showdetail;
    String user_name, user_last,user_add, user_phon,user_comp, user_bio;
    Context context;
    boolean cancelLogin = false;
    //TextToSpeech tts;
    //String voice="Register has been successful";
    AwesomeValidation awesomeValidation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       myview= inflater.inflate(R.layout.fragment_reg, container, false);
        //context = myview.getContext();

        showdetail=(Button)myview.findViewById(R.id.studentDetails);
        register = (Button) myview.findViewById(R.id.submit);
        name=(EditText)myview.findViewById(R.id.usereditt);
        last=(EditText)myview.findViewById(R.id.userpasss);
        add = (EditText) myview.findViewById(R.id.useradd);
        phon = (EditText) myview.findViewById(R.id.userphone);
        comp = (EditText) myview.findViewById(R.id.compny);
        bio = (EditText) myview.findViewById(R.id.bio);
        user_name = name.getText().toString();
        user_last = last.getText().toString();
        user_add = add.getText().toString();
        user_phon = phon.getText().toString();
        user_comp = comp.getText().toString();
        user_bio = bio.getText().toString();
        //tts=new TextToSpeech(getActivity(),this);
        /*awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(getActivity(),R.id.usereditt, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.userpasss, "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.useradd, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(), R.id.userphone, "^[2-9]{2}[0-9]{8}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(),R.id.compny, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(getActivity(),R.id.bio, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        //awesomeValidation.addValidation(this, R.id.editTextAge, Range.closed(13, 60), R.string.ageerror);*/

        showdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go =new Intent(getActivity(),Student_Detail.class);

                name.setText(" ");
                last.setText(" ");
                add.setText(" ");
                phon.setText(" ");
                comp.setText(" ");
                bio.setText(" ");
                startActivity(go);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            user_name = name.getText().toString();
            user_last = last.getText().toString();
            user_add = add.getText().toString();
            user_phon = phon.getText().toString();
            user_comp = comp.getText().toString();
            user_bio = bio.getText().toString();
            /*if (user_id.isEmpty() || user_pass.isEmpty()|| user_add.isEmpty() || user_phon.isEmpty() || user_comp.isEmpty() || user_bio.isEmpty()){

                Toast.makeText(getActivity(), "pls fill form", Toast.LENGTH_SHORT).show();
            }else{
                post_Data();
                register.setBackgroundColor(Color.GREEN);

                //Toast.makeText(getActivity(), "great..", Toast.LENGTH_SHORT).show();
            }*/
           //submitForm();

            if (TextUtils.isEmpty(user_name)) {
                name.setError(getString(R.string.userName_required));
                myview = name;
                cancelLogin = true;
            }
            else if (TextUtils.isEmpty(user_last)) {
               last.setError(getString(R.string.userLast_required));
                myview = last;
                cancelLogin = true;
            }
            else if (TextUtils.isEmpty(user_add)) {
                add.setError(getString(R.string.address_required));
                myview = add;
                cancelLogin = true;
            }else if (TextUtils.isEmpty(user_phon)&!isValidPhone(user_phon)) {
                phon.setError(getString(R.string.phone_required));
                myview = phon;
                cancelLogin = true;
            }
            else if (TextUtils.isEmpty(user_comp)) {
                comp.setError(getString(R.string.company_required));
                myview = comp;
                cancelLogin = true;
            }
            else if (TextUtils.isEmpty(user_bio)) {
                bio.setError(  getString(R.string.bio_required));
                myview = bio;
                cancelLogin = true;
            }
            /*if (cancelLogin) {
                // error in login
                Toast.makeText(myview.getContext(), "error in login", Toast.LENGTH_LONG).show();
                myview.requestFocus();
            }*/ else {
                post_Data();
            }

        }


    });
    return  myview;
    }

    public void post_Data() {
        RequestQueue requestQueue = Volley.newRequestQueue(myview.getContext());
        String url = "http://student-database.000webhostapp.com/student/register.php";     //192.168.43.26 is system wifi hotspot address......Ipv4 adress
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
               //tts.speak(voice,TextToSpeech.QUEUE_ADD,null);
                Toast.makeText(myview.getContext(), "registered...." + s, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, "Error register"+volleyError.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String,String> getParams() {
                Map<String,String> hm1 = new HashMap<String,String>();
                hm1.put("name", user_name);
                hm1.put("password", user_last);
                hm1.put("address", user_add);
                hm1.put("phone", user_phon);
                hm1.put("company", user_comp);
                hm1.put("biohis", user_bio);
                return hm1;
            }
        };
        requestQueue.add(stringRequest);
    }



   /* public boolean isValidpass(String email) {
        String EMAIL_PATTERN = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }*/

    public boolean isValidPhone(String user_phon) {
        return user_phon != null && user_phon.length() == 10;
    }

    /*@Override
    public void onInit(int i) {
        tts.setSpeechRate(0.8f);
        tts.setLanguage(Locale.ENGLISH);
    }*/
    /*public void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(getActivity(), "Validation Successfull", Toast.LENGTH_LONG).show();
            post_Data();
            //process the data further
        }else{

            Toast.makeText(getActivity(), "Not!!!!!!!Successfull", Toast.LENGTH_LONG).show();
    }*/


}
