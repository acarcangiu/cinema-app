package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookingConfirmationActivity extends AppCompatActivity {

    String selectSeatPassed;

    String film;
    String cinemaName;
    String dateSelected;
    ArrayList<String> allData = new ArrayList<>();

    TextView answer;
    TextView tickTotal;
    TextView tickP;

    //ian added
    TextView seat1Book;
    TextView seat2Book;
    TextView seat3Book;
    TextView seat4Book;
    TextView seat5Book;



    int spinnerPosition;

    public static String filmAC = "";
    public static String cinemaNameAC = "";
    public static String dateSelectedAC = "";

    public static void setFilmAC(String s) {
        filmAC = s;
    }

    public static void setCinemaNameAC(String s) {
        cinemaNameAC = s;
    }

    public static void setDateSelectedAC(String s) {
        dateSelectedAC = s;
    }

    public static int tickNum;
    ArrayList<String> allseats;



    //END ian added

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);
        Intent intent = getIntent();
        //ian added
        spinnerPosition = 0;

        Intent seatIntent = getIntent();
        allseats = new ArrayList<>();



        try {
            TextView cinemaView = findViewById(R.id.c_t_id);
            TextView dateView = findViewById(R.id.emailView);
            TextView filmView = findViewById(R.id.firstNameView);
            if (intent.getStringExtra("cc2") != null && intent.getStringExtra("ss2") != null && intent.getStringExtra("ff2") != null) {


                film = intent.getStringExtra("ff2");
                cinemaName = intent.getStringExtra("cc2");
                dateSelected = intent.getStringExtra("ss2");

                allData.add(film);
                allData.add(cinemaName);
                allData.add(dateSelected);

                filmView.setText(intent.getStringExtra("ff2"));
                cinemaView.setText(intent.getStringExtra("cc2"));
                dateView.setText(intent.getStringExtra("ss2"));
            } else {
                throw new NullPointerException("error here ");
            }
        } catch (NullPointerException e) {
            System.out.println("Exception error");
        }

        Button butt = findViewById(R.id.cancel_button_id);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // Views
        answer = (TextView) findViewById(R.id.textView10);
        tickP = (TextView) findViewById(R.id.textView123);
        tickTotal = (TextView) findViewById(R.id.textView4);

        Spinner spinner_convert_from = (Spinner) findViewById(R.id.spinner_ticket_id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tickets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_convert_from.setAdapter(adapter);

        // Add item selected listener
        spinner_convert_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int pos,
                                       long id) {

                if (pos == 0) {
                    //  String s1= parent.getSelectedItem().toString();
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.49) * 1));
                    tickP.setText(parent.getSelectedItem().toString());
                    spinnerPosition = pos + 1;

                } else if (pos == 1) {
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.49) * 2));
                    tickP.setText(parent.getSelectedItem().toString());
                    spinnerPosition = pos + 1;


                } else if (pos == 2) {
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.49) * 3));
                    tickP.setText(parent.getSelectedItem().toString());
                    spinnerPosition = pos + 1;


                } else if (pos == 3) {
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.49) * 4));
                    tickP.setText(parent.getSelectedItem().toString());
                    spinnerPosition = pos + 1;


                } else if (pos == 4) {
                    tickTotal.setText("£" + String.valueOf(Double.valueOf(14.49) * 5));
                    tickP.setText(parent.getSelectedItem().toString());
                    spinnerPosition = pos + 1;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void lunchSeatSelectActivity(View v) {
        // lunch the activity
        Intent i = new Intent(this, SeatSelectActivity.class);
        i.putExtra("ticket", spinnerPosition);
        startActivityForResult(i, 1);
    }

    public void seat1Select(View v) {
        //tickNum = 1;
        Intent i = new Intent(this, SeatSelectActivity.class);
        i.putExtra("ticket", 1);
        startActivityForResult(i, 1);
    }

    public void seat2Select(View v) {
        //tickNum = 2;
        Intent i = new Intent(this, SeatSelectActivity.class);
        i.putExtra("ticket", 2);
        startActivityForResult(i, 1);
    }

    public void seat3Select(View v) {
        //tickNum = 3;
        Intent i = new Intent(this, SeatSelectActivity.class);
        i.putExtra("ticket", 3);
        startActivityForResult(i, 1);
    }

    public void seat4Select(View v) {
        //tickNum = 4;
        Intent i = new Intent(this, SeatSelectActivity.class);
        i.putExtra("ticket", 4);
        startActivityForResult(i, 1);
    }

    public void seat5Select(View v) {
        //tickNum = 5;
        Intent i = new Intent(this, SeatSelectActivity.class);
        i.putExtra("ticket", 5);
        startActivityForResult(i, 1);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                seat1Book = findViewById(R.id.seat1Select);
                seat2Book = findViewById(R.id.seat2Select);
                seat3Book = findViewById(R.id.seat3Select);
                seat4Book = findViewById(R.id.seat4Select);
                seat5Book = findViewById(R.id.seat5Select);


                TextView[] seatsView= {  seat1Book, seat2Book, seat3Book, seat4Book, seat5Book};

                tickNum = data.getIntExtra("tickNum", 6);
                allseats=data.getStringArrayListExtra("allSeatsList");
                for(int i=0;i<allseats.size();i++){
                    seatsView[i].setText(allseats.get(i));
                }
            }
        }
    }


    public void lunchConfirmShowActivity(View v) {
        // lunch the activity
        Intent i = new Intent(this, ConfirmedShowActivity.class);


        TextView t = findViewById(R.id.seat1Select);
        String seatNumber = t.getText().toString();
        if (seatNumber.length() == 0) {
            Toast.makeText(BookingConfirmationActivity.this,
                    "Please select seat", Toast.LENGTH_LONG).show();
        } else {

            try {
                if (allData.size() > 0) {

                    //ian added
                    filmAC = film;
                    cinemaNameAC = cinemaName;
                    dateSelectedAC = dateSelected;
                    //END ian added

                    startActivityForResult(i, 1);


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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