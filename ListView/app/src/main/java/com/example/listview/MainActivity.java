package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hi");
        arrayList.add("hola");
        arrayList.add("bonjour");
        arrayList.add("annyeong");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String greeting = (String) ((TextView)view).getText();
            String language = " ";
            if (Objects.equals(greeting, "hi"))
                language = "English";
            if (Objects.equals(greeting, "hola"))
                language = "Spanish";
            if (Objects.equals(greeting, "bonjour"))
                language = "French";
            if (Objects.equals(greeting, "annyeong"))
                language = "Korean";
            String text = "Item " + (i+1) + " " + language;
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        });

    }
}