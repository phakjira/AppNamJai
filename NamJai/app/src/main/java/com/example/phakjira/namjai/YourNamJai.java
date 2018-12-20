package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    DatabaseReference databaseChosen;
    DatabaseReference databaseChoose;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_nam_jai);
        this.setTitle("Your NamJai");
        Intent intent=getIntent();
//        tutorID=goyournamjai.getStringExtra("tutorID");
        studentID=intent.getStringExtra("studentID");
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseTutor = databaseReference.child("tutor");
        databaseUser = databaseReference.child("user");
        databaseChosen = databaseReference.child("chosen").child(studentID);
        databaseChoose = databaseReference.child("choose").child(studentID);
//        toast(studentID);



//
        databaseChoose.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final ListView list;
                list = findViewById(R.id.listViewnamjaiyouchoose);
                final ArrayList<String> arrayList = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = ds.getKey();
                    final String theTutorID = dataSnapshot.child(key).getValue().toString();
                    databaseUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            User user = dataSnapshot.child(theTutorID).getValue(User.class);
                            final String name = user.firstName + " " + user.lastName;
                            databaseTutor.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Tutor tutor = dataSnapshot.child(theTutorID).getValue(Tutor.class);
                                    String subject = tutor.subject;
                                    arrayList.add("Tutor: " + name + " ,Subject: " + subject);
                                    ArrayAdapter<String> adapter = new ArrayAdapter<>(YourNamJai.this, android.R.layout.simple_list_item_1, arrayList);
                                    list.setAdapter(adapter);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

//        final ArrayList<String> arrayList1=new ArrayList<>();
//        final ListView list1;
//        list1=findViewById(R.id.listViewnamjaiischosen);
        databaseChosen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final ArrayList<String> arrayList1=new ArrayList<>();
                final ListView list1;
                String a = "";
                list1=findViewById(R.id.listViewnamjaiischosen);
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    String key = ds.getKey();
                    toast(key);
                    final String id = dataSnapshot.child(key).getValue().toString();
//                    int b = id.indexOf("=");
//                    final String userID = id.substring(1,b);
                    a = a + id + " ";
                    databaseUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            User user = dataSnapshot.child(id).getValue(User.class);
                            arrayList1.add("Name: "+ user.firstName+ "\n"+ user.lastName+ " Nickname:  "+user.nickName);
                            ArrayAdapter<String > adapter=new ArrayAdapter<>(YourNamJai.this,android.R.layout.simple_list_item_1,arrayList1);
                            list1.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    toast(a);

                }
            }
//
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//





    }

    public void toast(String a ){
        Toast.makeText(getApplication(),a,Toast.LENGTH_SHORT).show();
    }
}
