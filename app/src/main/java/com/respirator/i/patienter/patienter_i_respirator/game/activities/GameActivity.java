package com.respirator.i.patienter.patienter_i_respirator.game.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.call.CallActivity;
import com.respirator.i.patienter.patienter_i_respirator.main.MainActivity;
import com.respirator.i.patienter.patienter_i_respirator.game.fragments.MemoryGameFragment;
import com.respirator.i.patienter.patienter_i_respirator.game.fragments.PopBalloonGameFragment;
import com.respirator.i.patienter.patienter_i_respirator.game.fragments.QuizFragment;
import com.respirator.i.patienter.patienter_i_respirator.game.fragments.TicTacToeGameFragment;

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;
import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.lang;

//import com.respirator.i.patienter.patienter_i_respirator.fragments.PuzzleGameFragment;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private final int btn_amount = 4;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.balloon_btn, R.id.memoryGame_btn, R.id.ticTacToe_btn, R.id.quiz_btn};
    public ImageView call_btn, home_btn;
    public TextView gameText_view, game_view, ticTacTxt, quizTxt, balloonTxt, memoryTxt, callTxt, homeTxt;

    protected void onRestart()
    {
        super.onRestart();
        recreate();
    }

    public void LoadLocale() {
        SharedPreferences langPref = getApplication().getSharedPreferences("langPref",0);

        lang = langPref.getString("langPref",lang);
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config,getResources().getDisplayMetrics());
    }

    private void SmallFontSize() {
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        ticTacTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        quizTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        balloonTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        game_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        memoryTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        gameText_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
    }

    private void MediumFontSize() {
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        ticTacTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        quizTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        balloonTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        game_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        memoryTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        gameText_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
    }

    private void LargeFontSize() {
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
        ticTacTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        quizTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        balloonTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        game_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        memoryTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        gameText_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
    }

    public void CreateView() {
        setContentView(R.layout.game_activity);
        callTxt = findViewById(R.id.call_view);
        ticTacTxt = findViewById(R.id.tictactoe_view);
        quizTxt = findViewById(R.id.quiz_view);
        balloonTxt = findViewById(R.id.balloons_view);
        game_view = findViewById(R.id.game_view);
        memoryTxt = findViewById(R.id.memoryGame_view);
        homeTxt = findViewById(R.id.home_view);
        gameText_view = findViewById(R.id.gameText_view);
        call_btn = findViewById(R.id.call_btn);
        home_btn = findViewById(R.id.home_btn);
        call_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onWindowFocusChanged(true);

        SharedPreferences fontsizePref = getApplication().getSharedPreferences("fontsizePref",0);

        if (savedInstanceState != null) {
            LoadLocale();
        }

        CreateView();

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);
        }

        if (fontsizePref.getInt("fontsizePref",fontsize) == 0) {
            SmallFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 1) {
            MediumFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 2) {
            LargeFontSize();
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
