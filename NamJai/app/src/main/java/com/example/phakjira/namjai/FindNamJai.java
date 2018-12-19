package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FindNamJai extends AppCompatActivity {
    String studentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_nam_jai);
        Intent in=getIntent();
        studentID=in.getStringExtra("id");
    }

    public void findTutor (View v) {
        Intent findtutor=new Intent(getApplication(),FindTutor.class);
        findtutor.putExtra("id",studentID);
        startActivity(findtutor);
    }

    /*public void findOther(View v) {
        Intent findOther=new Intent(getApplication(),FindOther.class);
        findOther.putExtra("id",studentID);
        startActivity(findOther);
    }*/
}
