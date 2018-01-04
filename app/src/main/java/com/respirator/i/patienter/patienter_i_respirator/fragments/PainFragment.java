package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class PainFragment extends Fragment implements View.OnClickListener {

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

        front_btn.setOnClickListener(this);
        behind_btn.setOnClickListener(this);

        return pain;
    }

    @Override
    public void onClick(View view) {


    }


}
