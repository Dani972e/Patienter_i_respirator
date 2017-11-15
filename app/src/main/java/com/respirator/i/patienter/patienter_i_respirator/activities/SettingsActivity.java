package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.fragments.InputFragment;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView indput_btn, sound_btn, fontsize_btn, language_btn, reset_btn;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);


        if (savedInstanceState == null) {

        }

        indput_btn = (ImageView) findViewById(R.id.input_btn);
        sound_btn = (ImageView) findViewById(R.id.sound_btn);
        fontsize_btn = (ImageView) findViewById(R.id.fontsize_btn);
        language_btn = (ImageView) findViewById(R.id.language_btn);
        reset_btn = (ImageView) findViewById(R.id.reset_btn);

        indput_btn.setOnClickListener(this);
        sound_btn.setOnClickListener(this);
        fontsize_btn.setOnClickListener(this);
        language_btn.setOnClickListener(this);
        reset_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.input_btn:

        }

    }

}
