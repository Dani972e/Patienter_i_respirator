package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.fragments.InputmetodeFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.LydFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.SkriftFragment;

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
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new InputmetodeFragment()).commit();
                settings_view.setVisibility(View.INVISIBLE);
                break;

            case R.id.sound_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new LydFragment()).commit();
                settings_view.setVisibility(View.INVISIBLE);
                break;

            case R.id.fontsize_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new SkriftFragment()).commit();
                settings_view.setVisibility(View.INVISIBLE);
        }

    }

}
