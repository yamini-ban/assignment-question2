package com.example.lenovo.pama;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private View rootView;
    private EditText user;
    private EditText password;
    private Button loginbtn;
    private Button registerbtn;
    private MainActivity activity;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activity = (MainActivity)getActivity();
        rootView = inflater.inflate(R.layout.fragment_login, container, false);

//        init();
        user = (EditText) rootView.findViewById(R.id.username);
        password = (EditText) rootView.findViewById(R.id.password);
        loginbtn = (Button) rootView.findViewById(R.id.loginbtn);
        registerbtn = (Button) rootView.findViewById(R.id.registerbtn);

        user.setText(activity.getSharedPreferences("login",MODE_PRIVATE).getString("username",""));
        password.setText(activity.getSharedPreferences("login",MODE_PRIVATE).getString("password",""));

        setListeners();

        return rootView;
    }

    private void setListeners(){
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getSharedPreferences("login",MODE_PRIVATE).edit().putString("username",user.getText().toString()).commit();
                activity.getSharedPreferences("login",MODE_PRIVATE).edit().putString("password",password.getText().toString()).commit();
                if(user.getText().toString().equals("y") && password.getText().toString().equals("y")) {
//                    Intent intent = new Intent(activity,InsertActivity.class);
//                    startActivity(new Intent(activity,InsertActivity.class));
                    activity.moveToReplace();
                }
                else{
                    Toast.makeText(activity,"Invalid username or password!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.moveToRegister();
            }
        });
    }

//    private void init() {
//
//    }

}
