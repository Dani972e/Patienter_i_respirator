package com.respirator.i.patienter.patienter_i_respirator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView home_btn = (ImageView) findViewById(R.id.home_btn);
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
