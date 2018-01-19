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

public class MyAnswerFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 4;

    private final ImageView[] btnArray = new ImageView[btn_amount];

    private final int[] btnId  = {R.id.thanks_btn, R.id.iDontKnow_btn, R.id.later_btn, R.id.reset_btn};

    public TextView thanksTxt, dontKnowTxt, laterTxt, changeSettingsTxt;

    public static int activeAnswer;

    public ImageView thanksImg, dkImg, laterImg, changeImg;

    public MyAnswerFragment() {
        // Required empty public constructor
    }

    private void SmallFontSize() {
        thanksTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        dontKnowTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        laterTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        changeSettingsTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
    }

    private void MediumFontSize() {
        thanksTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        dontKnowTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        laterTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        changeSettingsTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
    }

    private void LargeFontSize() {
        thanksTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        dontKnowTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        laterTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        changeSettingsTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myAnswers = inflater.inflate(R.layout.my_answer_fragment, container, false);

        SharedPreferences fontsizePref = getActivity().getSharedPreferences("fontsizePref",0);

        thanksImg = myAnswers.findViewById(R.id.thanks_btn);
        dkImg = myAnswers.findViewById(R.id.iDontKnow_btn);
        laterImg = myAnswers.findViewById(R.id.later_btn);
        changeImg = myAnswers.findViewById(R.id.reset_btn);
        thanksTxt = myAnswers.findViewById(R.id.thanks_view);
        dontKnowTxt = myAnswers.findViewById(R.id.iDontKnow_view);
        laterTxt = myAnswers.findViewById(R.id.later_view);
        changeSettingsTxt = myAnswers.findViewById(R.id.reset_view);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = myAnswers.findViewById(btnId[i]);
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

        if (savedInstanceState != null) {
            switch (activeAnswer) {
                case R.id.thanks_btn:
                    thanksImg.setBackgroundResource(R.drawable.button_rounded_darkblue);
                    break;
                case R.id.iDontKnow_btn:
                    dkImg.setBackgroundResource(R.drawable.button_rounded_darkblue);
                    break;
                case R.id.later_btn:
                    laterImg.setBackgroundResource(R.drawable.button_rounded_darkblue);
                    break;
                case R.id.reset_btn:
                    changeImg.setBackgroundResource(R.drawable.button_rounded_darkblue);
                    break;
                default:
                    break;
            }
        }

        return myAnswers;
    }

    @Override
    public void onClick(View view) {
        for (ImageView btn : btnArray) {
            if (btn.equals(view)) {
                btn.setBackgroundResource(R.drawable.button_rounded_darkblue);
                activeAnswer = view.getId();
            } else {
                btn.setBackgroundResource(R.drawable.button_rounded_blue);
            }
        }
    }
}
