package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    GridView gridView;
    /**
    Movie names array
     */
    String [] movies = {"Light","Moon","Castle","Snow","Ghost","Sky"};

    /**
     Movie Description array
     */
    String [] movieDescription = {"Light of the sky from 1990, it has been in the top ten",
            "Moon of the sky from 1890, it has been in the top 20","Castle-of the sky from 2020, it has been in the top ten",
            "Snow-Light of the sky from 2021, it has been in the top ten","Ghost-Light of the sky from 1990, it has been in the top ten",
            "Sky-Light of the sky from 1990, it has been in the top ten"};

    int[] images = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6};
    ArrayList<String> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        Intent in = getIntent();
        // get the data from the main activity
        resultList = in.getStringArrayListExtra("results");

         if(resultList.size()==3) {
             TextView cinemaView = findViewById(R.id.cin_type_id);
             TextView dateView = findViewById(R.id.search_date_id);

             for (int i =0 ; i < resultList.size();i++){
                   if(resultList.get(i).startsWith("Cin")) {
                       cinemaView.setText(resultList.get(i));
                   }else if(resultList.get(i).startsWith("2021")){
                       dateView.setText(resultList.get(i));

                   }
             }

         }

         gridView = findViewById(R.id.grid_id_1);

        CustomAdepter customAdepter = new CustomAdepter(SearchResultsActivity.this,
                movies,
                images,movieDescription);

        gridView.setAdapter(customAdepter);

         gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             String cinemaName;
             String chosenDate;
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent(getApplicationContext(),ViewFilmActivity.class);


                 intent.putExtra("image",images[position]);
                 intent.putExtra("name",movies[position]);
                 intent.putExtra("des",movieDescription[position]);

                 for (int i =0 ; i < resultList.size();i++){

                     if(resultList.get(i).startsWith("Cin")) {
                         cinemaName=resultList.get(i);
                         intent.putExtra("cinemaN",cinemaName);
                     }else if(resultList.get(i).startsWith("2021")){
                         chosenDate=resultList.get(i);
                         intent.putExtra("dateC",chosenDate);
                     }
                 }

                 startActivity(intent);

             }
         });

    }

    /**
     * Lunch the cinema details page activity .
     */
    public void lunchCinemaDetailsActivity(View v) {
        String s = "";
        Intent intent = new Intent(this, CinemaDetailsActivity.class);
        for (int i =0 ; i < resultList.size();i++){
            if(resultList.get(i).startsWith("Cin")) {
                s = resultList.get(i);
            }
        }
        intent.putExtra("name",s);
        startActivity(intent);

    }

    /**
     * Lunch the login page activity .
     */
    public void lunchLoginActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Lunch the account page activity .
     */
    public void lunchAccountActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void lunchMainnActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
