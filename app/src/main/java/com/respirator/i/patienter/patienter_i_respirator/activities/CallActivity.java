package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;

public class CallActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onWindowFocusChanged(true);

        setContentView(R.layout.call_activity);

        ImageView back_btn = findViewById(R.id.back_btn);
        ImageView home_btn = findViewById(R.id.home_btn);
        Button help_btn = findViewById(R.id.help_btn);

        back_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
        help_btn.setOnClickListener(this);

        final MediaPlayer help_sound = MediaPlayer.create(this, R.raw.multimedia_event_tone_1);

        help_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                 help_sound.start();
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_btn:
                onBackPressed();
                break;
            case R.id.home_btn:
                Intent mainAct = new Intent(this, MainActivity.class);
                startActivity(mainAct);
                break;
        }
    }
}