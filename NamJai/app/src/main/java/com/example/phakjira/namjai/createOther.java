package com.example.phakjira.namjai;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.provider.MediaStore;
import android.net.Uri;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class createOther extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView imageToUpload;
    Button uploadImage;
    public Uri imageUri;
    DatabaseReference databaseOther;
    StorageReference mStorageRef;
    Uri selectedImage;
    String studentID;
    EditText editTextOtherName;
    EditText editTextDescription;
    Spinner spinnerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_other);

        imageToUpload = (ImageView) findViewById(R.id.imageToUpload);
        uploadImage = (Button) findViewById(R.id.uploadImage);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerName = findViewById(R.id.spinnerNameOther);

        databaseOther = FirebaseDatabase.getInstance().getReference("others");
//        mStorageRef = FirebaseStorage.getInstance().getReference();
        Intent intent = getIntent();
        studentID = intent.getStringExtra("id");

    }

    public void onClickUpload(View v){
        switch(v.getId()){
            case R.id.uploadImage:
                Intent galleryIntent = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            selectedImage = data.getData();
            imageToUpload.setImageURI(selectedImage);
        }
    }

    public void uploadother(){
        String name = spinnerName.getSelectedItem().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        if(!TextUtils.isEmpty(name)){
            if(!TextUtils.isEmpty(description)){
                RandomNamJai randomNamJai = new RandomNamJai(name,description);
                databaseOther.child(studentID).setValue(randomNamJai);
                Intent intent = new Intent(getApplication(),Profile.class);
                intent.putExtra("id",studentID);
                startActivity(intent);
            }
        }else{

        }

    }

    public void onCreateOther(View view){
        uploadother();
    }

//    public void upLoadFile(View view){
//        Toast.makeText(this,selectedImage.toString(),Toast.LENGTH_SHORT).show();
//        final String name = editTextOtherName.getText().toString();
//        final String otherDescription = editTextDescription.getText().toString();
//        if(selectedImage != null){
//            final ProgressDialog progressDialog = new ProgressDialog(this);
//            StorageReference fileReference = storageReference.child(System.currentTimeMillis()+"."+getFileExtension(selectedImage));
//            fileReference.putFile(selectedImage)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            progressDialog.dismiss();
//                            Toast.makeText(getApplication(),"upload successful",Toast.LENGTH_SHORT).show();
//                            NamJai namJai = new NamJai(studentID, name, otherDescription, taskSnapshot.getDownloadUrl().toString());
//                            databaseOther.child(studentID).setValue(namJai);
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    progressDialog.dismiss();
//                    Toast.makeText(getApplication(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }else{
//            Toast.makeText(this,"No file is selected",Toast.LENGTH_SHORT).show();
//        }
//    }

    public String getFileExtension(Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }


}
