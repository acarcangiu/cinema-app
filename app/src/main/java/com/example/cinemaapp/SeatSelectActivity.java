package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SeatSelectActivity extends AppCompatActivity {
    //Is seat booked? for each seat
    public static boolean seatA1Booked;
    public static boolean seatA2Booked;
    public static boolean seatB1Booked;
    public static boolean seatB2Booked;
    public static boolean seatB3Booked;

    ArrayList<String> selectedArray;
    
    //Image buttons for each seat
    ImageButton seatA1Button;
    ImageButton seatA2Button;
    ImageButton seatB1Button;
    ImageButton seatB2Button;
    ImageButton seatB3Button;

    Integer ticketNumber;

    //Text view to display selected seat
    TextView seatNumberText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_select);

        Intent intent = getIntent();
        ticketNumber = intent.getIntExtra("ticket", 0);

        selectedArray = new ArrayList<>();
        //String sn = ticketNumber.toString();
        //seatNumberText.setText(sn);
        //Initial 'booked' or 'not booked' status for each seat
        seatA1Booked = false;
        seatA2Booked = false;
        seatB1Booked = false;
        seatB2Booked = false;
        seatB3Booked = false;


        //Initialising TextView to display selected seat
        seatNumberText = (TextView) findViewById(R.id.seatNumberText);

        //Initialising ImageButton variables to seat buttons
        seatA1Button = (ImageButton)findViewById(R.id.seatA1Button);
        seatA2Button = (ImageButton)findViewById(R.id.seatA2Button);
        seatB1Button = (ImageButton)findViewById(R.id.seatB1Button);
        seatB2Button = (ImageButton)findViewById(R.id.seatB2Button);
        seatB3Button = (ImageButton)findViewById(R.id.seatB3Button);

        /**
         Runs function which checks each seat's booking status
         and displays correct booked or not booked graphic
         **/
        imageUpdater();

        //confirm seat booking button
        Button butt = findViewById(R.id.search_button_id4);


        butt.setOnClickListener(new View.OnClickListener() {
            //This is the text view in the confirmation page to show the first booked seat
            TextView s = findViewById(R.id.seat1Select);

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BookingConfirmationActivity.class);

                if(selectedArray.size() != ticketNumber) {
                    Toast.makeText(SeatSelectActivity.this,
                            "Please select all seats before confirming", Toast.LENGTH_LONG).show();
                } else if (selectedArray.size() == ticketNumber) {
                    intent.putExtra("allSeatsList",selectedArray);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        Button CancelButt = findViewById(R.id.cancel_seatBook_button_id);

        CancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * Function to check each seats booking status and update graphics accordingly
     */
    public void imageUpdater(){

        if (seatA1Booked){
            seatA1Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatA1Booked){
            seatA1Button.setImageResource(R.drawable.seatavailable);
        }
        if (seatA2Booked){
            seatA2Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatA2Booked){
            seatA2Button.setImageResource(R.drawable.seatavailable);
        }
        if (seatB1Booked){
            seatB1Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatB1Booked){
            seatB1Button.setImageResource(R.drawable.seatavailable);
        }
        if (seatB2Booked){
            seatB2Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatB2Booked){
            seatB2Button.setImageResource(R.drawable.seatavailable);
        }
        if (seatB3Booked){
            seatB3Button.setImageResource(R.drawable.seatnotavailable);
        }
        if (!seatB3Booked){
            seatB3Button.setImageResource(R.drawable.seatavailable);
        }
    }

 int numberOfSeats= 1;

    public void seatA1(View view){
        if(!seatA1Booked) {
            if(numberOfSeats > ticketNumber) {
                Toast.makeText(this, "You can't book more seats Sorry!", Toast.LENGTH_SHORT).show();
            }else {
                seatA1Button.setImageResource(R.drawable.seatselected);
                seatA1Booked=true;
                numberOfSeats++;
                seatNumberText.setText("A1");
                selectedArray.add("A1");
            }
        }else if (seatA1Booked) {
            seatA1Button.setImageResource(R.drawable.seatavailable);
            seatA1Booked=false;
            numberOfSeats--;
            seatNumberText.setText("");
            selectedArray.remove("A1");
        }

    }

    public void seatA2(View view){

        if(!seatA2Booked) {
            if(numberOfSeats > ticketNumber) {
                Toast.makeText(this, "You can't book more seats Sorry!", Toast.LENGTH_SHORT).show();
            }else {
                seatA2Button.setImageResource(R.drawable.seatselected);
                seatA2Booked=true;
                numberOfSeats++;
                seatNumberText.setText("A2");
                selectedArray.add("A2");
            }
        }else if (seatA2Booked) {
            seatA2Button.setImageResource(R.drawable.seatavailable);
            seatA2Booked=false;
            numberOfSeats--;
            seatNumberText.setText("");
            selectedArray.remove("A2");
        }

    }

    public void seatB1(View view){
        if(!seatB1Booked) {
            if(numberOfSeats > ticketNumber) {
                Toast.makeText(this, "You can't book more seats Sorry!", Toast.LENGTH_SHORT).show();
            }else {
                seatB1Button.setImageResource(R.drawable.seatselected);
                seatB1Booked=true;
                numberOfSeats++;
                seatNumberText.setText("B1");
                selectedArray.add("B1");
            }
        }else if (seatB1Booked) {
            seatB1Button.setImageResource(R.drawable.seatavailable);
            seatB1Booked=false;
            numberOfSeats--;
            seatNumberText.setText("");
            selectedArray.remove("B1");
        }

    }

    public void seatB2(View view){
        if(!seatB2Booked) {
            if(numberOfSeats > ticketNumber) {
                Toast.makeText(this, "You can't book more seats Sorry!", Toast.LENGTH_SHORT).show();
            }else {
                seatB2Button.setImageResource(R.drawable.seatselected);
                seatB2Booked=true;
                numberOfSeats++;
                seatNumberText.setText("B2");
                selectedArray.add("B2");
            }
        }else if (seatB2Booked) {
            seatB2Button.setImageResource(R.drawable.seatavailable);
            seatB2Booked=false;
            numberOfSeats--;
            seatNumberText.setText("");
            selectedArray.remove("B2");
        }
    }

    public void seatB3(View view){
        if(!seatB3Booked) {
            if(numberOfSeats > ticketNumber) {
                Toast.makeText(this, "You can't book more seats Sorry!", Toast.LENGTH_SHORT).show();
            }else {
                seatB3Button.setImageResource(R.drawable.seatselected);
                seatB3Booked=true;
                numberOfSeats++;
                seatNumberText.setText("B3");
                selectedArray.add("B3");
            }
        }else if (seatB3Booked) {
            seatB3Button.setImageResource(R.drawable.seatavailable);
            seatB3Booked=false;
            numberOfSeats--;
            seatNumberText.setText("");
            selectedArray.remove("B3");
        }

    }

    /**
     * Lunch the account page activity .
     */
    public void lunchAccounttActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);

    }

    /**
     * Lunch the login page activity .
     */
    public void lunchLoginnActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void lunchMainActivity(View v) {
        // lunch the activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}