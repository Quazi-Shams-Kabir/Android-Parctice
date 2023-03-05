package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        String email = intent.getStringExtra(SignIn.EMAIL);
        String name = intent.getStringExtra(SignIn.NAME);

        TextView textView = findViewById(R.id.email_of_user);
        TextView textView1 = findViewById(R.id.name_of_user);

        String email1 = "Your email address is "+email;
        String name1 = "Welcome "+name;
        textView.setText(email1);
        textView1.setText(name1);
    }
}