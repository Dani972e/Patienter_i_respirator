package com.respirator.i.patienter.patienter_i_respirator.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.activities.SettingsActivity;

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.activities.MainActivity.lang;


public class LanguageFragment extends Fragment {

    RadioGroup languageG;

    RadioButton danish, english;

    int checked;

    public Locale locale;

    public Configuration config;

    public LanguageFragment() {
        // Required empty public constructor
    }

    public void Refresh() {
        Intent refresh = new Intent(getContext(), SettingsActivity.class);
        SettingsActivity.reload = true;
        SettingsActivity.langClick = true;
        startActivity(refresh);
    }

    public  void LoadLocale() {
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
        final SharedPreferences.Editor editor = langPref.edit();

        languageG = language.findViewById(R.id.langaugeG);
        danish = language.findViewById(R.id.danish_btn);
        english = language.findViewById(R.id.english_btn);

        if (langPref.getString("langPref",lang).equalsIgnoreCase("en")) {
            english.setChecked(true);
        }
        else if (langPref.getString("langPref",lang).equalsIgnoreCase("")){
            danish.setChecked(true);
        }

        languageG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                checked = languageG.indexOfChild(radioGroup.findViewById(checkedId));
                switch (checked) {
                    case 0:
                        lang = "en";
                        editor.putString("langChoice",lang);
                        editor.apply();
                        LoadLocale();
                        Refresh();
                        break;
                    case 1:
                        lang = "";
                        editor.putString("langChoice",lang);
                        editor.apply();
                        LoadLocale();
                        Refresh();
                        break;
                }
            }
        });

        return language;
    }
}
