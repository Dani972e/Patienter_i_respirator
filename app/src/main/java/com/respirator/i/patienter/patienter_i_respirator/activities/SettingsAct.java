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

public class SettingsAct extends AppCompatActivity implements View.OnClickListener {

    private final int btn_amount = 5;

    private final ImageView[] btnArray = new ImageView[btn_amount];

    private final int[] btnId = {R.id.input_btn, R.id.sound_btn, R.id.fontsize_btn, R.id.language_btn, R.id.reset_btn};

    private TextView settings_view;

    public ImageView home_btn, langBtn;

    public static boolean reload, langClick;

    @Override
    protected void onRestart()
    {
        super.onRestart();
        reload = true;
        recreate();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("langBtn", langClick);
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
        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(this);

        if (savedInstanceState != null) {
            if (getFragmentManager().findFragmentById(R.id.settingsFragmentContainer) != null) {
                settings_view.setVisibility(View.INVISIBLE);
            }

            langClick = savedInstanceState.getBoolean("langBtn");
            if (langClick) {
                langBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                langClick = false;
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
                break;
            case R.id.sore_btn:
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
            case R.id.home_btn:
                Intent homeAct = new Intent(this,MainActivity.class);
                startActivity(homeAct);
            default:
                break;
        }
    }
}