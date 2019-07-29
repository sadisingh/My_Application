package com.example.sairam.grid_view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom extends ArrayAdapter<String> {
    Activity c;
    String s1[];
    Integer img[];

    public custom(Context context, String[] resource, Integer[] textViewResourceId) {
        super(context,R.layout.activity_main, resource);
        c=(Activity) context;
        s1=resource;
        img=textViewResourceId;


    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater lf = c.getLayoutInflater();
        v = lf.inflate(R.layout.simple, null, true);
        TextView tv = v.findViewById(R.id.text1);
        ImageView im = v.findViewById(R.id.img1);
        tv.setText(s1[position]);
        im.setImageResource(img[position]);
        return v;
    }
}