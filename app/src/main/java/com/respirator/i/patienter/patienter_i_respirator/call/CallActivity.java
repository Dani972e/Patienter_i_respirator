package com.respirator.i.patienter.patienter_i_respirator.call;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.main.MainActivity;

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;
import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.lang;

public class CallActivity extends AppCompatActivity implements View.OnClickListener {

    public ImageView back_btn, home_btn;

    public TextView backTxt, homeTxt;

    public Button help_btn;

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
        help_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        backTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
    }

    private void MediumFontSize() {
        help_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        backTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
    }

    private void LargeFontSize() {
        help_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,70);
        homeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        backTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            LoadLocale();
        }

        onWindowFocusChanged(true);

        setContentView(R.layout.call_activity);
        backTxt = findViewById(R.id.back_view);
        homeTxt = findViewById(R.id.home_view);
        back_btn = findViewById(R.id.back_btn);
        home_btn = findViewById(R.id.home_btn);
        help_btn = findViewById(R.id.help_btn);

        back_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);
        help_btn.setOnClickListener(this);

        SharedPreferences soundSettings = getSharedPreferences("soundChoice", 0);
        SharedPreferences fontsizePref = getApplication().getSharedPreferences("fontsizePref",0);
        final boolean sound = soundSettings.getBoolean("1",true);

        if (fontsizePref.getInt("fontsizePref",fontsize) == 0) {
            SmallFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 1) {
            MediumFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 2) {
            LargeFontSize();
        }

        final MediaPlayer help_sound = MediaPlayer.create(this, R.raw.sound1);
        final MediaPlayer help_sound2 = MediaPlayer.create(this, R.raw.sound2);

        help_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (sound) {
                    help_sound.start();
                    Toast.makeText(CallActivity.this, getResources().getString(R.string.callMsg), Toast.LENGTH_LONG).show();
                }
                else if (!sound){
                    help_sound2.start();
                    Toast.makeText(CallActivity.this, getResources().getString(R.string.callMsg), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_btn:
                onBackPressed();
                break;
            case R.id.home_btn:
                Intent mainAct = new Intent(this,MainActivity.class);
                startActivity(mainAct);
                break;
        }
    }
}
