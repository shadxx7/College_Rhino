package com.example.android.educonnect;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuthListener;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarToggle;
    private NavigationView navigationView;

    private TextView mCourseName;
    private TextView mProf;
    private TextView mCredits;
    private TextView mCriteria;
    private TextView mPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuthListener=FirebaseAuth.getInstance();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mActionBarToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mActionBarToggle);
        mActionBarToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView course1 = (TextView) findViewById(R.id.course_1);
        course1.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent course1Intent = new Intent(MainActivity.this, Course1.class);

                // Start the new activity
                startActivity(course1Intent);
            }
        });

        course1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialogue, null);
                variables(mView);
                mCourseName.setText("Science, Technology and Society");
                mProf.setText("Madhumita Majmudar");
                mCredits.setText("Credits: 4");
                mCriteria.setText("Attendance twice a week");
                mPercentage.setText("100%");
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                return true;
            }
        });

        TextView course2 = (TextView) findViewById(R.id.course_2);
        course2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent course2Intent = new Intent(MainActivity.this, Course2.class);

                // Start the new activity
                startActivity(course2Intent);
            }
        });

        course2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialogue, null);
                variables(mView);
                mCourseName.setText("Signals and System");
                mProf.setText("Manish Narwaria");
                mCredits.setText("Credits: 4");
                mCriteria.setText("No Attendance");
                mPercentage.setText("");

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                return true;
            }
        });

        TextView course3 = (TextView) findViewById(R.id.course_3);
        course3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent course3Intent = new Intent(MainActivity.this, Course3.class);

                // Start the new activity
                startActivity(course3Intent);
            }
        });

        course3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialogue, null);
                variables(mView);
                mCourseName.setText("Design and Analysis of Algorithms");
                mProf.setText("Rahul Muthu");
                mCredits.setText("Credits: 4");
                mCriteria.setText("No Attendance");
                mPercentage.setText("");

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                return true;
            }
        });

        TextView course4 = (TextView) findViewById(R.id.course_4);
        course4.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent course4Intent = new Intent(MainActivity.this, Course4.class);

                // Start the new activity
                startActivity(course4Intent);
            }
        });

        course4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialogue, null);
                variables(mView);
                mCourseName.setText("Computer Systems Organization");
                mProf.setText("Naresh Jotwani");
                mCredits.setText("Credits: 4.5");
                mCriteria.setText("No Attendance");
                mPercentage.setText("");

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                return true;
            }
        });

        TextView course5 = (TextView) findViewById(R.id.course_5);
        course5.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent course5Intent = new Intent(MainActivity.this, Course5.class);

                // Start the new activity
                startActivity(course5Intent);
            }
        });

        course5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialogue, null);
                variables(mView);
                mCourseName.setText("Electromagnetic Theory");
                mProf.setText("Gautam Datta");
                mCredits.setText("Credits: 4");
                mCriteria.setText("No Attendance");
                mPercentage.setText("");

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                return true;
            }
        });

        TextView course6 = (TextView) findViewById(R.id.course_6);
        course6.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent course6Intent = new Intent(MainActivity.this, Course6.class);

                // Start the new activity
                startActivity(course6Intent);
            }
        });

        course6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialogue, null);
                variables(mView);
                mCourseName.setText("Groups and Linear Algebera");
                mProf.setText("Jaideep Mulhelkar");
                mCredits.setText("Credits: 4");
                mCriteria.setText("No Attendance");
                mPercentage.setText("");

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                return true;
            }
        });

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        goToDashboard();
                        break;
                    case R.id.calendar:
                        goToCalendar();
                        break;
                    case R.id.logout:
                        goLogout();
                        break;
//                    case R.id.upload:
//                        goUpload();
//                        break;
                }
                return true;
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mActionBarToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    private void goToDashboard(){
        // Create a new intent to open the {@link NumbersActivity}
        Intent dashboardIntent = new Intent(MainActivity.this, MainActivity.class);

        // Start the new activity
        startActivity(dashboardIntent);
    }

    private void goToCalendar(){
        // Create a new intent to open the {@link NumbersActivity}
        Intent calendarIntent = new Intent(MainActivity.this, Calendar.class);

        // Start the new activity
        startActivity(calendarIntent);
    }

    private void goLogout(){
        // Create a new intent to open the {@link NumbersActivity}
        Intent logoutIntent = new Intent(MainActivity.this, AuthActivity.class);

        // Start the new activity
        startActivity(logoutIntent);
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuthListener.getCurrentUser();
        if(currentUser==null) {
            Intent intent = new Intent(MainActivity.this, AuthActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void variables(View mView){
        mCourseName = (TextView) mView.findViewById(R.id.courseName);
        mProf = (TextView) mView.findViewById(R.id.prof);
        mCredits = (TextView) mView.findViewById(R.id.credits);
        mCriteria = (TextView) mView.findViewById(R.id.criteria);
        mPercentage = (TextView) mView.findViewById(R.id.percentage);
    }
}
