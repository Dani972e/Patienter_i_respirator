package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.fragments.IAmFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.IWantToFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.MyAnswerFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.WsQuestionsFragment;

public class CommActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView answer_btn, i_btn, iWantTo_btn, wsQuestion_btn, pain_btn, call_btn, keyboard_btn;
    private TextView communication_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onWindowFocusChanged(true);

        setContentView(R.layout.comm_activity);


        call_btn = findViewById(R.id.call_btn);
        answer_btn = findViewById(R.id.answer_btn);
        i_btn = findViewById(R.id.i_btn);
        iWantTo_btn = findViewById(R.id.iWantTo_btn);
        wsQuestion_btn = findViewById(R.id.wsQuestions_btn);
        pain_btn = findViewById(R.id.pain_btn);
        communication_view = findViewById(R.id.communication_view);
        keyboard_btn = findViewById(R.id.keyboard_btn);

        answer_btn.setOnClickListener(this);
        i_btn.setOnClickListener(this);
        iWantTo_btn.setOnClickListener(this);
        wsQuestion_btn.setOnClickListener(this);
        pain_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);
        keyboard_btn.setOnClickListener(this);


    }

    public void resetButtonColor(View b) {
        answer_btn.setBackgroundResource(R.drawable.button_rounded_blue);
        i_btn.setBackgroundResource(R.drawable.button_rounded_blue);
        iWantTo_btn.setBackgroundResource(R.drawable.button_rounded_blue);
        wsQuestion_btn.setBackgroundResource(R.drawable.button_rounded_blue);
        b.setBackgroundResource(R.drawable.button_rounded_darkblue);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call_btn:
                Intent call_act = new Intent(this, CallActivity.class);
                startActivity(call_act);
                break;
            case R.id.answer_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MyAnswerFragment()).commit();
                communication_view.setVisibility(View.INVISIBLE);
                resetButtonColor(view);
                break;
            case R.id.i_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new IAmFragment()).commit();
                communication_view.setVisibility(View.INVISIBLE);
                resetButtonColor(view);
                break;
            case R.id.iWantTo_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new IWantToFragment()).commit();
                communication_view.setVisibility(View.INVISIBLE);
                resetButtonColor(view);
                break;
            case R.id.wsQuestions_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new WsQuestionsFragment()).commit();
                communication_view.setVisibility(View.INVISIBLE);
                resetButtonColor(view);
                break;
            case R.id.keyboard_btn:
                Intent keyboard_activity = new Intent(this, KeyboardActivity.class);
                startActivity(keyboard_activity);
                break;

        }


    }


}



