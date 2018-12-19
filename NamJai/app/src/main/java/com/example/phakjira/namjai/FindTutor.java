package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FindTutor extends AppCompatActivity {

    public Spinner spinner;
    public ArrayList<String> selectedsubject=new ArrayList<>();
    public ListView list;
    ArrayList<String> arrayList=new ArrayList<>();
    public Button but;
    public String studentID ;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseUser;
    DatabaseReference databaseTutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tutor);
        list=findViewById(R.id.listView);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseTutor = databaseReference.child("tutor");
        databaseUser = databaseReference.child("user");
        //Intent in=getIntent();
        //studentID = in.getStringExtra("id");
        spinner=findViewById(R.id.spinner);
        addSubjects();

        ArrayAdapter<String> adt = new ArrayAdapter<String>(FindTutor.this, android.R.layout.simple_dropdown_item_1line, selectedsubject);
        spinner.setAdapter(adt);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                databaseUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            String key = child.getKey();
                            final Tutor tutor = dataSnapshot.child(key).getValue(Tutor.class);
                            if (selectedsubject.get(position).equals("Calculus1")) {
                                if(tutor.subject.toString().equalsIgnoreCase("Calculus1") ){
                                    String location=tutor.location;
                                    String price=tutor.price;
                                    arrayList.add(location+"  "+price);
                                    ArrayAdapter<String > adapter=new ArrayAdapter<String>(FindTutor.this,android.R.layout.simple_list_item_1,arrayList);
                                    list.setAdapter(adapter);
                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            //Toast.makeText(getApplicationContext(),"Click ListItem Number " + position, Toast.LENGTH_LONG).show();
                                            Intent go=new Intent(getApplication(),IWantYourNamJai.class);
                                            go.putExtra("tutorid",tutor.studentID);
                                            startActivity(go);
                                        } });
                                }
                            } else if (selectedsubject.get(position).equals("Physics2")) {
                                if(tutor.subject.toString().equalsIgnoreCase("Physics2")) {
                                    String location=tutor.location;
                                    String price=tutor.price;
                                    arrayList.add(location+"  "+price);
                                    ArrayAdapter<String > adapter=new ArrayAdapter<String>(FindTutor.this,android.R.layout.simple_list_item_1,arrayList);
                                    list.setAdapter(adapter); //dont forget to clear arraylist when selecting another subject!!!!!!!
                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            //Toast.makeText(getApplicationContext(),"Click ListItem Number " + position, Toast.LENGTH_LONG).show();
                                            Intent go=new Intent(getApplication(),IWantYourNamJai.class);
                                            go.putExtra("tutorid",tutor.studentID);
                                            startActivity(go);
                                        } });

                            }}

                                /*for (DataSnapshot ds : dataSnapshot.getChildr en()) {
                            Tutor tutor = dataSnapshot.child(studentID).getValue(Tutor.class);
                            final String location = tutor.location;
                            final String price = tutor.price;
                            final String subject=tutor.subject;
                    /*String year = user.year;
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

                    ArrayAdapter<String> adt = new ArrayAdapter<String>(FindTutor.this, android.R.layout.simple_dropdown_item_1line, selectedsubject);
                    spinner.setAdapter(adt);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (selectedsubject.get(position).equals("Calculus1")) {
                                if(tutor.subject)
                                arrayList.add(location+"  "+price);
                                ArrayAdapter<String > adapter=new ArrayAdapter<String>(FindTutor.this,android.R.layout.simple_list_item_1,arrayList);
                                list.setAdapter(adapter);

                            } else if (selectedsubject.get(position).equals("Physics2")) {
                                arrayList.add(location+"  "+price);
                                ArrayAdapter<String > adapter=new ArrayAdapter<String>(FindTutor.this,android.R.layout.simple_list_item_1,arrayList);
                                list.setAdapter(adapter);

                            }*/

                        }}

            @Override
            public void onCancelled(DatabaseError databaseError) {

            } });}

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }

                     });


        }






    public void addSubjects() {
        selectedsubject.add("Calculus1");
        selectedsubject.add("Calculus2");
        selectedsubject.add("Physics1");
        selectedsubject.add("Physics2");

    }






}
