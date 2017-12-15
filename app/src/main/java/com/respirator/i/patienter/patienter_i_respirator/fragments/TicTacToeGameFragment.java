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
public class TicTacToeGameFragment extends Fragment {


    public TicTacToeGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tic_tac_toe_game_fragment, container, false);
    }

}
