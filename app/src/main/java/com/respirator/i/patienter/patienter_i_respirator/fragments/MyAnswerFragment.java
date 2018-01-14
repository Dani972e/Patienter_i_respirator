package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class MyAnswerFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 4;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId  = {R.id.thanks_btn, R.id.iDontKnow_btn, R.id.later_btn, R.id.reset_btn};

    public MyAnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myAnswers = inflater.inflate(R.layout.my_answer_fragment, container, false);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = myAnswers.findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);
        }

        return myAnswers;
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
