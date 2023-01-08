package com.example.zerokaata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    int activePlayer=0;
    int winner=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][]winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{3,4,6}};

public void playerTap(View view ){
    TextView txt=(TextView) view;
            int tappedText=Integer.parseInt(txt.getTag().toString());
            if(!gameActive){
                gameReset(view);
            }
            if(gameState[tappedText]==2) {
                gameState[tappedText] = activePlayer;
                txt.setTranslationY(-1000f);
               TextView status=findViewById(R.id.status);
                if (activePlayer == 0) {
                    txt.setText("X");
                    activePlayer = 1;
                    status = findViewById(R.id.status);
                    status.setText("O's Turn: Tap to Play");
                } else {
                    txt.setText("0");
                    activePlayer = 0;
                    status.setText("X's Turn: Tap to Play");
                }

                txt.animate().translationYBy(1000f).setDuration(300);
            }
            //check if any player has won
    for(int[] winPosition:winPositions){
        if(gameState[winPosition[0]]==gameState[winPosition[1]]&&
                gameState[winPosition[1]]==gameState[winPosition[2]]&& gameState[winPosition[0]]!=2){
                String winnerStr;
                gameActive=false;
            if(gameState[winPosition[0]]==0){
                    winnerStr="X has won!";
                    winner=0;
                }
            else{
                winnerStr="O has won!";
                winner=1;
            }
            TextView status = findViewById(R.id.status);
            status.setText(winnerStr);
        }
    }
    boolean emptySquare = false;
    for (int squareState : gameState) {
        if (squareState == 2) {
            emptySquare = true;
            break;
        }
    }
    if (!emptySquare && gameActive) {
        // Game is a draw
        gameActive = false;
        String winnerStr;
        winnerStr = "Its a Draw!";
        TextView status = findViewById(R.id.status);
        status.setText(winnerStr);
    }
}
public void gameReset(View view){
    TextView txt=(TextView) view;
    gameActive=true;
    activePlayer=winner;
    for(int i=0;i<gameState.length;i++){
        gameState[i]=2;
    }
   // playerTap(view);
    //int tappedText=Integer.parseInt(txt.getTag().toString());
    //if(gameState[tappedText]==2||gameState[tappedText]==0||gameState[tappedText]==1){
   //     gameState[tappedText]=2;
    //}
    ((TextView)findViewById(R.id.t1)).setText(null);
    ((TextView)findViewById(R.id.t2)).setText(null);
    ((TextView)findViewById(R.id.t3)).setText(null);
    ((TextView)findViewById(R.id.t4)).setText(null);
    ((TextView)findViewById(R.id.t5)).setText(null);
    ((TextView)findViewById(R.id.t6)).setText(null);
    ((TextView)findViewById(R.id.t7)).setText(null);
    ((TextView)findViewById(R.id.t8)).setText(null);
    ((TextView)findViewById(R.id.t9)).setText(null);
    TextView status=findViewById(R.id.status);
    if(winner==0){
    status.setText("X's Turn: Tap to Play");}
    else{
        status.setText(("O's Turn: Tap to Play"));
    }
    return;


}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}