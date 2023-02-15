package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void convertBtn(View view){
        EditText inr = findViewById(R.id.inr);
        EditText usd = findViewById(R.id.usd);

        String inrString = inr.getText().toString();
        if (!inrString.isEmpty()) {
            Double doubleInr = Double.parseDouble(inrString);
            Double doubleDollars = 0.012 * doubleInr;
            usd.setText(doubleDollars.toString());
          }
        else {
            String usdString = usd.getText().toString();
            if (!usdString.isEmpty()) {
                Double doubleUsd = Double.parseDouble(usdString);
                Double doubleINR = 82.52 * doubleUsd;
                inr.setText(doubleINR.toString());
            }else Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inr = findViewById(R.id.inr);
        EditText usd = findViewById(R.id.usd);

        Button clrbtn =findViewById(R.id.clearBtn);
        clrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inr.setText("");
                inr.setEnabled(true);
                usd.setText("");
                usd.setEnabled(true);
            }
        });
    }
}