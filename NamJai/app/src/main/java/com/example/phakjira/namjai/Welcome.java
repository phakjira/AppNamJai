package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void newUser(View view){
        Intent newUser = new Intent(this,FacebookLogin.class);
        startActivity(newUser);
    }

    public void login(View view){
        Intent login = new Intent(this,UserLogin.class);
        startActivity(login);
    }
}
