package com.example.android.educonnect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class notesFragment extends Fragment{

    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    public ArrayList<String> key_arrayList;
    public ArrayList<String> value_arrayList;
    public static String key = "key2";

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.notes1,container,false);

        database=FirebaseDatabase.getInstance();

        key_arrayList= new ArrayList<String>();
        value_arrayList= new ArrayList<String>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1,value_arrayList);

        myRef=database.getReference("Course1").child("pdf");
        myRef.addChildEventListener(new ChildEventListener() {
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
        ListView listView = (ListView) rootView.findViewById(R.id.list2);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(), PdfViewer.class);
                intent.putExtra(key, value_arrayList.get(position));
                startActivity(intent);

            }
        });

        return rootView;
    }
}


