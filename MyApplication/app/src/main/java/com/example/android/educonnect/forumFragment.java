package com.example.android.educonnect;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class forumFragment extends Fragment{


    private FirebaseDatabase database;
    private DatabaseReference myRef;
    public static String key = "key";
    private HashMap<String,String> fetch_Question;
    public ArrayList<String> key_arrayList;
    public static String keySize;
    public ArrayList<String> value_arrayList;

    public forumFragment(){
        //Empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.forum1,container,false);

        database=FirebaseDatabase.getInstance();
        fetch_Question=new HashMap<>();



         key_arrayList= new ArrayList<String>();
          value_arrayList= new ArrayList<String>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1,value_arrayList);


        myRef=database.getReference("Course1").child("Question");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                key_arrayList.add(dataSnapshot.getKey());
                int IntkeySize=key_arrayList.size();
                keySize=Integer.toString(IntkeySize+1);
                value_arrayList.add(dataSnapshot.getValue().toString());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                key_arrayList.add(dataSnapshot.getKey());
                int IntkeySize=key_arrayList.size();
                keySize=Integer.toString(IntkeySize+1);
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



        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(), QuesAns.class);
                intent.putExtra(key, value_arrayList.get(position));
                startActivity(intent);

            }
        });

        FloatingActionButton button = (FloatingActionButton) rootView.findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addQ = new Intent(getContext(), AddQues.class);
                startActivity(addQ);
            }
        });

        return rootView;
    }


}


