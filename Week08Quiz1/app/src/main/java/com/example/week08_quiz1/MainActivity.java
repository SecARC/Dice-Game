package com.example.week08_quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editTextPlayer1Name;
    EditText editTextPlayer2Name;
    TextView textView6;
    Button startGameButton;
    Button button1;
    Button button2;
    int count1 = 0;
    int count2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_UI();
    }

    private void init_UI() {
        editTextPlayer1Name = (EditText) findViewById(R.id.editTextPlayer1Name);
        editTextPlayer2Name = (EditText) findViewById(R.id.editTextPlayer2Name);
        textView6 = (TextView) findViewById(R.id.textView6);
        startGameButton = (Button) findViewById(R.id.startGameButton);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText(editTextPlayer1Name.getText() + " wins");
                button2.setText(editTextPlayer2Name.getText() + " wins");
                editTextPlayer1Name.setEnabled(false);
                editTextPlayer2Name.setEnabled(false);
                button1.setEnabled(true);
                button2.setEnabled(true);
            }
        });
        Intent i = new Intent(MainActivity.this,ResultActivity.class);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1++;
                textView6.setText(count1 + " - " + count2);
                if(count1 == 5){
                    String name1 = editTextPlayer1Name.getText().toString();
                    i.putExtra("player1",name1);
                    startActivity(i);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2++;
                textView6.setText(count1 + " - " + count2);
                if(count2 == 5){
                    String name2 = editTextPlayer2Name.getText().toString();
                    i.putExtra("player2",name2);
                    startActivity(i);
                }
            }
        });


    }
}