package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.fragments.FontsizeFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.InputMethodFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.LanguageFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.ResetFragment;
import com.respirator.i.patienter.patienter_i_respirator.fragments.SoundFragment;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private final int btn_amount = 5;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.input_btn, R.id.sound_btn, R.id.fontsize_btn, R.id.language_btn, R.id.reset_btn};
    private TextView settings_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        settings_view = findViewById(R.id.settings_view);


        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);

        }

    }

    @Override
    public void onClick(View view) {
        for (ImageView btn : btnArray) {
            if (btn.equals(view)) {
                btn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                settings_view.setVisibility(View.INVISIBLE);
            } else {
                btn.setBackgroundResource(R.drawable.button_rounded_grey);
            }

        }

        switch (view.getId()) {
            case R.id.input_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new InputMethodFragment()).commit();
                break;
            case R.id.sound_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new SoundFragment()).commit();
                break;
            case R.id.fontsize_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new FontsizeFragment()).commit();
                break;
            case R.id.language_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new LanguageFragment()).commit();
                break;
            case R.id.reset_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new ResetFragment()).commit();
                break;
             default:

        }

    }


}
