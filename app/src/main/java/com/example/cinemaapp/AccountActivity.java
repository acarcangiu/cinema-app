package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AccountActivity extends AppCompatActivity {

    //ian added
    String firstName;
    String lastName;
    String email;
    SharedPreferences preferences;
    //END ian added

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //ian added
        preferences = getSharedPreferences("userinfo",0);
        firstName = preferences.getString("firstName","");
        lastName = preferences.getString("lastName","");
        email = preferences.getString("email","");
        TextView firstNameView = findViewById(R.id.firstNameView);
        TextView lastNameView = findViewById(R.id.lastNameView);
        TextView emailView = findViewById(R.id.emailView);
        firstNameView.setText(firstName);
        lastNameView.setText(lastName);
        emailView.setText(email);
        TextView filmView = findViewById(R.id.Col1_Row1);
        TextView dateView = findViewById(R.id.Col2_Row1);
        TextView cinemaView = findViewById(R.id.Col3_Row1);
        filmView.setText(BookingConfirmationActivity.filmAC);
        cinemaView.setText(BookingConfirmationActivity.cinemaNameAC);
        dateView.setText(BookingConfirmationActivity.dateSelectedAC);
        Button cancelButton = findViewById(R.id.button44);
        if(dateView.getText().toString().equals("")){
            cancelButton.setVisibility(View.INVISIBLE);
        }
        else if(!dateView.getText().toString().equals("")){
            cancelButton.setVisibility(View.VISIBLE);
        }
        //END ian added
    }

    public void lunchAccountttActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    /**
     * Lunch the login page activity .
     */
    public void lunchLoginnnActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void lunchMainnActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void cancelTicket(View v) {

        //ian added
        BookingConfirmationActivity.setFilmAC("");
        BookingConfirmationActivity.setCinemaNameAC("");
        BookingConfirmationActivity.setDateSelectedAC("");
        SeatSelectActivity.seatA1Booked = false;
        SeatSelectActivity.seatA2Booked = false;
        SeatSelectActivity.seatB1Booked = false;
        SeatSelectActivity.seatB2Booked = false;
        SeatSelectActivity.seatB3Booked = false;
        //ian added

        Intent intent = new Intent(this, CancelConfirm.class);
        startActivity(intent);
    }

}