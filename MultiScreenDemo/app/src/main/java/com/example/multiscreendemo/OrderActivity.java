package com.example.multiscreendemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();        //received the intent
        String message = intent.getStringExtra(MainActivity.LOGIN);     //set the received messages to the string

        //setText to the text view we created
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

    }
}