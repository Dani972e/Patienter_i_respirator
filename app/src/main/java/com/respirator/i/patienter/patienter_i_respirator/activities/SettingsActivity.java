package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.activities.MainActivity.lang;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private final int btn_amount = 5;

    private final ImageView[] btnArray = new ImageView[btn_amount];

    private final int[] btnId = {R.id.input_btn, R.id.sound_btn, R.id.fontsize_btn, R.id.language_btn, R.id.reset_btn};

    private TextView settings_view;

    public ImageView home_btn, langBtn, soundBtn, inputBtn, resetBtn, fontBtn;

    public static boolean reload, langClick, resetClick, fontClick, soundClick, inputClick;

    @Override
    protected void onRestart()
    {
        super.onRestart();
        reload = true;
        recreate();
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("langBtn", langClick);
        savedInstanceState.putBoolean("resetBtn", resetClick);
        savedInstanceState.putBoolean("fontBtn", fontClick);
        savedInstanceState.putBoolean("soundBtn", soundClick);
        savedInstanceState.putBoolean("inputBtn", inputClick);
    }

    public void LoadLocale() {
        SharedPreferences langPref = getApplication().getSharedPreferences("langPref",0);

        lang = langPref.getString("langPref",lang);
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config,getResources().getDisplayMetrics());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            LoadLocale();
        }

        setContentView(R.layout.settings_activity);
        settings_view = findViewById(R.id.settings_view);
        langBtn = findViewById(R.id.language_btn);
        soundBtn = findViewById(R.id.sound_btn);
        resetBtn = findViewById(R.id.reset_btn);
        inputBtn = findViewById(R.id.input_btn);
        fontBtn = findViewById(R.id.fontsize_btn);
        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(this);

        if (savedInstanceState != null) {
            if (getFragmentManager().findFragmentById(R.id.settingsFragmentContainer) != null) {
                settings_view.setVisibility(View.INVISIBLE);
            }

            if (langClick) {
                langBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                langClick = false;
            }
            else if (soundClick) {
                soundBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                soundClick = false;
            }
            else if (inputClick) {
                inputBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                inputClick = false;
            }
            else if (fontClick) {
                fontBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                fontClick = false;
            }
            else if (resetClick) {
                resetBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                resetClick = false;
            }
        }

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);
        }

        if (reload) {
            getFragmentManager().beginTransaction().add(R.id.settingsFragmentContainer, new LanguageFragment(), "R.id.language_btn").commit();
            reload = false;
            settings_view.setVisibility(View.INVISIBLE);
            langBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
        }
    }

    @Override
    public void onClick(View view) {
        for (ImageView btn : btnArray) {
            if (btn.equals(view)) {
                btn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                settings_view.setVisibility(View.INVISIBLE);
            }
            else {
                btn.setBackgroundResource(R.drawable.button_rounded_grey);
            }
        }

        switch (view.getId()) {
            case R.id.input_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new InputMethodFragment()).commit();
                inputClick = true;
                soundClick = false;
                fontClick = false;
                langClick = false;
                resetClick = false;
                break;
            case R.id.sound_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new SoundFragment()).commit();
                inputClick = false;
                soundClick = true;
                fontClick = false;
                langClick = false;
                resetClick = false;            break;
            case R.id.fontsize_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new FontsizeFragment()).commit();
                inputClick = false;
                soundClick = false;
                fontClick = true;
                langClick = false;
                resetClick = false;
                break;
            case R.id.language_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new LanguageFragment()).commit();
                inputClick = false;
                soundClick = false;
                fontClick = false;
                langClick = true;
                resetClick = false;
                break;
            case R.id.reset_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new ResetFragment()).commit();
                inputClick = false;
                soundClick = false;
                fontClick = false;
                langClick = false;
                resetClick = true;
                break;
            case R.id.home_btn:
                Intent homeAct = new Intent(this,MainActivity.class);
                startActivity(homeAct);
            default:
                break;
        }
    }
}