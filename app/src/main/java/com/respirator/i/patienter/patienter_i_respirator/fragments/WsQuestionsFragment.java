package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;

public class WsQuestionsFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 12;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.time_btn, R.id.doing_btn, R.id.said_btn, R.id.wrong_btn, R.id.happens_today_btn, R.id.am_i_here_btn, R.id.drink_btn, R.id.bed_btn, R.id.checked_btn, R.id.where_am_i_btn, R.id.laid_btn, R.id.my_stuff_btn};


    public WsQuestionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ws = inflater.inflate(R.layout.ws_questions_fragment, container, false);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = ws.findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);
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
