package com.respirator.i.patienter.patienter_i_respirator.settings.fragments;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.settings.activities.SettingsActivity;

import java.util.Locale;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;
import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.lang;

/**
 * Created by Johnny on 29/11/17.
 */

public class ResetFragment extends Fragment implements View.OnClickListener {

    public Button resetBtn;

    public TextView resetTxt;

    private void SmallFontSize() {
        resetBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        resetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
    }

    private void MediumFontSize() {
        resetBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        resetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);

    }

    private void LargeFontSize() {
        resetBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        resetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
    }

    public void ShowToast() {
        Toast.makeText(getContext(),R.string.resetToast,Toast.LENGTH_LONG).show();
    }

    public void Refresh() {
        Intent refresh = new Intent(getContext(), SettingsActivity.class);
        SettingsActivity.resetReload = true;
        startActivity(refresh);
    }

    public void LoadLocale() {
        SharedPreferences langPref = getContext().getSharedPreferences("langPref",0);

        lang = langPref.getString("langPref",lang);
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config,getResources().getDisplayMetrics());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View reset = inflater.inflate(R.layout.reset_fragment, container, false);

       SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);

       resetTxt = reset.findViewById(R.id.reset_text);
       resetBtn = reset.findViewById(R.id.reset_btn);
       resetBtn.setOnClickListener(this);

        if (fontsizePref.getInt("fontsizePref",fontsize) == 0) {
            SmallFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 1) {
            MediumFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 2) {
            LargeFontSize();
        }

       return reset;
    }

    @Override
    public void onClick(View view) {
        if (view == resetBtn) {
            AlertDialog.Builder reset = new AlertDialog.Builder(getContext());
            reset.setTitle(R.string.resetTitle);
            reset.setMessage(R.string.resetMsg);
            reset.setPositiveButton(R.string.resetBtn,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);
                    final SharedPreferences.Editor editor1 = fontsizePref.edit();
                    SharedPreferences soundSettings = getContext().getSharedPreferences("soundChoice", 0);
                    final SharedPreferences.Editor editor2 = soundSettings.edit();
                    SharedPreferences langPref = getContext().getSharedPreferences("langPref",0);
                    final SharedPreferences.Editor editor3 = langPref.edit();

                    lang = "";
                    fontsize = 1;
                    editor1.putInt("fontsizePref",fontsize).apply();
                    editor2.putBoolean("1",true).apply();
                    editor3.putString("langPref",lang).apply();
                    LoadLocale();
                    Refresh();
                    ShowToast();
                }
            });

            reset.setNegativeButton(R.string.resetCancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            reset.create();
            reset.show();
        }

    }
}
