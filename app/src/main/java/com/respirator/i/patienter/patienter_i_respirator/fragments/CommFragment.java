package com.respirator.i.patienter.patienter_i_respirator.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class CommFragment extends Fragment implements View.OnClickListener {

    private ImageView answer_btn, i_btn, iWantTo_btn, wsQuestion_btn, pain_btn;
    private ViewGroup menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        menu = (ViewGroup) inflater.inflate(R.layout.comm_fragment, container, false);

        answer_btn = menu.findViewById(R.id.answer_btn);
        i_btn = menu.findViewById(R.id.i_btn);
        iWantTo_btn = menu.findViewById(R.id.iWantTo_btn);
        wsQuestion_btn = menu.findViewById(R.id.wsQuestions_btn);
        pain_btn = menu.findViewById(R.id.pain_btn);

        answer_btn.setOnClickListener(this);
        i_btn.setOnClickListener(this);
        iWantTo_btn.setOnClickListener(this);
        wsQuestion_btn.setOnClickListener(this);
        pain_btn.setOnClickListener(this);


        return menu;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.answer_btn:


        }

    }
}
