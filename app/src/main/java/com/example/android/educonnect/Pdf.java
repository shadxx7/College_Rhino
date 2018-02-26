package com.example.android.educonnect;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;

public class Pdf extends AppCompatActivity {
    PDFView pdfView;
    String[] pdflist;
    File[] imagelist;
    private static int PICK_GALLERY_PDF=1;
    private Button mBtn;
    private StorageReference mStorageRef;
    private ProgressDialog mProgressDialog;
    private Uri downloadUrl;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfView=(PDFView) findViewById(R.id.pdfView);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        mProgressDialog=new ProgressDialog(this);
                Intent intentGalley = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intentGalley.addCategory(Intent.CATEGORY_OPENABLE);
                intentGalley.setType("application/pdf");
                //startActivity(intentGalley);
                startActivityForResult(intentGalley, PICK_GALLERY_PDF);
        firebaseDatabase=FirebaseDatabase.getInstance();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mProgressDialog.setTitle("Uploading pdf to server.Please wait.");
        uploadFile(data);

    }

    private void uploadFile(Intent data) {
        mProgressDialog.show();
        mProgressDialog.setCanceledOnTouchOutside(false);
        Uri pdf=data.getData();
        pdfView.fromUri(pdf).load();
        if(pdf!=null) {

            StorageReference store_place=mStorageRef.child("pdf/"+getFileName(pdf));
            Toast.makeText(Pdf.this,"pdf/"+getFileName(pdf), Toast.LENGTH_SHORT).show();
            String res=getFileName(pdf);
            databaseReference=firebaseDatabase.getReference("Course1").child("pdf").child(res.substring(0,res.length()-4));
            databaseReference.setValue(getFileName(pdf));
            store_place.putFile(pdf).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mProgressDialog.dismiss();
                     //downloadUrl = taskSnapshot.getDownloadUrl();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Pdf.this,"Couldnt upload!", Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                }
            });
        }
    }
    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}