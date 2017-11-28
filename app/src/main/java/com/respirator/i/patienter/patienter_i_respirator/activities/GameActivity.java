package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView balloon_btn, memoryGame_btn, ticTacToe_btn, puzzle_btn, call_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        call_btn = findViewById(R.id.call_btn);
        balloon_btn = findViewById(R.id.balloon_btn);
        memoryGame_btn = findViewById(R.id.memoryGame_btn);
        ticTacToe_btn = findViewById(R.id.ticTacToe_btn);
        puzzle_btn = findViewById(R.id.puzzle_btn);

        balloon_btn.setOnClickListener(this);
        memoryGame_btn.setOnClickListener(this);
        ticTacToe_btn.setOnClickListener(this);
        puzzle_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.puzzle_btn:
                break;
            case R.id.ticTacToe_btn:
                break;
            case R.id.memoryGame_btn:
                break;
            case R.id.balloon_btn:
                break;
            case R.id.call_btn:
                Intent call_act = new Intent(this, CallActivity.class);
                startActivity(call_act);
                break;
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
