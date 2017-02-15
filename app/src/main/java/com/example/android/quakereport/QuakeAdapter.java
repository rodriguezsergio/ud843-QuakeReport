package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sergio on 2/14/17.
 */

public class QuakeAdapter extends ArrayAdapter<Earthquake> {

    public QuakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
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
        magnitude.setText(earthquake.getMagnitude());

        // Set Location Text
        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText(earthquake.getLocation());

        // Set Time
        TextView time = (TextView) listItemView.findViewById(R.id.time);
        time.setText(earthquake.getTime());

        return listItemView;
    }
}
