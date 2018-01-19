package com.respirator.i.patienter.patienter_i_respirator.communication.activities;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.call.CallActivity;
import com.respirator.i.patienter.patienter_i_respirator.main.MainActivity;

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;
import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.lang;

public class KeyboardActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView backTxt, homeTxt, callTxt, keyboardTxt;

    public ImageView back_btn, home_btn, call_btn;

    public EditText keyboard;

    protected void onRestart()
    {
        super.onRestart();
        recreate();
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

    private void SmallFontSize() {
        backTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        keyboardTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
    }

    private void MediumFontSize() {
        backTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        keyboardTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
    }

    private void LargeFontSize() {
        backTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
        keyboardTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
    }

    public void CreateView() {
        setContentView(R.layout.keyboard_activity);
        backTxt = findViewById(R.id.back_view);
        homeTxt = findViewById(R.id.home_view);
        callTxt = findViewById(R.id.call_view);
        keyboardTxt = findViewById(R.id.keyboard_view);
        keyboard = findViewById(R.id.keyboard);
        back_btn = findViewById(R.id.back_btn);
        home_btn = findViewById(R.id.home_btn);
        call_btn = findViewById(R.id.call_btn);
        back_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
        call_btn.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            LoadLocale();
        }

        CreateView();

        SharedPreferences fontsizePref = getApplication().getSharedPreferences("fontsizePref",0);

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
            case R.id.keyboard:
                InputMethodManager imm = (InputMethodManager) getApplication().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(keyboard, InputMethodManager.SHOW_IMPLICIT);
                break;
            default:
                break;
        }
    }
}
