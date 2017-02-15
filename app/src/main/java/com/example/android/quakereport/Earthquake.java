package com.example.android.quakereport;

/**
 * Created by sergio on 2/14/17.
 */

public class Earthquake {

    private String mLocation;
    private String mMagnitude;
    private String mTime;

    public Earthquake(String location, String magnitude, String time){
        mLocation = location;
        mMagnitude = magnitude;
        mTime = time;
    }

    public String getLocation(){
        return mLocation;
    }

    public String getMagnitude(){
        return mMagnitude;
    }

    public String getTime(){
        return mTime;
    }
}
