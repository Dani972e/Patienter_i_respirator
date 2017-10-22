package com.respirator.i.patienter.patienter_i_respirator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton game_btn;
    private ImageButton communication_btn;
    private ImageButton call_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton game_btn = (ImageButton) findViewById(R.id.game_btn);
        ImageButton communication_btn = (ImageButton) findViewById(R.id.communication_btn);
        ImageButton call_btn = (ImageButton) findViewById(R.id.call_btn);

        game_btn.setOnClickListener(this);
        communication_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);
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
        }

    }
}
