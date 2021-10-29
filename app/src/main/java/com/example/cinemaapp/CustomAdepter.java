package com.example.cinemaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdepter extends BaseAdapter {
       SearchResultsActivity search;
       private LayoutInflater inflater;
       private String[] movies;
       private int[] images;

    public CustomAdepter(SearchResultsActivity searchResultsActivity, String[] movies, int[] images, String[] movieDescription) {
        search=searchResultsActivity;
        this.movies=movies;
        this.images=images;

    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null) {
            inflater=(LayoutInflater) search.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null) {
            convertView =inflater.inflate(R.layout.row_data,null);
        }
        ImageView imageView = convertView.findViewById(R.id.img1_id);
        TextView textView =convertView.findViewById(R.id.img_text_id);
        imageView.setImageResource(images[position]);
        textView.setText(movies[position]);
        return convertView;
    }
}
