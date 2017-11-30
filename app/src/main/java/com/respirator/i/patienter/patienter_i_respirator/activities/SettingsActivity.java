package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.fragments.FontsizeFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.InputMethodFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.SoundFragment;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView indput_btn, sound_btn, fontsize_btn, language_btn, reset_btn;
    private TextView settings_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);


        indput_btn = findViewById(R.id.input_btn);
        sound_btn = findViewById(R.id.sound_btn);
        fontsize_btn = findViewById(R.id.fontsize_btn);
        language_btn = findViewById(R.id.language_btn);
        reset_btn = findViewById(R.id.reset_btn);
        settings_view = findViewById(R.id.settings_view);

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
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new InputMethodFragment()).commit();
                settings_view.setVisibility(View.INVISIBLE);
                break;
            case R.id.sound_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new SoundFragment()).commit();
                settings_view.setVisibility(View.INVISIBLE);
                break;
            case R.id.fontsize_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new FontsizeFragment()).commit();
                settings_view.setVisibility(View.INVISIBLE);
                break;

        }

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
