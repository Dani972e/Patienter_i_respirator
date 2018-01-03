package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView call_btn, game_btn, communication_btn, settings_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onWindowFocusChanged(true);
        setContentView(R.layout.main_activity);

        call_btn = findViewById(R.id.call_btn);
        game_btn = findViewById(R.id.game_btn);
        communication_btn = findViewById(R.id.communication_btn);
        settings_btn = findViewById(R.id.settings_btn);

        call_btn.setOnClickListener(this);
        game_btn.setOnClickListener(this);
        communication_btn.setOnClickListener(this);
        settings_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call_btn:
                Intent call_activity = new Intent(this, CallActivity.class);
                startActivity(call_activity);
                break;
            case R.id.communication_btn:
                Intent comm_activity = new Intent(this, CommActivity.class);
                startActivity(comm_activity);
                break;
            case R.id.settings_btn:
                Intent settings_activity = new Intent(this, SettingsActivity.class);
                startActivity(settings_activity);
                break;
            case R.id.game_btn:
                Intent game_activity = new Intent(this, GameActivity.class);
                startActivity(game_activity);
                break;
            default:
                break;

        }

    }


}