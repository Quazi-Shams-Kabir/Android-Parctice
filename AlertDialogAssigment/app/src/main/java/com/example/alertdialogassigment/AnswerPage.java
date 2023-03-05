package com.example.alertdialogassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.alertdialogassigment.databinding.ActivityAnswerPageBinding;
import com.example.alertdialogassigment.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class AnswerPage extends AppCompatActivity {

    private ActivityAnswerPageBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnswerPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //receiving
        Intent intent = getIntent();
        String ans1 = intent.getStringExtra(MainActivity.KEY1);
        ArrayList<String> incomingAns2 = intent.getStringArrayListExtra(MainActivity.KEY2);
        ArrayList<String> incomingAns3 = intent.getStringArrayListExtra(MainActivity.KEY3);
        String incomingAns4 = intent.getStringExtra(MainActivity.KEY4);

        //converting ArrayLists into String using StringBuilder
        StringBuilder unmodifiedAns2 = new StringBuilder();
        StringBuilder unmodifiedAns3 = new StringBuilder();

        for (int i = 0; i < incomingAns2.size()-1; i++) {
            unmodifiedAns2.append(incomingAns2.get(i)).append(", ");
        }
        String ans2 = unmodifiedAns2+"and "+incomingAns2.get(incomingAns2.size()-1);

        for (int i = 0; i < incomingAns3.size()-1; i++) {
            unmodifiedAns3.append(incomingAns3.get(i)).append(", ");
        }
        String ans3 = unmodifiedAns3+"and "+incomingAns3.get(incomingAns3.size()-1);

        //condition and modifying according to YES/NO
        String ans4="";
        if(incomingAns4.equals("YES")){
            ans4 = "You love Open Source";
        }
        else ans4 = "You don't like Open Source";

        //setTexts
        binding.ans1.setText("Your favourite programming language is "+ans1);
        binding.ans2.setText("You know about "+ans2);
        binding.ans3.setText("You have used "+ans3);
        binding.ans4.setText(ans4);
    }
}