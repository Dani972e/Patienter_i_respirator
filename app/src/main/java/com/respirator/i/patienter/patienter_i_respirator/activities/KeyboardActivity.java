package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;

public class KeyboardActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard_activity);

        EditText keyboard = findViewById(R.id.keyboard);
        ImageView back_btn = findViewById(R.id.back_btn);
        ImageView home_btn = findViewById(R.id.home_btn);
        ImageView call_btn = findViewById(R.id.call_btn);

        InputMethodManager imm = (InputMethodManager) this.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.showSoftInput(keyboard, 0);


        back_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);
        keyboard.setOnClickListener(this);
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
                Intent callActivity = new Intent(this, CallActivity.class);
                startActivity(callActivity);
                break;
        }
    }
}
