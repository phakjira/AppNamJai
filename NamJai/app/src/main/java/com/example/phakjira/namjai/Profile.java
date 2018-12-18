package com.example.phakjira.namjai;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

public class Profile extends AppCompatActivity {

    public String studentID ;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseUser;
    DatabaseReference databaseTutor;

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
                    in1.putExtra("id",studentID);
                    startActivity(in1);
                    return true;
                case R.id.navigation_createnamjai:
                    //TextMessage.setText(R.string.title_notifications);
                    Intent in2 = new Intent(getApplication(),CreateNamjai.class);
                    in2.putExtra("id",studentID);
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

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseTutor = databaseReference.child("tutor");
        databaseUser = databaseReference.child("user");

        Intent intent = getIntent();
        studentID = intent.getStringExtra("id");
        Toast.makeText(this,studentID,Toast.LENGTH_SHORT).show();

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener);

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    User user = dataSnapshot.child(studentID).getValue(User.class);
                    String name = user.firstName+" "+ user.lastName;
                    String faculty = user.faculty;
                    String year = user.year;
                    String email = user.email;
                    String nick = user.nickName;
                    String contact;
                    TextView textViewname = findViewById(R.id.name);
                    TextView textViewfaculty = findViewById(R.id.faculty);
                    TextView textViewyear = findViewById(R.id.year);
                    TextView textViewemail = findViewById(R.id.email);
                    TextView textViewNick = findViewById(R.id.nickname);
                    textViewNick.setText(nick);
                    textViewname.setText(name);
                    textViewemail.setText(email);
                    textViewfaculty.setText(faculty);
                    textViewyear.setText(year);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

//        databaseTutor.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                try{
//                    Tutor tutor = dataSnapshot.child(studentID).getValue(Tutor.class);
//                    String subject = tutor.subject;
//                    String location = tutor.location;
//                    String price = tutor.price;
//                    TextView textViewSubject = findViewById(R.id.subject);
//                    TextView textViewLocation = findViewById(R.id.location);
//                    TextView textViewPrice = findViewById(R.id.)
//                }catch (IOException e){
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });



    }

}
