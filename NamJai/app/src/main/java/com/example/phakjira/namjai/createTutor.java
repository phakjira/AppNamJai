package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class createTutor extends AppCompatActivity {

    public RadioButton radio1;
    public RadioButton radio2;
    public RadioButton radio3;
    public RadioButton radio4;
    public RadioButton radio5;
    public RadioButton radio6;
    public RadioButton radio7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tutor);

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{
                "Calculus1", "Calculus2", "Physics1","Physics2","Engineering Material","Engineering Drawing","JAVA","Communicative English"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        Intent intent = getIntent();

        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);
        radio4 = (RadioButton) findViewById(R.id.radio4);
        radio5 = (RadioButton) findViewById(R.id.radio5);
        radio6 = (RadioButton) findViewById(R.id.radio6);
        radio7 = (RadioButton) findViewById(R.id.radio7);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.radio1:
                if(radio1.isSelected()){
                    radio1.setSelected(false);
                    radio1.setChecked(false);
                } else {
                    radio1.setSelected(true);
                    radio1.setChecked(true);
                }
                break;

            case R.id.radio2:
                if(radio2.isSelected()){
                    radio2.setSelected(false);
                    radio2.setChecked(false);
                } else {
                    radio2.setSelected(true);
                    radio2.setChecked(true);
                }
                break;

            case R.id.radio3:
                if(radio3.isSelected()){
                    radio3.setSelected(false);
                    radio3.setChecked(false);
                } else {
                    radio3.setSelected(true);
                    radio3.setChecked(true);
                }
                break;

            case R.id.radio4:
                if(radio4.isSelected()){
                    radio4.setSelected(false);
                    radio4.setChecked(false);
                } else {
                    radio4.setSelected(true);
                    radio4.setChecked(true);
                }
                break;

            case R.id.radio5:
                if(radio5.isSelected()){
                    radio5.setSelected(false);
                    radio5.setChecked(false);
                } else {
                    radio5.setSelected(true);
                    radio5.setChecked(true);
                }
                break;

            case R.id.radio6:
                if(radio6.isSelected()){
                    radio6.setSelected(false);
                    radio6.setChecked(false);
                } else {
                    radio6.setSelected(true);
                    radio6.setChecked(true);
                }
                break;

            case R.id.radio7:
                if(radio7.isSelected()){
                    radio7.setSelected(false);
                    radio7.setChecked(false);
                } else {
                    radio7.setSelected(true);
                    radio7.setChecked(true);
                }
                break;
        }
    }
}
