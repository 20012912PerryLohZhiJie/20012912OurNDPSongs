package com.example.ourndpsongs;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter
{
    Context partent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects)
    {
        super(context, resource, objects);

        partent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                partent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);
        // Obtain the UI components and do the necessary binding

        TextView tvName = rowView.findViewById(R.id.tVTitle);
        TextView tvYear = rowView.findViewById(R.id.tVYearRelease);
        TextView tvStar = rowView.findViewById(R.id.tVStars);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);
        ImageView ivNew = rowView.findViewById(R.id.imageView);
        RatingBar rBar = rowView.findViewById(R.id.rBar);
        // Obtain the Android Version information based on the position
        Song currentVersion = versionList.get(position);
        // Set values to the TextView to display the corresponding information


        tvName.setText(currentVersion.getTitle());
        tvName.setTextColor(Color.BLUE);
        tvYear.setText(currentVersion.getYearReleased());
        tvStar.setText(currentVersion.toString());
        tvStar.setTextColor(Color.RED);
        tvSinger.setText(currentVersion.getSingers());
        tvSinger.setTextColor(Color.CYAN);
        rBar.setRating(currentVersion.getStars());

        if(currentVersion.getYearReleased() >=2019)
        {
            ivNew.setImageResource(R.drawable.newsong);
        }
        else
        {
            ivNew.setImageResource(View.INVISIBLE);
        }

        return rowView;
    }
}
