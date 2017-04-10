package com.example.android.quakereport;

/**
 * Created by sergio on 2/14/17.
 */

public class Earthquake {

    private String mLocation;
    private double mMagnitude;
    private long mTime;

    public Earthquake(String location, double magnitude, long time){
        mLocation = location;
        mMagnitude = magnitude;
        mTime = time;
    }

    public String getLocation(){
        return mLocation;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public long getTime(){
        return mTime;
    }
}