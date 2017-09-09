package com.example.android.educonnect;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText mDisplayName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mCreateBtn;
    private FirebaseAuth mAuth;


    private void register_User(String displayName, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{

                        }
                    }
                });
    }

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDisplayName = (EditText) findViewById(R.id.reg_display_name);
        mEmail = (EditText) findViewById(R.id.reg_email);
        mPassword = (EditText) findViewById(R.id.reg_password);
        mCreateBtn = (Button) findViewById(R.id.reg_submit_btn);
        mAuth = FirebaseAuth.getInstance();

//        mToolbar = (Toolbar) findViewById(R.id.register_toolbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setTitle("Register");

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayName = mDisplayName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                register_User(displayName, email, password);
            }
        });
}
}
