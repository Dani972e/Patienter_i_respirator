package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class IAmFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 12;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.happy_btn, R.id.okay_btn, R.id.tired_btn, R.id.frustrated_btn, R.id.scared_btn, R.id.worried_btn, R.id.bored_btn, R.id.breath_btn, R.id.thirsty_btn, R.id.warm_btn, R.id.cold_btn, R.id.sore_btn};

    public IAmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View iAm = inflater.inflate(R.layout.i_am_fragment, container, false);
        // Inflate the layout for this fragment

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = iAm.findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);

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


