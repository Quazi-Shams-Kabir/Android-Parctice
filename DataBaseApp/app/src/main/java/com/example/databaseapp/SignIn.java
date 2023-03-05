package com.example.databaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class SignIn extends AppCompatActivity {

    DatabaseReference databaseReference;
    public static final String EMAIL = "com.example.databaseapp.EMAIL";
    public static final String NAME = "com.example.databaseapp.NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        TextInputEditText signInName = findViewById(R.id.sign_in_name);
        Button signInBtn = findViewById(R.id.btnSignin);

        signInBtn.setOnClickListener(view -> {
            String name = Objects.requireNonNull(signInName.getText()).toString();
            if (name.isEmpty()){
                Toast.makeText(SignIn.this, "Enter Name", Toast.LENGTH_SHORT).show();
            }
            readData(name);
        });
    }

    private void readData(String name) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //if user exist or not
                if (snapshot.exists()){
                    //intent
                    String email = Objects.requireNonNull(snapshot.child("email").getValue()).toString();
                    String name = Objects.requireNonNull(snapshot.child("username").getValue()).toString();

                    Intent intent = new Intent(getApplicationContext(),Welcome.class);
                    intent.putExtra(EMAIL,email);
                    intent.putExtra(NAME,name);
                    startActivity(intent);
                }else {
                    Toast.makeText(SignIn.this, "User Doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SignIn.this, "Error fetching data from DB", Toast.LENGTH_SHORT).show();
            }
        });
    }
}