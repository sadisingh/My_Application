package com.example.sairam.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class First_Fragment extends Fragment {


    public First_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_first_, container, false);
       b1= view.findViewById(R.id.button1);
       b1.setOnClickListener((view)   {
               Toast.makeText(getActivity(),text: "In Haridwar",Toast.LENGTH_SHORT).show();

       });
        return view;
    }

}
