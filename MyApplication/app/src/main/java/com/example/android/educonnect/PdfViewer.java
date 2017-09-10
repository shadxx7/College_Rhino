package com.example.android.educonnect;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class PdfViewer extends AppCompatActivity {

    PDFView pdfView;

    private ProgressDialog progressDialog;

    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        pdfView=(PDFView) findViewById(R.id.pdfViewr);
        firebaseStorage=FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference("Course1").child("pdf");
        progressDialog=new ProgressDialog(this);
        String s = getIntent().getStringExtra(notesFragment.key);

        try {
            progressDialog.setTitle("Downloading from server");
            final File localFile= File.createTempFile("/","pdf");


            pdfView.fromFile(localFile).load();
            storageReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.hide();
                    Toast.makeText(PdfViewer.this,"Stored Path:"+localFile.toString(),Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(PdfViewer.this,"Couldnt store file"+localFile.toString(),Toast.LENGTH_SHORT).show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
