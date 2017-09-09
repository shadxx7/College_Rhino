package com.example.android.educonnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {

    private Button mSignIn;
    private Button mSignUp;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        mSignIn=(Button)findViewById(R.id.auth_signin);
        mSignUp=(Button)findViewById(R.id.auth_signup);

//        mToolbar = (Toolbar) findViewById(R.id.auth_toolbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setTitle("SignIn or SignUp");

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(AuthActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        mSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(AuthActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
