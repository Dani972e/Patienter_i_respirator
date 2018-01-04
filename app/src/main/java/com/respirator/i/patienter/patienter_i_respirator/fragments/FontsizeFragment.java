package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class FontsizeFragment extends Fragment implements View.OnClickListener {

    private ImageView home_btn = getActivity().findViewById(R.id.home_btn);

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
