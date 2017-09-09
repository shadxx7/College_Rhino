package com.example.android.educonnect;

/**
 * Created by monil on 9/9/17.
 */

public class CourseInfo {


    //Private variables
    private String mCourseName;
    private String mProf;
    private int mCredits;
    private String mCriteria;
    private int mPercentage;

    public CourseInfo(String courseName, String prof, int credits, String criteria, int percentage){
        mCourseName = courseName;
        mProf = prof;
        mCredits = credits;
        mCriteria = criteria;
        mPercentage = percentage;
    }

    //Getter methods
    public String getmCourseName() {return mCourseName;}
    public String getmProf() {return mProf;}
    public int getmCredits() {return mCredits;}
    public String getmCriteria() {return mCriteria;}
    public int getmPercentage() {return mPercentage;}
}
