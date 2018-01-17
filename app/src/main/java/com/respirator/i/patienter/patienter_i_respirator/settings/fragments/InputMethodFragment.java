package com.respirator.i.patienter.patienter_i_respirator.settings.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class InputMethodFragment extends Fragment implements View.OnClickListener {

    private Button touch_btn, facialControl_btn;

    public InputMethodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.input_method_fragment, container, false);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
