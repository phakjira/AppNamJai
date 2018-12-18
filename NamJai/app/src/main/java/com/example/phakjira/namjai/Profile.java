package com.example.phakjira.namjai;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    //private TextView TextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener OnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_findnamjai:
                    //TextMessage.setText(R.string.title_home);
                    //do smth
                    return true;
                case R.id.navigation_yournamjai:
                    //TextMessage.setText(R.string.title_dashboard);
                    Intent in1=new Intent(getApplication(),YourNamJai.class);
                    startActivity(in1);
                    return true;
                case R.id.navigation_createnamjai:
                    //TextMessage.setText(R.string.title_notifications);
                    Intent in2 = new Intent(getApplication(),CreateNamjai.class);
                    startActivity(in2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.setTitle("Profile");

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener);
    }

}
