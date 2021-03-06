package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.annotation.NonNull;
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
//    public ArrayList<String> selectedsubject=new ArrayList<>();
//    public ListView list;
//    ArrayList<String> arrayList=new ArrayList<>();
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
//        list=findViewById(R.id.listView);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseTutor = databaseReference.child("tutor");
        databaseUser = databaseReference.child("user");
        Intent findtutor=getIntent();
        studentID = findtutor.getStringExtra("id");
        spinner=findViewById(R.id.spinner);
//        addSubjects();


//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
//                if (selectedsubject.get(position).equalsIgnoreCase("Calculus1")) {
//                Toast.makeText(getApplication(), "YOu made it gurl", Toast.LENGTH_SHORT).show();}
//                if (selectedsubject.get(position).equalsIgnoreCase("Calculus2")) {
//                    Toast.makeText(getApplication(), "YOu made it gurl2", Toast.LENGTH_SHORT).show();}
//                databaseUser.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
////                        for (DataSnapshot child : dataSnapshot.getChildren()) {
////                            String key = child.getKey();
//                            final
//                            Tutor tutor = dataSnapshot.child("6031815021").getValue(Tutor.class);
//                            Toast.makeText(getApplication(),selectedsubject.get(position),Toast.LENGTH_SHORT).show();
//                            if (selectedsubject.get(position).equals("Calculus1")) {
//                                Toast.makeText(getApplication(),"YOu made it ", Toast.LENGTH_SHORT).show();
//                                if(tutor.subject.toString().equalsIgnoreCase("Calculus1") ){
//                                    String location=tutor.location;
//                                    String price=tutor.price;
//                                    arrayList.add(location+"  "+price);
//                                    ArrayAdapter<String > adapter=new ArrayAdapter<>(FindTutor.this,android.R.layout.simple_list_item_1,arrayList);
//                                    list.setAdapter(adapter);
//                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                        @Override
//                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                            //Toast.makeText(getApplicationContext(),"Click ListItem Number " + position, Toast.LENGTH_LONG).show();
//                                            Intent go=new Intent(getApplication(),IWantYourNamJai.class);
//                                            go.putExtra("tutorid",tutor.studentID);
//                                            startActivity(go);
//                                        } });
//                                }
//                            } else if (selectedsubject.get(position).equals("Physics2")) {
//                                if(tutor.subject.toString().equalsIgnoreCase("Physics2")) {
//                                    String location=tutor.location;
//                                    String price=tutor.price;
//                                    arrayList.add(location+"  "+price);
//                                    ArrayAdapter<String > adapter=new ArrayAdapter<>(FindTutor.this,android.R.layout.simple_list_item_1,arrayList);
//                                    list.setAdapter(adapter); //dont forget to clear arraylist when selecting another subject!!!!!!!
//                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                        @Override
//                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                            //Toast.makeText(getApplicationContext(),"Click ListItem Number " + position, Toast.LENGTH_LONG).show();
//                                            Intent go=new Intent(getApplication(),IWantYourNamJai.class);
//                                            go.putExtra("tutorid",tutor.studentID);
//                                            startActivity(go);
//                                        } });
//
//                            }}
//
//
//                        }/*}*/
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            } });}
//
//                @Override
//                public void onNothingSelected (AdapterView < ? > parent){
//
//                }
//
//               });


        }


        public void onSearch(View view){
//            ArrayAdapter<String> adt = new ArrayAdapter<String>(FindTutor.this, android.R.layout.simple_dropdown_item_1line, R);
//            spinner.setAdapter(adt);
            databaseTutor.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final ListView list;
                    list=findViewById(R.id.listView);
                    ArrayList<String> arrayList=new ArrayList<>();
                    String location;
                    String price;
                    final ArrayList<Tutor> theTutors = new ArrayList<>();

                    String a ="";
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        String key = child.getKey();
                        final Tutor tutor = dataSnapshot.child(key).getValue(Tutor.class);
                        location = tutor.location;
                        price = tutor.price;
                        if(spinner.getSelectedItem().toString().equalsIgnoreCase(tutor.subject)){
                            a = a+ location + " " + price+" "+studentID;
                            theTutors.add(tutor);
                            arrayList.add("Location: " + location+"   "+" Price: "+price);
                        }
                        Toast.makeText(getApplication(), a, Toast.LENGTH_SHORT).show();

                    }
                    ArrayAdapter<String > adapter=new ArrayAdapter<>(FindTutor.this,android.R.layout.simple_list_item_1,arrayList);
                    list.setAdapter(adapter);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //Toast.makeText(getApplicationContext(),"Click ListItem Number " + position, Toast.LENGTH_LONG).show();

                            String studentID1 =  theTutors.get(position).studentID;
                            Toast.makeText(getApplication(),studentID1,Toast.LENGTH_SHORT).show();
                            Intent go=new Intent(getApplication(),IWantYourNamJai.class);
                            go.putExtra("tutorID", studentID1);
                            go.putExtra("studentID",studentID);
                            startActivity(go);
                            } });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


//list.getItemAtPosition(position).toString()



//    public void addSubjects() {
//        selectedsubject.add("Calculus1");
//        selectedsubject.add("Calculus2");
//        selectedsubject.add("Physics1");
//        selectedsubject.add("Physics2");
//
//    }






}
