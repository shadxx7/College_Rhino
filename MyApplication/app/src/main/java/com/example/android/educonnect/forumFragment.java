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

import java.util.ArrayList;

public class forumFragment extends Fragment{

    public static String key = "key";
    public forumFragment(){
        //Empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.forum1,container,false);

        final ArrayList<String> arrayList= new ArrayList<String>();
        arrayList.add("String 1");
        arrayList.add("String 2");
        arrayList.add("String 3");
        arrayList.add("String 4");
        arrayList.add("String 5");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(), QuesAns.class);
                intent.putExtra(key, arrayList.get(position));
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


