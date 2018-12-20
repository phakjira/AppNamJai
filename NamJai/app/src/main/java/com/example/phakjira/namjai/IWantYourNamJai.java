package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class IWantYourNamJai extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseUser;
    DatabaseReference databaseTutor;
    String tutorID;
    String studentID;
    DatabaseReference databaseChosen;
    DatabaseReference databaseChoose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iwant_your_nam_jai);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseTutor = databaseReference.child("tutor");
        databaseUser = databaseReference.child("user");
        databaseChosen = databaseReference.child("chosen");
        databaseChoose = databaseReference.child("choose");

        Intent go=getIntent();
        tutorID=go.getStringExtra("tutorID");
        studentID=go.getStringExtra("studentID");
        Toast.makeText(this,tutorID,Toast.LENGTH_SHORT).show();

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    User user=dataSnapshot.child(tutorID).getValue(User.class);
                    String name = user.firstName+" "+ user.lastName;
                    //Toast.makeText(getApplication(),name,Toast.LENGTH_SHORT).show();
                    String faculty = user.faculty;
                    String year = user.year;
                    String nickname = user.nickName;
                    /*String contact=tutor.contact;
                    String location=tutor.location;
                    String price=tutor.price;
                    String time=tutor.time;
                    Boolean monday=tutor.monday;
                    Boolean tuesday=tutor.tuesday;
                    Boolean wednesday=tutor.wednesday;
                    Boolean thursday=tutor.thursday;
                    Boolean friday=tutor.friday;
                    Boolean saturday=tutor.saturday;
                    Boolean sunday=tutor.sunday;*/

                    TextView textViewname = findViewById(R.id.getName);
                    TextView textViewfaculty = findViewById(R.id.getFaculty);
                    TextView textViewyear = findViewById(R.id.getYear);
                    TextView textViewnickname = findViewById(R.id.getNickname);
                    /*TextView textViewlocation=findViewById(R.id.getLocation);
                    TextView textViewprice=findViewById(R.id.getPrice);
                    TextView textViewtime=findViewById(R.id.getTime);
                    TextView textViewcontact=findViewById(R.id.getContact);
                    TextView textViewday=findViewById(R.id.getDay);*/
                    textViewnickname.setText(nickname);
                    textViewname.setText(name);
                    textViewyear.setText(year);
                    textViewfaculty.setText(faculty);
                    /*textViewlocation.setText(location);
                    textViewtime.setText(time);
                    textViewprice.setText(price);
                    textViewcontact.setText(contact);
                    if(monday) {
                        textViewday.setText("Monday ");
                    }if(tuesday) {
                        textViewday.setText("Tuesday ");
                    }if(wednesday) {
                        textViewday.setText("Wednesday ");
                    }if(thursday) {
                        textViewday.setText("Thursday ");
                    }if(friday) {
                        textViewday.setText("Friday ");
                    }if(saturday) {
                        textViewday.setText("Saturday ");
                    }if(sunday) {
                        textViewday.setText("Sunday ");
                    }*/


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


        databaseTutor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                Tutor tutor = dataSnapshot.child(tutorID).getValue(Tutor.class);
                //String name = user.firstName+" "+ user.lastName;
                //Toast.makeText(getApplication(),name,Toast.LENGTH_SHORT).show();
                //String faculty = user.faculty;
                //String year = user.year;
                //String nickname = user.nickName;
                String contact=tutor.contact;
                String location=tutor.location;
                String price=tutor.price;
                String time=tutor.time;
                Boolean monday=tutor.monday;
                Boolean tuesday=tutor.tuesday;
                Boolean wednesday=tutor.wednesday;
                Boolean thursday=tutor.thursday;
                Boolean friday=tutor.friday;
                Boolean saturday=tutor.saturday;
                Boolean sunday=tutor.sunday;

                /*TextView textViewname = findViewById(R.id.getName);
                TextView textViewfaculty = findViewById(R.id.getFaculty);
                TextView textViewyear = findViewById(R.id.getYear);
                TextView textViewnickname = findViewById(R.id.getNickname);*/
                TextView textViewlocation=findViewById(R.id.getLocation);
                TextView textViewprice=findViewById(R.id.getPrice);
                TextView textViewtime=findViewById(R.id.getTime);
                TextView textViewcontact=findViewById(R.id.getContact);
                TextView textViewday=findViewById(R.id.getDay);
                //textViewnickname.setText(nickname);
                //textViewname.setText(name);
                //textViewyear.setText(year);
                //textViewfaculty.setText(faculty);
                textViewlocation.setText(location);
                textViewtime.setText(time);
                textViewprice.setText(price);
                textViewcontact.setText(contact);
                String day="";
                if(monday) {
                    day=day+"Monday ";
                }if(tuesday) {
                    day=day+"Tuesday ";
                }if(wednesday) {
                    day=day+"Wednesday ";
                }if(thursday) {
                    day=day+"Thursday ";
                }if(friday) {
                    day=day+"Friday ";
                }if(saturday) {
                    day=day+"Saturday ";
                }if(sunday) {
                    day=day+"Sunday ";
                }
                textViewday.setText(day);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
      }
    public void onClick(View v) {

        databaseChosen.child(tutorID).child(studentID).setValue(studentID);
        databaseChoose.child(studentID).child(tutorID).setValue(tutorID);
        Toast.makeText(this,tutorID,Toast.LENGTH_SHORT).show();
        Intent goyournamjai=new Intent(getApplication(),YourNamJai.class);
        goyournamjai.putExtra("tutorID",tutorID);
        goyournamjai.putExtra("studentID",studentID);
        startActivity(goyournamjai);
    }
}
