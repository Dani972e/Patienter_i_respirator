package com.respirator.i.patienter.patienter_i_respirator.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.call.CallActivity;
import com.respirator.i.patienter.patienter_i_respirator.communication.activities.CommActivity;
import com.respirator.i.patienter.patienter_i_respirator.game.activities.GameActivity;
import com.respirator.i.patienter.patienter_i_respirator.settings.activities.SettingsActivity;

import java.util.Locale;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public ImageView call_btn, game_btn, communication_btn, settings_btn;

    public TextView authors, gameTxt, comTxt, callTxt;

    public static String lang = "";

    public static int fontsize = 1;

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
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        gameTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        comTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
    }

    private void MediumFontSize() {
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        gameTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        comTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
    }

    private void LargeFontSize() {
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
        gameTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
        comTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
    }

    public void CreateView() {
        call_btn = findViewById(R.id.call_btn);
        authors = findViewById(R.id.authors);
        game_btn = findViewById(R.id.game_btn);
        communication_btn = findViewById(R.id.communication_btn);
        settings_btn = findViewById(R.id.settings_btn);
        callTxt = findViewById(R.id.call_view);
        gameTxt = findViewById(R.id.game_view);
        comTxt = findViewById(R.id.communication_view);

        call_btn.setOnClickListener(this);
        game_btn.setOnClickListener(this);
        communication_btn.setOnClickListener(this);
        settings_btn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean EMULATOR = Build.PRODUCT.contains("sdk") || Build.MODEL.contains("Emulator");
        if (!EMULATOR) {
            Fabric.with(this, new Crashlytics());
        }

        //Fabric.with(this, new Crashlytics());

        SharedPreferences langPref = getApplication().getSharedPreferences("langPref", 0);
        SharedPreferences fontsizePref = getApplication().getSharedPreferences("fontsizePref",0);
        lang = langPref.getString("langPref", lang);

        if (lang.equalsIgnoreCase("")) {
            LoadLocale();
        }
        else if (lang.equalsIgnoreCase("en")){
            LoadLocale();
        }
        else if (savedInstanceState != null) {
            LoadLocale();
        }

        onWindowFocusChanged(true);
        setContentView(R.layout.main_activity);

        CreateView();

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
            case R.id.call_btn:
                Intent call_activity = new Intent(this, CallActivity.class);
                startActivity(call_activity);
                break;
            case R.id.communication_btn:
                Intent comm_activity = new Intent(this, CommActivity.class);
                startActivity(comm_activity);
                break;
            case R.id.settings_btn:
                Intent settings_activity = new Intent(this, SettingsActivity.class);
                startActivity(settings_activity);
                break;
            case R.id.game_btn:
                Intent game_activity = new Intent(this, GameActivity.class);
                startActivity(game_activity);
                break;
            default:
                break;

        }
    }


}