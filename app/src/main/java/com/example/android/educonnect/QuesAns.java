package com.example.android.educonnect;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class QuesAns extends AppCompatActivity {
    private TextView mQuestion;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private EditText mComment;
    private ImageView mSendBtn;

    public ArrayList<String> key_arrayList;
    private  DatabaseReference myRef2;
    public ArrayList<String> value_arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_ans);


        database=FirebaseDatabase.getInstance();


        key_arrayList= new ArrayList<String>();
        value_arrayList= new ArrayList<String>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,value_arrayList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

            /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);

                return view;
            }

        };


        mQuestion=(TextView)findViewById(R.id.ques);
        mComment=(EditText) findViewById(R.id.comment);
        mSendBtn=(ImageView) findViewById(R.id.send_btn);

        String s = getIntent().getStringExtra(forumFragment.key);
        myRef=database.getReference("Course1").child("Question").child("Q"+(forumFragment.keySize));
        mQuestion.setText(s);

        myRef2=database.getReference("Course1").child("Comment");

        myRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                key_arrayList.add(dataSnapshot.getKey());
                value_arrayList.add(dataSnapshot.getValue().toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                key_arrayList.add(dataSnapshot.getKey());
                value_arrayList.add(dataSnapshot.getValue().toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);



        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                DatabaseReference refComment=database.getReference("Course1").child("Comment").child("Q"+forumFragment.keySize+""+Integer.toString(random.nextInt()%1000));
                String get_comment=mComment.getText().toString();
                refComment.setValue(get_comment);
                mComment.setText("");
            }
        });

    }
}
