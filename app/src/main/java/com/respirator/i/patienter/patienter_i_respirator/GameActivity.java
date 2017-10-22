package com.respirator.i.patienter.patienter_i_respirator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageButton home_btn = (ImageButton) findViewById(R.id.home_btn);
        home_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_btn:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
                break;
        }

    }
}
