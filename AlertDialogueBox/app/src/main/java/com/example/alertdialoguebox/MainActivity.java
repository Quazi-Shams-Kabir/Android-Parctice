package com.example.alertdialoguebox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alertdialoguebox.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int selectedItem = 0;
    private ArrayList<String> selectedItem2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setTitle("Are you Sure?")
            .setMessage("Do you want to exit?")
            .setIcon(R.drawable.baseline_exit_to_app_24)
            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nothing
                    }
            });
            builder1.show();
        });

        binding.button2.setOnClickListener(view -> {
            String[] arr = {"Red" , "Blue" , "Green" , "Golden" , "Black" , "Marron"};
            AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
            builder2.setTitle("Which is your favorite color?")
                    .setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            selectedItem=i;
                            Toast.makeText(MainActivity.this, "You have chosen "+arr[i], Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, arr[selectedItem] + " is your favourite color", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //nothing
                        }
                    })
                    .show();
        });

        binding.button3.setOnClickListener(view -> {
            String[] arr = {"Red" , "Blue" , "Green" , "Golden" , "Black" , "Marron"};
            AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);
            builder3.setTitle("Which are your favorite colors?")
                    .setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            if (b){
                                selectedItem2.add(arr[i]);
                                Toast.makeText(MainActivity.this, "You have chosen "+arr[i], Toast.LENGTH_SHORT).show();
                            } else if (!b) {
                                selectedItem2.remove(arr[i]);
                            }
                        }
                    })
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, selectedItem2 + " are your favourite color", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //nothing
                        }
                    })
                    .show();
        });
    }
}