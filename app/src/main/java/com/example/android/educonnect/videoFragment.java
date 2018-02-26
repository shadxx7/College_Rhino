package com.example.android.educonnect;


import com.google.android.gms.tasks.OnCompleteListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class videoFragment extends Fragment {
    public static final String API_KEY = "AIzaSyDOpiT-vlu-SveEYggS0LbQaOzVhRqF8Y8";
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private TextView mLinkTv;
    private TextView mLinkTv2;
    private TextView mLinkTv3;
    public String VIDEO_ID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.videos1, container, false);

        firebaseDatabase=FirebaseDatabase.getInstance();
        mLinkTv=(TextView)rootView.findViewById(R.id.link1);
        mLinkTv.setText("Signal");
        mLinkTv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                databaseReference=firebaseDatabase.getReference("YoutubeLinks").child("Signal");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String get_link=(String)dataSnapshot.getValue();
                        VIDEO_ID = get_link;
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
            }});

        mLinkTv2=(TextView)rootView.findViewById(R.id.link2);
        mLinkTv2.setText("Analog Signal");
        mLinkTv2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            databaseReference=firebaseDatabase.getReference("YoutubeLinks").child("Analog Signal");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String get_link=(String)dataSnapshot.getValue();
                    VIDEO_ID = get_link;
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });
        }});

        mLinkTv3=(TextView)rootView.findViewById(R.id.link3);
        mLinkTv3.setText("Digital Signal");
        mLinkTv3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                databaseReference=firebaseDatabase.getReference("YoutubeLinks").child("Digital Signal");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String get_link=(String)dataSnapshot.getValue();
                        VIDEO_ID = get_link;
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
            }});

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(API_KEY, new OnInitializedListener() {
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
              if (VIDEO_ID!=null){
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                }
            }}

            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        return rootView;

    }
}