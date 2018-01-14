package com.respirator.i.patienter.patienter_i_respirator.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.crashlytics.android.Crashlytics;
import com.respirator.i.patienter.patienter_i_respirator.R;

import java.util.Locale;

import io.fabric.sdk.android.Fabric;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView call_btn, game_btn, communication_btn, settings_btn;

    public static String lang = "";

    public void LoadLocale() {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config,getResources().getDisplayMetrics());
    }

    public void CreateBtn() {
        call_btn = findViewById(R.id.call_btn);
        game_btn = findViewById(R.id.game_btn);
        communication_btn = findViewById(R.id.communication_btn);
        settings_btn = findViewById(R.id.settings_btn);

        call_btn.setOnClickListener(this);
        game_btn.setOnClickListener(this);
        communication_btn.setOnClickListener(this);
        settings_btn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        SharedPreferences langPref = getSharedPreferences("langPref", 0);
        lang = langPref.getString("langChoice", lang);

        if (lang.equalsIgnoreCase("")) {
            LoadLocale();
        }
        else if (lang.equalsIgnoreCase("en")){
            LoadLocale();
        }

        onWindowFocusChanged(true);
        setContentView(R.layout.main_activity);

        CreateBtn();
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