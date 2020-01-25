package com.example.lenovo.pama;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

//    private Activity9 activity;
    private EditText userName;
    private EditText password;
    private Button loginbtn;
    private Button registerbtn;
    private Button replace;
    private MainActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        registerbtn = (Button) findViewById(R.id.registerbtn);
        replace = (Button) findViewById(R.id.replace); 

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String pass = password.getText().toString();

                if (name.equals("y") && pass.equals("y")) {
                    Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter valid credentials!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.moveToReplace();
            }
        });
        
    }
}
