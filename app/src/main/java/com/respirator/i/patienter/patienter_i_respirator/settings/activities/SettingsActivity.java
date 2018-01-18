package com.respirator.i.patienter.patienter_i_respirator.settings.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.main.MainActivity;
import com.respirator.i.patienter.patienter_i_respirator.settings.fragments.FontsizeFragment;
import com.respirator.i.patienter.patienter_i_respirator.settings.fragments.InputMethodFragment;
import com.respirator.i.patienter.patienter_i_respirator.settings.fragments.LanguageFragment;
import com.respirator.i.patienter.patienter_i_respirator.settings.fragments.ResetFragment;
import com.respirator.i.patienter.patienter_i_respirator.settings.fragments.SoundFragment;

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;
import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.lang;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private final int btn_amount = 5;

    private final ImageView[] btnArray = new ImageView[btn_amount];

    private final int[] btnId = {R.id.input_btn, R.id.sound_btn, R.id.fontsize_btn, R.id.language_btn, R.id.reset_btn};

    private TextView settings_view, inputTxt, soundTxt, fontsizeTxt, langTxt, resetTxt, homeTxt;

    public ImageView home_btn, langBtn, soundBtn, inputBtn, resetBtn, fontBtn;

    public static boolean langReload, fontsizeReload, resetReload;

    public static int activeSetting;
    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    private void SmallFontSize() {
        inputTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        soundTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        fontsizeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        langTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        resetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        settings_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
    }

    private void MediumFontSize() {
        inputTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        soundTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        fontsizeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        langTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        resetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        settings_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
    }

    private void LargeFontSize() {
        inputTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        soundTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        fontsizeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        langTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        resetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        settings_view.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
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

    public void CreateView() {
        setContentView(R.layout.settings_activity);
        homeTxt = findViewById(R.id.home_view);
        inputTxt = findViewById(R.id.input_view);
        soundTxt = findViewById(R.id.sound_view);
        fontsizeTxt = findViewById(R.id.fontsize_view);
        langTxt = findViewById(R.id.language_view);
        resetTxt = findViewById(R.id.reset_view);
        settings_view = findViewById(R.id.settings_view);
        langBtn = findViewById(R.id.language_btn);
        soundBtn = findViewById(R.id.sound_btn);
        resetBtn = findViewById(R.id.reset_btn);
        inputBtn = findViewById(R.id.input_btn);
        fontBtn = findViewById(R.id.fontsize_btn);
        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            LoadLocale();
        }

        SharedPreferences fontsizePref = getApplication().getSharedPreferences("fontsizePref",0);

        CreateView();

        if (savedInstanceState != null) {
            if (getFragmentManager().findFragmentById(R.id.settingsFragmentContainer) != null) {
                settings_view.setVisibility(View.INVISIBLE);
            }

            switch (activeSetting) {
                case 0:
                    inputBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                    break;
                case 1:
                    soundBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                    break;
                case 2:
                    fontBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                    break;
                case 3:
                    langBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                    break;
                case 4:
                    resetBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);
        }

        if (langReload) {
            getFragmentManager().beginTransaction().add(R.id.settingsFragmentContainer, new LanguageFragment(), "R.id.language_btn").commit();
            langReload = false;
            settings_view.setVisibility(View.INVISIBLE);
            langBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
        }
        else if (fontsizeReload) {
            getFragmentManager().beginTransaction().add(R.id.settingsFragmentContainer, new FontsizeFragment(), "R.id.fontsize_btn").commit();
            fontsizeReload = false;
            settings_view.setVisibility(View.INVISIBLE);
            fontBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
        }
        else if (resetReload) {
            getFragmentManager().beginTransaction().add(R.id.settingsFragmentContainer, new ResetFragment(), "R.id.reset_btn").commit();
            resetReload = false;
            settings_view.setVisibility(View.INVISIBLE);
            resetBtn.setBackgroundResource(R.drawable.button_rounded_darkgrey);
        }

        if (fontsizePref.getInt("fontsizePref",fontsize) == 0) {
            SmallFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 1) {
            MediumFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 2) {
            LargeFontSize();
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
                activeSetting = 0;
                break;
            case R.id.sound_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new SoundFragment()).commit();
                activeSetting = 1;
                break;
            case R.id.fontsize_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new FontsizeFragment()).commit();
                activeSetting = 2;
                break;
            case R.id.language_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new LanguageFragment()).commit();
                activeSetting = 3;
                break;
            case R.id.reset_btn:
                getFragmentManager().beginTransaction().replace(R.id.settingsFragmentContainer, new ResetFragment()).commit();
                activeSetting = 4;
                break;
            case R.id.home_btn:
                Intent homeAct = new Intent(this,MainActivity.class);
                startActivity(homeAct);
            default:
                break;
        }

    }
}