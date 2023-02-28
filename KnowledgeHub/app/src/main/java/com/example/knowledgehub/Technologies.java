package com.example.knowledgehub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Technologies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnologies);

        Button call = findViewById(R.id.button2);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9999999999"));
                startActivity(intent);
            }
        });
    }
    public void androidClick(View view){
        Intent intent = new Intent(this,AndroidAppDev.class);
        startActivity(intent);
    }
    public void iosClick(View view){
        Intent intent = new Intent(this,IOSAppDev.class);
        startActivity(intent);
    }
    public void webDevClick(View view){
        Intent intent = new Intent(this,WebDev.class);
        startActivity(intent);
    }
}
