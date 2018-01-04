package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;

public class KeyboardActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back_btn, home_btn, call_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard_activity);

        back_btn = findViewById(R.id.back_btn);
        home_btn = findViewById(R.id.home_btn);
        call_btn = findViewById(R.id.call_btn);

        back_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                Intent commActivity = new Intent(this, CommActivity.class);
                startActivity(commActivity);
                break;
            case R.id.home_btn:
                Intent homeActivity = new Intent(this, MainActivity.class);
                startActivity(homeActivity);
                break;
            case R.id.call_btn:
                Intent callActivity = new Intent (this, CallActivity.class);
                startActivity(callActivity);
                break;
        }
    }
}
