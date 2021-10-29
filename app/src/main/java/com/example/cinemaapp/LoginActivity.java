package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button Login;
    EditText Email;
    EditText Password;
    Button Register;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = findViewById(R.id.loginButton);
        Register = findViewById(R.id.Register);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        preferences = getSharedPreferences("userinfo",0);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EmailValue = Email.getText().toString();
                String UsernamePassword = Password.getText().toString();


                String registerEmail = preferences.getString("email","");

                String registerPassword = preferences.getString("password","");

                if(!EmailValue.equals(registerEmail) ) {
                    Toast.makeText(LoginActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();

                }else if (!UsernamePassword.equals(registerPassword)) {
                    Toast.makeText(LoginActivity.this, "Please enter the correct password", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                }

            }






        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });

    }


    public void openRegisterActivity() {
        Intent intent = new Intent (this, RegisterActivity.class);
        startActivity(intent);

    }

}