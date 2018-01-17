package com.respirator.i.patienter.patienter_i_respirator.communication.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.call.CallActivity;
import com.respirator.i.patienter.patienter_i_respirator.main.MainActivity;
import com.respirator.i.patienter.patienter_i_respirator.communication.fragments.IAmFragment;
import com.respirator.i.patienter.patienter_i_respirator.communication.fragments.IWantToFragment;
import com.respirator.i.patienter.patienter_i_respirator.communication.fragments.MyAnswerFragment;
import com.respirator.i.patienter.patienter_i_respirator.communication.fragments.PainFragment;
import com.respirator.i.patienter.patienter_i_respirator.communication.fragments.WsQuestionsFragment;

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.lang;

public class CommActivity extends AppCompatActivity implements View.OnClickListener {

    private final int btn_amount = 5;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.answer_btn, R.id.i_btn, R.id.iWantTo_btn, R.id.wsQuestions_btn, R.id.pain_btn};

    private ImageView call_btn, keyboard_btn, home_btn;
    private TextView comm_view;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            LoadLocale();
        }

        onWindowFocusChanged(true);

        setContentView(R.layout.comm_activity);

        comm_view = findViewById(R.id.comm_view);
        keyboard_btn = findViewById(R.id.keyboard_btn);
        call_btn = findViewById(R.id.call_btn);
        home_btn = findViewById(R.id.home_btn);
        call_btn.setOnClickListener(this);
        keyboard_btn.setOnClickListener(this);
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
                btn.setBackgroundResource(R.drawable.button_rounded_darkblue);
                comm_view.setVisibility(View.INVISIBLE);
            } else {
                btn.setBackgroundResource(R.drawable.button_rounded_blue);
            }

        }

        switch (view.getId()) {
            case R.id.call_btn:
                Intent call_act = new Intent(this, CallActivity.class);
                startActivity(call_act);
                break;
            case R.id.answer_btn:
                getFragmentManager().beginTransaction().replace(R.id.commFragmentContainer, new MyAnswerFragment()).commit();
                break;
            case R.id.i_btn:
                getFragmentManager().beginTransaction().replace(R.id.commFragmentContainer, new IAmFragment()).commit();
                break;
            case R.id.iWantTo_btn:
                getFragmentManager().beginTransaction().replace(R.id.commFragmentContainer, new IWantToFragment()).commit();
                break;
            case R.id.wsQuestions_btn:
                getFragmentManager().beginTransaction().replace(R.id.commFragmentContainer, new WsQuestionsFragment()).commit();
                break;
            case R.id.pain_btn:
                getFragmentManager().beginTransaction().replace(R.id.commFragmentContainer, new PainFragment()).commit();
                break;
            case R.id.keyboard_btn:
                Intent keyboard_activity = new Intent(this, KeyboardActivity.class);
                startActivity(keyboard_activity);
                break;
            case R.id.home_btn:
                Intent main_activity = new Intent(this, MainActivity.class);
                startActivity(main_activity);
                break;
            default:
                break;
        }


    }


}



