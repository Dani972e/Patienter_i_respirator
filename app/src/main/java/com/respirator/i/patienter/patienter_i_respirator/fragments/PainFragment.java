package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class PainFragment extends Fragment implements View.OnClickListener, View.OnTouchListener {


    private final int btn_amount = 5;
    private final Button[] btnArray = new Button[btn_amount];
    private final int[] btnId = {R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5};

    private ImageView front_btn, behind_btn;


    public PainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View pain = inflater.inflate(R.layout.pain_fragment, container, false);

        front_btn = pain.findViewById(R.id.front_btn);
        behind_btn = pain.findViewById(R.id.behind_btn);

        front_btn.setOnTouchListener(this);
        behind_btn.setOnTouchListener(this);


        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = pain.findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);

        }


        return pain;
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        System.out.println("on touch" + x + " " + y);


        return false;
    }


    @Override
    public void onClick(View view) {


    }

}
