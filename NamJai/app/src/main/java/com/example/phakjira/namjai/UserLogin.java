package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserLogin extends AppCompatActivity {

    EditText editTextInputID;
    EditText getEditTextInputLast;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseUser;
    public static String studentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        editTextInputID = findViewById(R.id.editTextInputID);
        getEditTextInputLast = findViewById(R.id.editTextInputLast);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseUser = databaseReference.child("user");


    }

    public void onLogin(View view){
        final String studentID = editTextInputID.getText().toString();
        final String lastName = getEditTextInputLast.getText().toString();
        Toast.makeText(this,studentID,Toast.LENGTH_SHORT).show();
        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String key = child.getKey();
                    User user = dataSnapshot.child(key).getValue(User.class);
                    if(user.studentID.toString().equalsIgnoreCase(studentID) && user.lastName.toString().equalsIgnoreCase(lastName)){

                        Intent intent = new Intent(getApplication(),Profile.class);
                        intent.putExtra("id",studentID);
                        startActivity(intent);
                        break;

                    }
                    else {
//                        Toast.makeText(getApplication(),"Incorrect ID or Last name",Toast.LENGTH_SHORT).show();
                    }

//                    Toast.makeText(getApplication(),"Incorrect ID or Last name",Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

//        Toast.makeText(getApplication(),"Incorrect ID or Last name",Toast.LENGTH_SHORT).show();

    }
    public void onclick (View v) {
        Intent go=new Intent(getApplication(),Profile.class);
        startActivity(go);//just add to try findtutor class because its bugggg yayy
    }
}
