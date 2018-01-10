package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;

public class CallActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView back_btn, home_btn;

    Button help_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onWindowFocusChanged(true);

        setContentView(R.layout.call_activity);

        back_btn = findViewById(R.id.back_btn);
        home_btn = findViewById(R.id.home_btn);
        help_btn = findViewById(R.id.help_btn);

        back_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
        help_btn.setOnClickListener(this);

        SharedPreferences soundSettings = getSharedPreferences("soundChoice", 0);
        final boolean sound = soundSettings.getBoolean("1",true);

        final MediaPlayer help_sound = MediaPlayer.create(this, R.raw.sound1);
        final MediaPlayer help_sound2 = MediaPlayer.create(this, R.raw.sound2);

        help_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (sound) {
                    help_sound.start();
                }
                else if (!sound){
                    help_sound2.start();
                }

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
                Intent mainAct = new Intent(this,MainActivity.class);
                startActivity(mainAct);
                break;
        }
    }
}
