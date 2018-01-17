package com.respirator.i.patienter.patienter_i_respirator.communication.fragments;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;

public class IAmFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 12;

    private final ImageView[] btnArray = new ImageView[btn_amount];

    private final int[] btnId = {R.id.happy_btn, R.id.okay_btn, R.id.tired_btn, R.id.frustrated_btn, R.id.scared_btn, R.id.worried_btn, R.id.bored_btn,
            R.id.breath_btn, R.id.thirsty_btn, R.id.warm_btn, R.id.cold_btn, R.id.sore_btn};

    public TextView happyTxt, okayTxt, tiredTxt, frustatedTxt, scaredTxt, worriedTxt, boredTxt, breathTxt, thirstyTxt, hotTxt, coldTxt, soreTxt;


    public IAmFragment() {
        // Required empty public constructor
    }

    private void SmallFontSize() {
        happyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        okayTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        tiredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        frustatedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        scaredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        worriedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        boredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        breathTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        thirstyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        hotTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        coldTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        soreTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
    }

    private void MediumFontSize() {
        happyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        okayTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        tiredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        frustatedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        scaredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        worriedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        boredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        breathTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        thirstyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        hotTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        coldTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        soreTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
    }

    private void LargeFontSize() {
        happyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        okayTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        tiredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        frustatedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        scaredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        worriedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        boredTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        breathTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        thirstyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        hotTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        coldTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        soreTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View iAm = inflater.inflate(R.layout.i_am_fragment, container, false);

        SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);

        happyTxt = iAm.findViewById(R.id.happy_view);
        okayTxt = iAm.findViewById(R.id.okay_view);
        tiredTxt = iAm.findViewById(R.id.tired_view);
        frustatedTxt = iAm.findViewById(R.id.frustrated_view);
        scaredTxt = iAm.findViewById(R.id.scared_view);
        worriedTxt = iAm.findViewById(R.id.worried_view);
        boredTxt = iAm.findViewById(R.id.bored_view);
        breathTxt = iAm.findViewById(R.id.breath_view);
        thirstyTxt = iAm.findViewById(R.id.thirsty_view);
        hotTxt = iAm.findViewById(R.id.warm_view);
        coldTxt = iAm.findViewById(R.id.cold_view);
        soreTxt = iAm.findViewById(R.id.sore_view);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = iAm.findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);

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

        return iAm;

    }


    @Override
    public void onClick(View view) {

        for (ImageView btn : btnArray) {
            if (btn.equals(view)) {
                btn.setBackgroundResource(R.drawable.button_rounded_darkblue);
            } else {
                btn.setBackgroundResource(R.drawable.button_rounded_blue);
            }

        }

    }
}


