package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateNamjai extends AppCompatActivity {
    public String studentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_namjai);

        Intent intent = getIntent();
        studentID = intent.getStringExtra("id");


    }

    public void chooseTutor(View view) {
        Intent intent = new Intent(this, createTutor.class);
        intent.putExtra("id",studentID);
        startActivity(intent);
    }

    public void chooseOther(View view){
        Intent intent = new Intent(this, createOther.class);
        intent.putExtra("id",studentID);
        startActivity(intent);
    }
}
