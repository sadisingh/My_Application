package com.example.sairam.tourapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {

Button b1,b2;
View  v;
    public First() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_first, container, false);
        b1=v.findViewById(R.id.hari);
        b2=v.findViewById(R.id.rest);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"In haridwar",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getActivity(),ImageTemple.class);
                startActivity(i);

            }
        });
        return v;
    }

}
