package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.fragments.IAmFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.MyAnswerFragment;

import static com.respirator.i.patienter.patienter_i_respirator.R.color.backgroundColor;
import static com.respirator.i.patienter.patienter_i_respirator.R.color.darkBlue;

public class CommActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView answer_btn, i_btn, iWantTo_btn, wsQuestion_btn, pain_btn, call_btn;
    private TextView communication_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comm_activity);

        call_btn = (ImageView) findViewById(R.id.call_btn);
        answer_btn = (ImageView) findViewById(R.id.answer_btn);
        i_btn = (ImageView) findViewById(R.id.i_btn);
        iWantTo_btn = (ImageView) findViewById(R.id.iWantTo_btn);
        wsQuestion_btn = (ImageView) findViewById(R.id.wsQuestions_btn);
        pain_btn = (ImageView) findViewById(R.id.pain_btn);
        communication_view = (TextView) findViewById(R.id.communication_view);

        answer_btn.setOnClickListener(this);
        i_btn.setOnClickListener(this);
        iWantTo_btn.setOnClickListener(this);
        wsQuestion_btn.setOnClickListener(this);
        pain_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call_btn:
                Intent call_act = new Intent(this, CallActivity.class);
                startActivity(call_act);
                break;
            case R.id.answer_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MyAnswerFragment()).addToBackStack(null).commit();
                communication_view.setVisibility(View.INVISIBLE);
                break;
            case R.id.i_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new IAmFragment()).addToBackStack(null).commit();
                communication_view.setVisibility(View.INVISIBLE);
                break;

        }
    }


}
