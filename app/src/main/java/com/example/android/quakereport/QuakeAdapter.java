package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sergio on 2/14/17.
 */

public class QuakeAdapter extends ArrayAdapter<Earthquake> {

    public QuakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    private String[] splitLocation(String location){
        String[] separated = location.split(" of ");
        return separated;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        // Set Magnitude Text
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        String formattedMagnitude = magnitudeFormat.format(earthquake.getMagnitude());
        magnitude.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Get location text and split it
        String locationText = earthquake.getLocation();
        String[] locationAndOffset = splitLocation(locationText);

        // Set Location and Offset Text
        TextView locationOffset = (TextView) listItemView.findViewById(R.id.locationOffset);
        TextView location = (TextView) listItemView.findViewById(R.id.location);

        if (locationAndOffset.length == 1) {
            locationOffset.setText(getContext().getString(R.string.near_the));
            location.setText(locationAndOffset[0]);
        }
        else {
            String fullText = locationAndOffset[0] + " of";
            locationOffset.setText(fullText);
            location.setText(locationAndOffset[1]);
        }

        // Set shared variables for date and time
        long tstamp = earthquake.getTime();
        Date dateObject = new Date(tstamp);

        // Set Date
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        SimpleDateFormat dateString = new SimpleDateFormat("MMM dd, yyyy");
        String datestamp = dateString.format(dateObject);
        date.setText(datestamp);

        // Set Time
        TextView time = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeString = new SimpleDateFormat("hh:mm a");
        String timestamp = timeString.format(dateObject);
        time.setText(timestamp);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude){
        int color;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
                color = R.color.magnitude1;
                break;
            case 1:
                color = R.color.magnitude1;
                break;
            case 2:
                color = R.color.magnitude2;
                break;
            case 3:
                color = R.color.magnitude3;
                break;
            case 4:
                color = R.color.magnitude4;
                break;
            case 5:
                color = R.color.magnitude5;
                break;
            case 6:
                color = R.color.magnitude6;
                break;
            case 7:
                color = R.color.magnitude7;
                break;
            case 8:
                color = R.color.magnitude8;
                break;
            case 9:
                color = R.color.magnitude9;
                break;
            case 10:
                color = R.color.magnitude10plus;
                break;
            default:
                color = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), color);
    }
}
