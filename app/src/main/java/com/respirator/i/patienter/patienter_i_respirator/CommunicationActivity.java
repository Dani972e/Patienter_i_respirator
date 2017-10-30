package com.respirator.i.patienter.patienter_i_respirator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CommunicationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView answer_btn;
    private ImageView i_btn;
    private ImageView iWantTo_btn;
    private ImageView wsQuestion_btn;
    private ImageView pain_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        ImageView answer_btn = (ImageView) findViewById(R.id.answer_btn);
        ImageView i_btn = (ImageView) findViewById(R.id.i_btn);
        ImageView iWantTo_btn = (ImageView) findViewById(R.id.iWantTo_btn);
        ImageView wsQuestion_btn = (ImageView) findViewById(R.id.wsQuestions_btn);
        ImageView pain_btn = (ImageView) findViewById(R.id.pain_btn);


        answer_btn.setOnClickListener(this);
        i_btn.setOnClickListener(this);
        iWantTo_btn.setOnClickListener(this);
        wsQuestion_btn.setOnClickListener(this);
        pain_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


    }
}
