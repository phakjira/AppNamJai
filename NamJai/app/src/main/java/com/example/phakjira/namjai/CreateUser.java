package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateUser extends AppCompatActivity {
    public EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        id=(EditText)findViewById(R.id.editTextID);
        Intent go=getIntent();
        String email= go.getStringExtra("email");
        id.setText(email);
    }

    public void onFinish(View v) {
        Intent in=new Intent(getApplication(),Profile.class);
        startActivity(in);
    }
}
