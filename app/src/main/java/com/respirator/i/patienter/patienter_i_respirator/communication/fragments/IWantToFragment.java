package com.respirator.i.patienter.patienter_i_respirator.communication.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class IWantToFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 12;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.pain_btn, R.id.sucked_btn, R.id.breath_btn2, R.id.tv_btn, R.id.lightOn_btn, R.id.silence_btn, R.id.chair_btn, R.id.bed_btn, R.id.turnAround_btn, R.id.walk_btn, R.id.visit_btn, R.id.toilet_btn};

    public IWantToFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View iWantTo = inflater.inflate(R.layout.i_want_to_fragment, container, false);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = iWantTo.findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);
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


    public void playSoundButton(int btnId) {
        switch (btnId) {

        }
    }


}
