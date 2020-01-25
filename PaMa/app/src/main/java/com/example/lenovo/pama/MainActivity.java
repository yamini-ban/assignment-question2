package com.example.lenovo.pama;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

//    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        moveToSplash();

    }

    public void moveToSplash() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
        SplashFragment splashFragment = new SplashFragment();
        fragmentTransaction.replace(R.id.frame,splashFragment).commit();
    }

    private void init(){
        fragmentManager = getSupportFragmentManager();
    }

    public void moveToLogin() {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            LoginFragment loginFragment = new LoginFragment();
            fragmentTransaction.replace(R.id.frame,loginFragment,"Login").commit();
            fragmentTransaction.addToBackStack("Login");
    }

    public void moveToRegister() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RegisterFragment registerFragment = new RegisterFragment();
        fragmentTransaction.replace(R.id.frame,registerFragment,"Register").commit();
        fragmentTransaction.addToBackStack("Register");
    }

    public void moveToReplace() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ReplaceFragment replaceFragment = new ReplaceFragment();
        fragmentTransaction.replace(R.id.frame,replaceFragment,"Replace").commit();
        fragmentTransaction.addToBackStack("Replace");
    }

    public void moveToInsert() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        InsertFragment insertFragment = new InsertFragment();
        fragmentTransaction.replace(R.id.addframe,insertFragment,"Insert").commit();
        fragmentTransaction.addToBackStack("Insert");
    }
}
