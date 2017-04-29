package com.example.android.quakereport;

/**
 * Created by sergio on 2/14/17.
 */

public class Earthquake {

    private String mLocation;
    private double mMagnitude;
    private long mTime;
    private String mUrl;

    public Earthquake(String location, double magnitude, long time, String url){
        mLocation = location;
        mMagnitude = magnitude;
        mTime = time;
        mUrl = url;
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

    public String getUrl(){ return mUrl; }
}