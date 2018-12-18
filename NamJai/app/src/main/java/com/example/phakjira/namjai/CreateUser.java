package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateUser extends AppCompatActivity {
    TextView textViewFirst;
    EditText editTextLast;
    EditText editTextName;
    EditText editTextID;
    Spinner spinnerFaculty;
    Spinner spinnerYear;
    EditText editTextGender;
    EditText editTextNick;
    EditText editTextEmail;

    DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        //textViewFirst = findViewById(R.id.textViewFirst);
        editTextLast = findViewById(R.id.editTextLast);
        editTextName = findViewById(R.id.editTextName);
        editTextID = findViewById(R.id.editTextID);
        spinnerFaculty = findViewById(R.id.spinnerFaculty);
        spinnerYear = findViewById(R.id.spinnerYear);
        editTextGender = findViewById(R.id.editTextGender);
        editTextEmail = findViewById(R.id.editTextemail);
        editTextNick = findViewById(R.id.editTextNick);
        Intent go=getIntent();
        String email=go.getStringExtra("email");
        String gender=go.getStringExtra("gender");
        editTextEmail.setText(email);
        editTextGender.setText(gender);
    }

    public void addUser(){
        String firstName = editTextName.getText().toString().trim();
        String lastName = editTextLast.getText().toString().trim();
        String studentID = editTextID.getText().toString().trim();
        String faculty = spinnerFaculty.getSelectedItem().toString();
        String year = spinnerYear.getSelectedItem().toString();
        String gender = editTextGender.getText().toString();
        String nickName = editTextNick.getText().toString();
        String email = editTextEmail.getText().toString();

        if(!TextUtils.isEmpty(firstName)){
            if(!TextUtils.isEmpty(lastName)){
                if(!TextUtils.isEmpty(studentID)){
                    if(!TextUtils.isEmpty(email)){
                        if(!TextUtils.isEmpty(nickName)){
                            String userId = databaseUser.push().getKey();
                            User user = new User(firstName,lastName,nickName,studentID,faculty,year,gender,email);
                            databaseUser.child(userId).setValue(user);
                            Toast.makeText(this,"New user added",Toast.LENGTH_SHORT).show();
                            Intent in=new Intent(getApplication(),Profile.class);
                            startActivity(in);
                        }else{
                            Toast.makeText(this,"You need to enter your Nickname",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(this,"You need to enter your email",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this,"You need to enter your ID",Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this,"You need to enter your last name",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"You need to enter your first name",Toast.LENGTH_SHORT).show();
        }


    }

    public void onFinish(View v) {
        addUser();
    }
}
