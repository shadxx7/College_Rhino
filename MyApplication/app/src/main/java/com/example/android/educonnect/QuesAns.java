package com.example.android.educonnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QuesAns extends AppCompatActivity {
    private TextView mQuestion;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private EditText mComment;
    private Button  mSendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_ans);

        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Course1").child("Question");

        mQuestion=(TextView)findViewById(R.id.ques);
        mComment=(EditText) findViewById(R.id.comment);
        mSendBtn=(Button) findViewById(R.id.send_btn);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = (String)dataSnapshot.getValue();
                mQuestion.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference refComment=database.getReference("Course1").child("Comment");
                String get_comment=mComment.getText().toString();
                refComment.setValue(get_comment);
                mComment.setText("");
            }
        });

    }
}
