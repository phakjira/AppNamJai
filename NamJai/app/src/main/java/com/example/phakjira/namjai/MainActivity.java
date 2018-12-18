package com.example.phakjira.namjai;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int splash_time = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TextView textView = findViewById(R.id.textView);
        ImageView logo = findViewById(R.id.imageView2);
        //ImageView slogan = findViewById(R.id.imageView);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        //textView.startAnimation(myanim);
        logo.startAnimation(myanim);
        //slogan.startAnimation(myanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcomePage = new Intent(MainActivity.this, Welcome.class);
                startActivity(welcomePage);
                finish();
            }
        },splash_time);
    }
}
