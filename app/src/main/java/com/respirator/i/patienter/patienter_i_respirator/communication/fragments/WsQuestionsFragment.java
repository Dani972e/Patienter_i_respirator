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

import static com.respirator.i.patienter.patienter_i_respirator.settings.fragments.FontsizeFragment.fontsize;

public class WsQuestionsFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 12;

    private final ImageView[] btnArray = new ImageView[btn_amount];

    private final int[] btnId = {R.id.time_btn, R.id.doing_btn, R.id.said_btn, R.id.wrong_btn, R.id.happens_today_btn, R.id.am_i_here_btn, R.id.drink_btn, R.id.bed_btn, R.id.checked_btn, R.id.where_am_i_btn, R.id.laid_btn, R.id.my_stuff_btn};

    public TextView timeTxt, doingTxt, saidTxt, wrongTxt, happensTxt, whyTxt, drinkTxt, hallTxt, checkedTxt, whereTxt, longTxt, stuffTxt;

    public WsQuestionsFragment() {
        // Required empty public constructor
    }

    private void SmallFontSize() {
        timeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        doingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        saidTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        wrongTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        happensTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        whyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        drinkTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        hallTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        checkedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        whereTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        longTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        stuffTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
    }

    private void MediumFontSize() {
        timeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        doingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        saidTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        wrongTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        happensTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        whyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        drinkTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        hallTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        checkedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        whereTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        longTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        stuffTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
    }

    private void LargeFontSize() {
        timeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        doingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        saidTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        wrongTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        happensTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        whyTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        drinkTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        hallTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        checkedTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        whereTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        longTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        stuffTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ws = inflater.inflate(R.layout.ws_questions_fragment, container, false);

        SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);

        timeTxt = ws.findViewById(R.id.time_view);
        doingTxt = ws.findViewById(R.id.doing_view);
        saidTxt = ws.findViewById(R.id.said_view);
        wrongTxt = ws.findViewById(R.id.wrong_view);
        happensTxt = ws.findViewById(R.id.happens_view);
        whyTxt = ws.findViewById(R.id.am_i_here_view);
        drinkTxt = ws.findViewById(R.id.drink_view);
        hallTxt = ws.findViewById(R.id.hall_view);
        checkedTxt = ws.findViewById(R.id.checked_view);
        whereTxt = ws.findViewById(R.id.where_am_i_view);
        longTxt = ws.findViewById(R.id.laid_view);
        stuffTxt = ws.findViewById(R.id.my_stuff_view);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = ws.findViewById(btnId[i]);
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

        return ws;
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
