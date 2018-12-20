package com.example.phakjira.namjai;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FindOthers extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseOther;


    ListView simpleList;
    /*String  name[] = {"Textbook", "Calculator", "Neck tie", "Peppermint", "T-ruler", "Stationary", "Goggle", "Hair Tie"};
    String  description[] = {"The apple tree is a deciduous tree in the rose family best known for its sweet, pomaceous fruit, the apple.",
            "The banana is an edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa.",
            "The lemon, Citrus limon Osbeck, is a species of small evergreen tree in the flowering plant family Rutaceae, native to Asia.",
            "A cherry is the fruit of many plants of the genus Prunus, and is a fleshy drupe.",
            "The garden strawberry is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries.",
            "The avocado is a tree, long thought to have originated in South Central Mexico, classified as a member of the flowering plant family Lauraceae."};*/
    //int flags[] = {R.drawable.Hair, R.drawable.T_ruler, R.drawable.book, R.drawable.calculator, R.drawable.goldie, R.drawable.goldie};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_others);

        databaseReference = firebaseDatabase.getInstance().getReference();
        databaseOther = databaseReference.child("others");

        databaseOther.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                simpleList = (ListView)findViewById(R.id.listView);
                ArrayList<String> arrayListName=new ArrayList<>();
                ArrayList<String> arrayListDescription = new ArrayList<>();
                ArrayList<Integer> arrayListImage = new ArrayList<>();
                for(DataSnapshot ds: dataSnapshot.getChildren()) {
                    String key = ds.getKey();
                    toast(key);
                    RandomNamJai randomNamJai = dataSnapshot.child(key).getValue(RandomNamJai.class);
                    String description = randomNamJai.description;
                    String name = randomNamJai.name.toString();
                    arrayListName.add(name);
                    arrayListDescription.add(description);
                    if(name.equalsIgnoreCase("Textbook")){
                        arrayListImage.add(R.drawable.book);
                    }else if(name.equalsIgnoreCase("Calculator")){
                        arrayListImage.add(R.drawable.calculator);
                    }else if(name.equalsIgnoreCase("Neck tie")){
                        arrayListImage.add(R.drawable.necktie);
                    }else if(name.equalsIgnoreCase("Peppermint")){
                        arrayListImage.add(R.drawable.peppermint);
                    }else if(name.equalsIgnoreCase("T-ruler")){
                        arrayListImage.add(R.drawable.truler);
                    }else if(name.equalsIgnoreCase("Stationary")){
                        arrayListImage.add(R.drawable.stationary);
                    }else if(name.equalsIgnoreCase("Goggle")){
                        arrayListImage.add(R.drawable.goggle);
                    }else if(name.equalsIgnoreCase("Hair tie")){
                        arrayListImage.add(R.drawable.hair);
                    }else{
                        arrayListImage.add(R.drawable.goldie);
                    }
//                    switch (name) {
//                        case "Textbook":
//                            arrayListImage.add(R.drawable.book);
//                            break;
//                        case  "Calculator":
//                            arrayListImage.add(R.drawable.calculator);
//                            break;
//                        case  "Neck tie":
//                            arrayListImage.add(R.drawable.necktie);
//                            break;
//                        case  "Peppermint":
//                            arrayListImage.add(R.drawable.peppermint);
//                            break;
//                        case  "T-ruler":
//                            arrayListImage.add(R.drawable.truler);
//                            break;
//                        case  "Stationary":
//                            arrayListImage.add(R.drawable.stationary);
//                            break;
//                        case  "Goggle":
//                            arrayListImage.add(R.drawable.goggle);
//                            break;
//                        case  "Hair Tie":
//                            arrayListImage.add(R.drawable.hair);
//                            break;
//                        default:
//                            arrayListImage.add(R.drawable.goldie);
//                    }

                }

                CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), arrayListName, arrayListDescription, arrayListImage);
                simpleList.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        simpleList = (ListView)findViewById(R.id.listView);
//
//        ArrayList<String> arrayList=new ArrayList<>();
//
//
//        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), name, description, flags);
//        simpleList.setAdapter(customAdapter);
    }

    public void toast(String hi){
        Toast.makeText(this,hi,Toast.LENGTH_SHORT).show();
    }
}
