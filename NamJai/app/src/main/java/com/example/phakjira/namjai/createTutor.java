package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createTutor extends AppCompatActivity {

    public RadioButton radio1;
    public RadioButton radio2;
    public RadioButton radio3;
    public RadioButton radio4;
    public RadioButton radio5;
    public RadioButton radio6;
    public RadioButton radio7;
    public Spinner spinnerSubject;
    public EditText editTextTime;
    public EditText editTextLocation;
    public EditText editTextPrice;
    public EditText editTextContact;
    public boolean monday;
    public boolean tuesday;
    public boolean wednesday;
    public boolean thursday;
    public boolean friday;
    public boolean saturday;
    public boolean sunday;
    public String studentID;
    public String nickName;
    DatabaseReference databaseTutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tutor);
        Intent intent = getIntent();

        studentID = intent.getStringExtra("id");
        toast(studentID);

        databaseTutor = FirebaseDatabase.getInstance().getReference("tutor");

        //get the spinner from the xml.
        spinnerSubject = findViewById(R.id.spinnerSubject);
        String[] items = new String[]{
                "Calculus1", "Calculus2", "Physics1","Physics2","Engineering Material","Engineering Drawing","JAVA","Communicative English"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        spinnerSubject.setAdapter(adapter);


        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);
        radio4 = (RadioButton) findViewById(R.id.radio4);
        radio5 = (RadioButton) findViewById(R.id.radio5);
        radio6 = (RadioButton) findViewById(R.id.radio6);
        radio7 = (RadioButton) findViewById(R.id.radio7);
        editTextLocation = findViewById(R.id.editTextLocation);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextTime = findViewById(R.id.editTextTime);
        editTextContact=findViewById(R.id.editTextContact);
        monday = false;
        tuesday = false;
        wednesday = false;
        thursday = false;
        friday = false;
        saturday = false;
        sunday = false;
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.radio1:
                if(radio1.isSelected()){
                    radio1.setSelected(false);
                    radio1.setChecked(false);
                    monday = false;
                } else {
                    radio1.setSelected(true);
                    radio1.setChecked(true);
                    monday = true;
                }
                break;

            case R.id.radio2:
                if(radio2.isSelected()){
                    radio2.setSelected(false);
                    radio2.setChecked(false);
                    tuesday = false;
                } else {
                    radio2.setSelected(true);
                    radio2.setChecked(true);
                    tuesday = true;
                }
                break;

            case R.id.radio3:
                if(radio3.isSelected()){
                    radio3.setSelected(false);
                    radio3.setChecked(false);
                    wednesday = false;
                } else {
                    radio3.setSelected(true);
                    radio3.setChecked(true);
                    wednesday = true;
                }
                break;

            case R.id.radio4:
                if(radio4.isSelected()){
                    radio4.setSelected(false);
                    radio4.setChecked(false);
                    thursday = false;
                } else {
                    radio4.setSelected(true);
                    radio4.setChecked(true);
                    thursday = true;
                }
                break;

            case R.id.radio5:
                if(radio5.isSelected()){
                    radio5.setSelected(false);
                    radio5.setChecked(false);
                    friday = false;
                } else {
                    radio5.setSelected(true);
                    radio5.setChecked(true);
                    friday = true;
                }
                break;

            case R.id.radio6:
                if(radio6.isSelected()){
                    radio6.setSelected(false);
                    radio6.setChecked(false);
                    saturday = false;
                } else {
                    radio6.setSelected(true);
                    radio6.setChecked(true);
                    saturday = true;
                }
                break;

            case R.id.radio7:
                if(radio7.isSelected()){
                    radio7.setSelected(false);
                    radio7.setChecked(false);
                    sunday = false;
                } else {
                    radio7.setSelected(true);
                    radio7.setChecked(true);
                    sunday = true;
                }
                break;
        }
    }

    public void addTutor(){
        String subject = spinnerSubject.getSelectedItem().toString();
        String price = editTextPrice.getText().toString().trim();
        String location = editTextLocation.getText().toString().trim();
        String time = editTextTime.getText().toString().trim();
        String contact=editTextContact.getText().toString().trim();
        if(!TextUtils.isEmpty(contact)) {
            if (!TextUtils.isEmpty(price)) {
                if (!TextUtils.isEmpty(location)) {
                    if (!TextUtils.isEmpty(time)) {
                        Tutor tutor = new Tutor(studentID, monday, tuesday, wednesday, thursday, friday, saturday, sunday, time, subject, location, price, contact);
                        toast("you make it here");
                        databaseTutor.child(studentID).setValue(tutor);
                        Toast.makeText(this, "New tutor added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, YourNamJai.class);
                        startActivity(intent);
                    } else {
                        toast("You need to specify the time first");
                    }
                } else {
                    toast("You need to specify the location");
                }
            } else {
                toast("You need to specify the price first");
            }
        }else {
            toast("You need to specify the contact first");
        }
    }

    public void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void onClickedFinished(View view){
        addTutor();
    }

}
