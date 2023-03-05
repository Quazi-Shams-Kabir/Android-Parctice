package com.example.alertdialogassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alertdialogassignment.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String KEY1 = "com.example.alertdialogassignment.Q1";
    public static final String KEY2 = "com.example.alertdialogassignment.Q2";
    public static final String KEY3 = "com.example.alertdialogassignment.Q3";
    public static final String KEY4 = "com.example.alertdialogassignment.Q4";
    int selectedItem1;
    int selectedItem4;
    ArrayList<String> selectedItem2 = new ArrayList<>();
    ArrayList<String> selectedItem3 = new ArrayList<>();

    //datas
    String[] lang = {"C","C++","Java","Python","JavaScript","Kotlin"};
    String[] techs = {"App Dev","Web Dev","AI/ML","Blockchain"};
    String[] ide = {"Visual Studio","IntelliJ IDEA"," Eclipse","PyCharm","Android Studio"};
    String[] option = {"YES","NO"};

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setSingleChoiceItems(lang, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selectedItem1 = i;
                        Toast.makeText(MainActivity.this, "You have selected "+lang[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         Toast.makeText(MainActivity.this, "Your answer is: "+lang[selectedItem1], Toast.LENGTH_SHORT).show();
                     }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nothing
                    }
                })
                .show();
            }
        });

        binding.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setMultiChoiceItems(techs, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b){
                            selectedItem2.add(techs[i]);
                            Toast.makeText(MainActivity.this, "You have Selected "+techs[i], Toast.LENGTH_SHORT).show();
                        }
                        else if (!b){
                            selectedItem2.remove(techs[i]);
                            //later will add code for if same elements present more than once remove it
                        }
                    }
                }).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Your have selected: "+selectedItem2.toString(), Toast.LENGTH_SHORT).show();
                            }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nothing
                    }
                })
                .show();
            }
        });

        binding.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);
                builder3.setMultiChoiceItems(ide, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b){
                            selectedItem3.add(ide[i]);
                            Toast.makeText(MainActivity.this, "You have Selected "+ide[i], Toast.LENGTH_SHORT).show();
                        }
                        else if (!b){
                            selectedItem3.remove(ide[i]);
                            //later will add code for if same elements present more than once remove it
                        }
                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Your have selected: "+selectedItem3.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nothing
                    }
                })
                .show();
            }
        });

        binding.textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(MainActivity.this);
                builder4.setSingleChoiceItems(option, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selectedItem4 = i;
                        Toast.makeText(MainActivity.this, "You have selected "+option[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Your answer is: "+option[selectedItem4], Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nothing
                    }
                })
                .show();
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AnswerPage.class);

                String ans1 = lang[selectedItem1];
                String ans4 = option[selectedItem4];

                intent.putExtra(KEY1,ans1);
                intent.putStringArrayListExtra(KEY2,selectedItem2);
                intent.putStringArrayListExtra(KEY3,selectedItem3);
                intent.putExtra(KEY4,ans4);
                startActivity(intent);
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder5 = new AlertDialog.Builder(MainActivity.this);
                builder5.setTitle("Are you sure?")
                        .setMessage("Do you want exit?")
                        .setIcon(R.drawable.baseline_exit_to_app_24)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //nothing
                            }
                        })
                        .show();
            }
        });
    }
}

//also will add code for clear, after one submit
