package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ViewFilmActivity extends AppCompatActivity {
    String c;
    String d;
    String f;

    ImageView imageView;
    TextView movieName;
    TextView desMovie;

    //ian added
    boolean hasUserRated;
    ArrayList<Integer> userRatings = new ArrayList<>();
    float rating;
    Integer userRating;
    TextView displayRating;
    ImageButton starButton1;
    ImageButton starButton2;
    ImageButton starButton3;
    ImageButton starButton4;
    ImageButton starButton5;
    //END ian added

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_film);

        imageView=findViewById(R.id.img2_id);
        movieName=findViewById(R.id.img2_text_id);
        desMovie=findViewById(R.id.lastNameView);

        //Get the values passed from the results page
        Intent intent =getIntent();
        imageView.setImageResource(intent.getIntExtra("image",0));
        movieName.setText(intent.getStringExtra("name"));
        desMovie.setText(intent.getStringExtra("des"));

        //ian added
        hasUserRated = false;
        userRating = 0;
        rating = 3;
        displayRating = findViewById(R.id.ratingTextView);
        starButton1 = findViewById(R.id.starButton1);
        starButton2 = findViewById(R.id.starButton2);
        starButton3 = findViewById(R.id.starButton3);
        starButton4 = findViewById(R.id.starButton4);
        starButton5 = findViewById(R.id.starButton5);
        userRatings.add((int) rating);
        DecimalFormat value = new DecimalFormat("#.#");
        String s = value.format(rating);
        displayRating.setText(s);
        //END ian added


        c = intent.getStringExtra("cinemaN");
        d = intent.getStringExtra("dateC");
        f=intent.getStringExtra("name");

    }

    /**
     * Lunch the bookingConfirmation page activity .
     */
    public void lunchBookingConfirmationActivity(View v) {
        // lunch the activity

        try {
            if(c != null && d != null) {
                // pass the values to the BookingConfirmationActivity
                Intent in = new Intent(this, BookingConfirmationActivity.class);
                in.putExtra("cc2",c);
                in.putExtra("ss2",d);
                in.putExtra("ff2",f);
                startActivity(in);
            }else{
                throw new NullPointerException("error here ");
            }
        }catch (NullPointerException e){
            System.out.println("Exception error");
        }

    }

    //Ian added (everything down to end of class)

    public void star1(View v){
        if (userRating == 1){
            starButton1.setImageResource(R.drawable.starempty);
            starButton2.setImageResource(R.drawable.starempty);
            starButton3.setImageResource(R.drawable.starempty);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 0;
        }
        else if (userRating != 1) {
            starButton1.setImageResource(R.drawable.starfilled);
            starButton2.setImageResource(R.drawable.starempty);
            starButton3.setImageResource(R.drawable.starempty);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 1;
        }


    }

    public void star2(View v){
        if (userRating == 2){
            starButton1.setImageResource(R.drawable.starempty);
            starButton2.setImageResource(R.drawable.starempty);
            starButton3.setImageResource(R.drawable.starempty);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 0;
        }
        else if (userRating != 2) {
            starButton1.setImageResource(R.drawable.starfilled);
            starButton2.setImageResource(R.drawable.starfilled);
            starButton3.setImageResource(R.drawable.starempty);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 2;
        }

    }

    public void star3(View v){
        if (userRating == 3){
            starButton1.setImageResource(R.drawable.starempty);
            starButton2.setImageResource(R.drawable.starempty);
            starButton3.setImageResource(R.drawable.starempty);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 0;
        }
        else if (userRating != 3) {
            starButton1.setImageResource(R.drawable.starfilled);
            starButton2.setImageResource(R.drawable.starfilled);
            starButton3.setImageResource(R.drawable.starfilled);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 3;
        }

    }

    public void star4(View v){
        if (userRating == 4){
            starButton1.setImageResource(R.drawable.starempty);
            starButton2.setImageResource(R.drawable.starempty);
            starButton3.setImageResource(R.drawable.starempty);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 0;
        }
        else if (userRating != 4) {
            starButton1.setImageResource(R.drawable.starfilled);
            starButton2.setImageResource(R.drawable.starfilled);
            starButton3.setImageResource(R.drawable.starfilled);
            starButton4.setImageResource(R.drawable.starfilled);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 4;
        }


    }

    public void star5(View v){
        if (userRating == 5){
            starButton1.setImageResource(R.drawable.starempty);
            starButton2.setImageResource(R.drawable.starempty);
            starButton3.setImageResource(R.drawable.starempty);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);
            userRating = 0;
        }
        else if (userRating != 5){
            starButton1.setImageResource(R.drawable.starfilled);
            starButton2.setImageResource(R.drawable.starfilled);
            starButton3.setImageResource(R.drawable.starfilled);
            starButton4.setImageResource(R.drawable.starfilled);
            starButton5.setImageResource(R.drawable.starfilled);
            userRating = 5;
        }


    }

    public void rateButton(View v){
        if (hasUserRated){
            Toast.makeText(this, "You have already rated this, thanks", Toast.LENGTH_SHORT).show();
        }
        if (!hasUserRated && userRating == 0){
            Toast.makeText(this, "Click star to select rating", Toast.LENGTH_SHORT).show();
        }
        else if (!hasUserRated && userRating > 0){
            starButton1.setImageResource(R.drawable.starempty);
            starButton2.setImageResource(R.drawable.starempty);
            starButton3.setImageResource(R.drawable.starempty);
            starButton4.setImageResource(R.drawable.starempty);
            starButton5.setImageResource(R.drawable.starempty);

            userRatings.add(userRating);

            float total = 0;
            for (int i=0; i<userRatings.size(); i++){
                total = total + userRatings.get(i);
            }
            rating = (float) Math.round(total)/userRatings.size();
            DecimalFormat value = new DecimalFormat("#.#");
            String s = value.format(rating);
            displayRating.setText(s);
            Toast.makeText(this, "Thanks for your rating!", Toast.LENGTH_SHORT).show();
            hasUserRated = true;
            userRating = 0;
        }

    }

    public void lunchAccountActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, AccountActivity.class);
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

    public void lunchMainnActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}



