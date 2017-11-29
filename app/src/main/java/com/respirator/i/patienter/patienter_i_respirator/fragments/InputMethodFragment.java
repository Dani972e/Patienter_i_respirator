package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.respirator.i.patienter.patienter_i_respirator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputMethodFragment extends Fragment {


    public InputMethodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.input_method_fragment, container, false);
    }

}
