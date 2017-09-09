package com.example.android.educonnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddQues extends AppCompatActivity {

    private EditText mQuesAsk;
    private ImageView mBtnAsk;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ques);

        mQuesAsk=(EditText)findViewById(R.id.Ques_ask);
        mBtnAsk=(ImageView) findViewById(R.id.ask_btn);

         database= FirebaseDatabase.getInstance();
         myRef = database.getReference("Course1").child("Question");
         mBtnAsk.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                String get_Ques=mQuesAsk.getText().toString();
                 myRef.setValue(get_Ques);
                 mQuesAsk.setText("");
                 Intent intent=new Intent(AddQues.this,Course1.class);
                 startActivity(intent);
                 finish();
             }
         });

    }
}
