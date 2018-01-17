package com.respirator.i.patienter.patienter_i_respirator.settings.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class FontsizeFragment extends Fragment {

    public RadioGroup fontG;

    public RadioButton small, medium, large;

    int checked;

    public static int fontsize = 1;

    public TextView fontsizeTxt;

    public FontsizeFragment() {
        // Required empty public constructor
    }

    public void Refresh() {
        Intent refresh = new Intent(getContext(), SettingsActivity.class);
        SettingsActivity.fontsizeReload = true;
        SettingsActivity.fontClick = true;
        startActivity(refresh);
    }

    private void SmallFontSize() {
        fontsizeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
    }

    private void MediumFontSize() {
        fontsizeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
    }

    private void LargeFontSize() {
        fontsizeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View fontsizeFrag = inflater.inflate(R.layout.fontsize_fragment, container, false);

        SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);
        final SharedPreferences.Editor editor = fontsizePref.edit();

        fontsizeTxt = fontsizeFrag.findViewById(R.id.fontsize_view);
        fontG = fontsizeFrag.findViewById(R.id.fontG);
        small = fontsizeFrag.findViewById(R.id.fontsize_small_btn);
        medium = fontsizeFrag.findViewById(R.id.fontsize_middle_btn);
        large = fontsizeFrag.findViewById(R.id.fontsize_big_btn);

        if (fontsizePref.getInt("fontsizePref",fontsize) == 0) {
            SmallFontSize();
            small.setChecked(true);
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 1) {
            MediumFontSize();
            medium.setChecked(true);
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 2) {
            LargeFontSize();
            large.setChecked(true);
        }


        fontG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                checked = fontG.indexOfChild(radioGroup.findViewById(checkedId));
                switch (checked) {
                    case 0:
                        fontsize = 0;
                        editor.putInt("fontsizePref",fontsize);
                        editor.apply();
                        SmallFontSize();
                        Refresh();
                        break;
                    case 1:
                        fontsize = 1;
                        editor.putInt("fontsizePref",fontsize);
                        editor.apply();
                        MediumFontSize();
                        Refresh();
                        break;
                    case 2:
                        fontsize = 2;
                        editor.putInt("fontsizePref",fontsize);
                        editor.apply();
                        LargeFontSize();
                        Refresh();
                        break;
                    default:
                        break;
                }
            }
        });
        return fontsizeFrag;
    }
}
