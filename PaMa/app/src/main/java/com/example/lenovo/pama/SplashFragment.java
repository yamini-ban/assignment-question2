package com.example.lenovo.pama;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {


    private View rootView;
    private MainActivity activity;

    public SplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        activity = (MainActivity) getActivity();
        rootView = inflater.inflate(R.layout.fragment_splash, container, false);
        init();
        return rootView;
    }

    private void init() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.moveToLogin();
            }
        },1000);
    }

}
