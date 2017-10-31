package com.respirator.i.patienter.patienter_i_respirator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView balloon_btn;
    private ImageView memory_game_btn;
    private ImageView ticTacToe_btn;
    private ImageView puzzle_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView balloon_btn = (ImageView) findViewById(R.id.balloon_btn);
        ImageView memory_game_btn = (ImageView) findViewById(R.id.memoryGame_btn);
        ImageView ticTacToe_btn = (ImageView) findViewById(R.id.ticTacToe_btn);
        ImageView puzzle_btn = (ImageView) findViewById(R.id.puzzle_btn);


        balloon_btn.setOnClickListener(this);
        memory_game_btn.setOnClickListener(this);
        ticTacToe_btn.setOnClickListener(this);
        puzzle_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.balloon_btn:
                Intent balloonGame = new Intent(this, PopBalloonsActivity.class);
                startActivity(balloonGame);
                break;
            case R.id.memoryGame_btn:
                Intent memoryGame = new Intent(this, MemoryGameActivity.class);
                startActivity(memoryGame);
                break;
            case R.id.ticTacToe_btn:
                Intent ticTacToeGame = new Intent(this, TicTacToeActivity.class);
                startActivity(ticTacToeGame);
                break;
            case R.id.puzzle_btn:
                Intent puzzleGame = new Intent(this, PuzzleActivity.class);
                startActivity(puzzleGame);
                break;
        }

    }
}
