package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.fragments.MemoryGameFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.PopBalloonGameFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.QuizFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.TicTacToeGameFragment;

//import com.respirator.i.patienter.patienter_i_respirator.fragments.PuzzleGameFragment;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private final int btn_amount = 4;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.balloon_btn, R.id.memoryGame_btn, R.id.ticTacToe_btn, R.id.quiz_btn};
    private ImageView call_btn;
    private TextView gameText_view;
    private TextView game_view;
    private ImageView home_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onWindowFocusChanged(true);

        setContentView(R.layout.game_activity);


        gameText_view = findViewById(R.id.gameText_view);
        call_btn = findViewById(R.id.call_btn);
        home_btn = findViewById(R.id.home_btn);
        game_view = findViewById(R.id.game_view);
        call_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View view) {
        for (ImageView btn : btnArray) {
            if (btn.equals(view)) {
                btn.setBackgroundResource(R.drawable.button_rounded_darkturquoise);
                game_view.setVisibility(View.INVISIBLE);
            } else {
                btn.setBackgroundResource(R.drawable.button_rounded_turquoise);
            }

        }


        switch (view.getId()) {
            case R.id.quiz_btn:
                getFragmentManager().beginTransaction().replace(R.id.gameFragmentContainer, new QuizFragment()).commit();
                gameText_view.setText(R.string.Quiz);
                break;
            case R.id.ticTacToe_btn:
                getFragmentManager().beginTransaction().replace(R.id.gameFragmentContainer, new TicTacToeGameFragment()).commit();
                gameText_view.setText(R.string.førsteTur);
                break;
            case R.id.memoryGame_btn:
                getFragmentManager().beginTransaction().replace(R.id.gameFragmentContainer, new MemoryGameFragment()).commit();
                gameText_view.setText(R.string.huskespil);
                break;
            case R.id.balloon_btn:
                getFragmentManager().beginTransaction().replace(R.id.gameFragmentContainer, new PopBalloonGameFragment()).commit();
                gameText_view.setText(R.string.popBallonerView);
                break;
            case R.id.call_btn:
                Intent call_act = new Intent(this, CallActivity.class);
                startActivity(call_act);
                break;
            case R.id.home_btn:
                Intent homeActivity = new Intent(this, MainActivity.class);
                startActivity(homeActivity);
                break;
            default:
                break;
        }
    }

}
