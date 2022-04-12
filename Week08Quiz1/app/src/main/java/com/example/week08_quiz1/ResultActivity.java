package com.example.week08_quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewWinners;
    Button resetGameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        
        init_UI();
        Intent getIntent =getIntent();
        Bundle getBundle = getIntent.getExtras();
        if(getBundle!=null){
            String player1 =(String) getBundle.get("player1");
            String player2 =(String) getBundle.get("player2");
            if(getBundle.get("player1") == player1){
                textViewWinners.setText(player1);
            }
            else if(getBundle.get("player2") == player2){
                textViewWinners.setText(player2);
            }
        }
        resetGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==resetGameButton){
                    startActivity(new Intent(ResultActivity.this, MainActivity.class));
                }
            }
        });
    }

    private void init_UI() {
        textViewWinners = (TextView) findViewById(R.id.textViewWinners);
        resetGameButton = (Button) findViewById(R.id.resetGameButton);
    }
}