package com.example.viewbinding;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            if (binding.checkBox.isChecked()){
                binding.checkBox.setButtonTintList(ColorStateList.valueOf(Color.BLACK));
                Toast.makeText(MainActivity.this, "Hi"+binding.editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            else {
                binding.checkBox.setButtonTintList(ColorStateList.valueOf(Color.RED));
                Toast.makeText(MainActivity.this, "Please Check the box", Toast.LENGTH_SHORT).show();
            }
        });
    }
}