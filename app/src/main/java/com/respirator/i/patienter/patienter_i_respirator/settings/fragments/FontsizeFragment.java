package com.respirator.i.patienter.patienter_i_respirator.settings.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class FontsizeFragment extends Fragment implements View.OnClickListener {


    public FontsizeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View fontsize = inflater.inflate(R.layout.fontsize_fragment, container, false);

        return fontsize;
    }

    @Override
    public void onClick(View view) {

    }
}
