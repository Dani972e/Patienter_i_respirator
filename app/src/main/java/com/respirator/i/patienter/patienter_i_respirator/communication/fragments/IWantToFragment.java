package com.respirator.i.patienter.patienter_i_respirator.communication.fragments;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;


public class IWantToFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 12;

    private final ImageView[] btnArray = new ImageView[btn_amount];

    private final int[] btnId = {R.id.pain_btn, R.id.sucked_btn, R.id.breath_btn2, R.id.tv_btn, R.id.lightOn_btn,
            R.id.silence_btn, R.id.chair_btn, R.id.bed_btn, R.id.turnAround_btn, R.id.walk_btn, R.id.visit_btn, R.id.toilet_btn};

    public TextView painReliefTxt, suctionTxt, breathTxt, tvTxt, lightTxt, silenceTxt, chairTxt, bedTxt, turnTxt, walkTxt, visitTxt, toiletTxt;

    public IWantToFragment() {
        // Required empty public constructor
    }

    private void SmallFontSize() {
        painReliefTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        suctionTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        breathTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        tvTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        lightTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        silenceTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        chairTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        bedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        turnTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        walkTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        visitTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        toiletTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
    }

    private void MediumFontSize() {
        painReliefTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        suctionTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        breathTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        tvTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        lightTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        silenceTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        chairTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        bedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        turnTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        walkTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        visitTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        toiletTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
    }

    private void LargeFontSize() {
        painReliefTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        suctionTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        breathTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        tvTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        lightTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        silenceTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        chairTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        bedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        turnTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        walkTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        visitTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        toiletTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View iWantTo = inflater.inflate(R.layout.i_want_to_fragment, container, false);

        SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);

        painReliefTxt = iWantTo.findViewById(R.id.painReliever_view);
        suctionTxt = iWantTo.findViewById(R.id.sucked_view);
        breathTxt = iWantTo.findViewById(R.id.breath_view2);
        tvTxt = iWantTo.findViewById(R.id.television_view);
        lightTxt = iWantTo.findViewById(R.id.light_view);
        silenceTxt = iWantTo.findViewById(R.id.peace_view);
        chairTxt = iWantTo.findViewById(R.id.chair_view);
        bedTxt = iWantTo.findViewById(R.id.bed_view);
        turnTxt = iWantTo.findViewById(R.id.turn_around_view);
        walkTxt = iWantTo.findViewById(R.id.walk_view);
        visitTxt = iWantTo.findViewById(R.id.visit_view);
        toiletTxt = iWantTo.findViewById(R.id.toilet_view);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = iWantTo.findViewById(btnId[i]);
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

        return iWantTo;
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
