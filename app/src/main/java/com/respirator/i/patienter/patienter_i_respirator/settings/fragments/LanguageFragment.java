package com.respirator.i.patienter.patienter_i_respirator.settings.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.settings.activities.SettingsActivity;

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;
import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.lang;

public class LanguageFragment extends Fragment {

   public RadioGroup languageG;

   public RadioButton danish, english;

   public TextView langTxt;

   public int checked;

    public Locale locale;

    public Configuration config;

    public LanguageFragment() {
        // Required empty public constructor
    }

    private void SmallFontSize() {
        langTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        danish.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        english.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
    }

    private void MediumFontSize() {
        langTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        danish.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        english.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
    }

    private void LargeFontSize() {
        langTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        danish.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        english.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
    }

    public void Refresh() {
        Intent refresh = new Intent(getContext(), SettingsActivity.class);
        SettingsActivity.langReload = true;
        SettingsActivity.langClick = true;
        startActivity(refresh);
    }

    public void LoadLocale() {
        locale = new Locale(lang);
        Locale.setDefault(locale);

        config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config,getResources().getDisplayMetrics());
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle
            savedInstanceState) {

        final View language = inflater.inflate(R.layout.language_fragment, container, false);

        SharedPreferences langPref = getContext().getSharedPreferences("langPref",0);
        SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);

        final SharedPreferences.Editor editor = langPref.edit();

        languageG = language.findViewById(R.id.langaugeG);
        danish = language.findViewById(R.id.danish_btn);
        english = language.findViewById(R.id.english_btn);
        langTxt = language.findViewById(R.id.language_text);

        if (langPref.getString("langPref",lang).equalsIgnoreCase("en")) {
            english.setChecked(true);
        }
        else if (langPref.getString("langPref",lang).equalsIgnoreCase("")){
            danish.setChecked(true);
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
        languageG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                checked = languageG.indexOfChild(radioGroup.findViewById(checkedId));
                switch (checked) {
                    case 0:
                        lang = "en";
                        editor.putString("langPref",lang);
                        editor.apply();
                        LoadLocale();
                        Refresh();
                        break;
                    case 1:
                        lang = "";
                        editor.putString("langPref",lang);
                        editor.apply();
                        LoadLocale();
                        Refresh();
                        break;
                    default:
                        break;
                }
            }
        });

        return language;
    }
}
