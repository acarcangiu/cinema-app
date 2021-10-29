package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CinemaDetailsActivity extends AppCompatActivity {
    //Place holders cinema address
    String [] cinemaAddresses= {"51 Argyle street, Glasgow","6 Dumbarton Street, Glasgow","87 Clyde street, Glasgow","2130 Paisley Rd, Glasgow","19 Buchanan St, Glasgow","7 Renfrew St, Glasgow"};
    // Ge the images into array
    int[] randomCinemaImages = {R.drawable.cc1,R.drawable.cc2,R.drawable.cc3,R.drawable.cc4,R.drawable.cc5,R.drawable.cc6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_details);

        TextView c = findViewById(R.id.cin_dets_id);
        Intent in = getIntent();
        String name = in.getStringExtra("name");
        c.setText(name);

        TextView add = findViewById(R.id.textView3);
        ImageView im = findViewById(R.id.imageView5);

        // Generate random numbers from 0 to the arrays length
        int r1 = new Random().nextInt(cinemaAddresses.length);
        int r2 = new Random().nextInt(randomCinemaImages.length);

        String s = cinemaAddresses[r1];
        int img = randomCinemaImages[r2];

        add.setText(s);
        im.setImageResource(img);

        Button dirButton = findViewById(R.id.button2);
        dirButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 *Provides a link to google maps and shows the location of the cinema when 'get directions' button is clicked
                 */
                Uri cinemaIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(s));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, cinemaIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "No suitable app available", Toast.LENGTH_LONG).show();
                }

            }
        });
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





