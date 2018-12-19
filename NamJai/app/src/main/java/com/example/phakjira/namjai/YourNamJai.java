package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class YourNamJai extends AppCompatActivity {

    String tutorID;
    String studentID;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseUser;
    DatabaseReference databaseTutor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_nam_jai);
        this.setTitle("Your NamJai");
        Intent goyournamjai=getIntent();
        tutorID=goyournamjai.getStringExtra("tutorID");
        studentID=goyournamjai.getStringExtra("studentID");
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseTutor = databaseReference.child("tutor");
        databaseUser = databaseReference.child("user");

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text="";
                //for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    final ListView list;
                    list=findViewById(R.id.listViewnamjaiyouchoose);
                    final ArrayList<String> arrayList=new ArrayList<>();
                    User user = dataSnapshot.child(studentID).getValue(User.class);
                    User usertutor=dataSnapshot.child(tutorID).getValue(User.class);
                    final String name = usertutor.firstName+" "+ usertutor.lastName;



                //}

                databaseTutor.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String text2="";
                        //for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            Tutor tutor=dataSnapshot.child(tutorID).getValue(Tutor.class);
                            String subject = tutor.subject;
                            arrayList.add("Tutor: "+name+" ,Subject: "+subject);
                            ArrayAdapter<String > adapter=new ArrayAdapter<>(YourNamJai.this,android.R.layout.simple_list_item_1,arrayList);
                            list.setAdapter(adapter);

                       // }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });








    }
}
