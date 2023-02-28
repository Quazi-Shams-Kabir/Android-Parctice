package com.example.knowledgehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WebDev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_dev);
    }
    public void frontendClick(View view){
        Intent intent = new Intent(this,FrontEnd.class);
        startActivity(intent);
    }
    public void backendClick(View view){
        Intent intent = new Intent(this,FrontEnd.class);
        startActivity(intent);
    }
}