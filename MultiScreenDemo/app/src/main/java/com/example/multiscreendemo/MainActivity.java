package com.example.multiscreendemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String LOGIN = "com.example.multiscreendemo.LOGIN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loginBtn(View view){
        //to go from thus activity to another activity
        //here from this(main activity) to OrderActivity
        Intent intent = new Intent(this,OrderActivity.class);
        EditText userName = findViewById(R.id.userName);
        EditText userCode = findViewById(R.id.userCode);
        String un = "Welcome " + userName.getText().toString() + " to Second Page";
        intent.putExtra(LOGIN,un); //sends a key value pair, sends a message or something with a key, here login is the key and un is value.
        startActivity(intent);
    }
}