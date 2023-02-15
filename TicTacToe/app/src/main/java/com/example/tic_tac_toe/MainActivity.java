package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
        //0 -> x
        //1 -> O
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    /*
    0 -> X
    1 -> O
    2 -> Null
     */
    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @SuppressLint("SetTextI18n")
    public void game(View view){
       ImageView img = (ImageView)view;
       int tappedImage = Integer.parseInt(img.getTag().toString());
       int x = 1;
       if (!gameActive){
            x=0;
            reset(view);
       }

        if (gameState[tappedImage] == 2 && x == 1) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationX(-1000f);        //for animation
            if (activePlayer == 0){
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Player2's Turn");
            }
            else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Player1's Turn");
            }
            img.animate().translationXBy(1000f).setDuration(30);
        }

        //checking if won
        for(int[] winPosition:winPositions){
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                String winStr;
                gameActive = false;
                if (gameState[winPosition[0]]==0){
                    winStr = "Player 1 has WON!!!";
                }
                else {
                    winStr = "Player 2 has WON!!!";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winStr);
            }
        }
        if (ifDraw(gameState) && gameActive) {
            TextView status = findViewById(R.id.status);
            status.setText("It's a Draw");
            gameActive = false;
        }
    }
    private boolean ifDraw(int[] gameState) {
        for (int i = 0; i < gameState.length; i++) {
            if (gameState[i]==2){
                return false;
            }
        }
        return true;
    }

    public void reset(View view){

        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("Player1's Turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}