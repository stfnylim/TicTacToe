package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView playerOneScore, playerTwoScore, playerStatus;
    private Button[] buttons = new Button[9];
    private Button resetGame;

    private int playerOneScoreCount, playerTwoScoreCount, roundCount;
    boolean activePlayer;
    // p1 : 0, p2 : 1, empty: 2
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningStates =
            {
                    {0,1,2},{3,4,5},{6,7,8}, // rows
                    {1,3,6},{1,4,7},{2,5,8}, // columns
                    {0,4,8},{2,4,6} // cross
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Textviews for information at top of game
        playerOneScore = (TextView) findViewById(R.id.playerOneScore);
        playerTwoScore = (TextView) findViewById(R.id.playerTwoScore);
        playerStatus = (TextView) findViewById(R.id.playerStatus);

        // Reset
        resetGame = (Button) findViewById(R.id.resetGameBtn);

        // Tictactoe buttons
        for(int i =0;i<buttons.length;i++){
            String name = "btn" + i;
            int resourceID = getResources().getIdentifier(name, "id", getPackageName());
            buttons[i]= (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        //Log.i("test","button is clicked");
        if(!((Button) view).getText().toString().equals("")){
            return;
        }
        // storing button name, i.e. btn0, btn5... etc
        String buttonID = view.getResources().getResourceEntryName(view.getId());
        // storing the last character of button name
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length()-1, buttonID.length()));

        if(activePlayer){
            ((Button)view).setText("X");
            ((Button)view).setTextColor(Color.parseColor("#F2ECFF"));
            gameState[gameStatePointer] = 0;
        }else{
            ((Button)view).setText("O");
            ((Button)view).setTextColor(Color.parseColor("#F2ECFF"));
            gameState[gameStatePointer] = 1;
        }
        roundCount++;
    }
    public boolean checkWin(){
        boolean winResult = false;

        for(int[] winState : winningStates){
            if(gameState[winState[0]] == gameState[winState[1]] && gameState[winState[1]]== gameState[winState[2]] && gameState[winState[0]] != 2){
                winResult =true;
            }
        }

        return winResult;
    }
}