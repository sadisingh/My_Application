package com.cetpa.dell.ims;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        ListView listView= (ListView) findViewById(R.id.courseenquiry_lv_list);
        BaseCourseAdapter adapter=new BaseCourseAdapter(this);
        listView.setAdapter(adapter);

    }

}

