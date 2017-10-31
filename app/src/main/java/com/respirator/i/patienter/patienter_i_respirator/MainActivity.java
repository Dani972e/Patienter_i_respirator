package com.respirator.i.patienter.patienter_i_respirator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView game_btn;
    private ImageView communication_btn;
    private ImageView call_btn;
    private ImageView settings_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView game_btn = (ImageView) findViewById(R.id.game_btn);
        ImageView communication_btn = (ImageView) findViewById(R.id.communication_btn);
        ImageView call_btn = (ImageView) findViewById(R.id.call_btn);
        ImageView settings_btn = (ImageView) findViewById(R.id.settings_btn);

        game_btn.setOnClickListener(this);
        communication_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);
        settings_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.game_btn:
                Intent game = new Intent(this, GameActivity.class);
                startActivity(game);
                break;
            case R.id.communication_btn:
                Intent communication = new Intent(this, CommunicationActivity.class);
                startActivity(communication);
                break;
            case R.id.call_btn:
                Intent call_main = new Intent(this, CallActivity.class);
                startActivity(call_main);
                break;
            case R.id.settings_btn:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                break;
        }

    }
}
