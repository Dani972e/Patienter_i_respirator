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

        call_btn = (ImageView) findViewById(R.id.call_btn);
        balloon_btn = (ImageView) findViewById(R.id.balloon_btn);
        memoryGame_btn = (ImageView) findViewById(R.id.memoryGame_btn);
        ticTacToe_btn = (ImageView) findViewById(R.id.ticTacToe_btn);
        puzzle_btn = (ImageView) findViewById(R.id.puzzle_btn);

        balloon_btn.setOnClickListener(this);
        memoryGame_btn.setOnClickListener(this);
        ticTacToe_btn.setOnClickListener(this);
        puzzle_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call_btn:
                Intent call_act = new Intent(this, CallActivity.class);
                startActivity(call_act);
                break;
        }

    }
}