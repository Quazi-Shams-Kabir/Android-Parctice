package com.example.knowledgehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AndroidAppDev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_app_dev);
        TextView forMore = findViewById(R.id.forMore);
        forMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent roadmapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://roadmap.sh/android"));
                startActivity(roadmapIntent);
            }
        });
    }
}