package com.example.cinemaapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    /**
     Get the spinner selection
     */

    Spinner cinemaSpinner, dateSpinner, filmSpinner;
    Button searchButton;

    /**
     This array to store the selected data from the spinner
     */
    ArrayList<String> selectedData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tootbar_title);
        setContentView(R.layout.activity_main);

        cinemaSpinner = findViewById(R.id.spinner_id);
        dateSpinner = findViewById(R.id.date_spinner_id);
        filmSpinner = findViewById(R.id.film_spinner_id);
        searchButton = findViewById(R.id.search_button_id);

        populateCinema();
        populateDate();
        populateFilm();


        cinemaSpinner.setOnItemSelectedListener(this);
        dateSpinner.setOnItemSelectedListener(this);
        filmSpinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner_id) {
            String c = parent.getSelectedItem().toString();
            //Add the selected cinema to the array list
            selectedData.add(c);
        } else if (parent.getId() == R.id.date_spinner_id) {
            String d = parent.getSelectedItem().toString();
            selectedData.add(d);
        } else if (parent.getId() == R.id.film_spinner_id) {
            String f = parent.getSelectedItem().toString();
            selectedData.add(f);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
    Lunch Search Result Activity
     */
    public void lunchSearchResultActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, SearchResultsActivity.class);
        for (int i =0 ; i < selectedData.size();i++){
            selectedData.remove("Please select");
        }

        if (selectedData.size() < 3) {
            Toast.makeText(MainActivity.this,
                    "Please select all options", Toast.LENGTH_LONG).show();
        }else {
            // pass the data to the search result activity
            intent.putExtra("results", selectedData);
            startActivity(intent);
        }
    }


    /**
     Lunch populate Cinema from the array of names
     */
    private void populateCinema() {
        ArrayAdapter<String> cinemaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.cinemaList));
        cinemaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cinemaSpinner.setAdapter(cinemaAdapter);
    }

    /**
     Lunch populate Cinema from the array of dates
     */
    private void populateDate() {
        //  months = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> dateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.dateSpinnerList));
        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(dateAdapter);

    }

    private void populateFilm() {
        ArrayAdapter<String> filmAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.filmsSpinnerList));
        filmAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filmSpinner.setAdapter(filmAdapter);
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


}