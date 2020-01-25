package com.example.lenovo.pama;


import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReplaceFragment extends Fragment {


    private View rootView;
    private MainActivity activity;
    private Button add;
    private Button update;
    private Button delete;
    private Button display;

    public ReplaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activity = (MainActivity)getActivity();
        rootView = inflater.inflate(R.layout.fragment_replace, container, false);
        init();
        setListeners();
        return rootView;
    }

    public void setListeners() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                activity.moveToInsert();
                startActivity(new Intent(getContext(),InsertActivity.class));
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),UpdateActivity.class));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),DeleteActivity.class));
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),DisplayActivity.class));
            }
        });
    }
    public void init(){
        add = (Button) rootView.findViewById(R.id.add);
        update = (Button) rootView.findViewById(R.id.update);
        delete = (Button) rootView.findViewById(R.id.delete);
        display = (Button) rootView.findViewById(R.id.display);
    }
}
