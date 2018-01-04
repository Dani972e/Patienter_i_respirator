package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemoryGameFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 4;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.imageMemory1, R.id.imageMemory2, R.id.imageMemory3, R.id.imageMemory4};


    public MemoryGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View memory = inflater.inflate(R.layout.memory_game_fragment, container, false);


        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = memory.findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);

        }

        return memory;
    }


    public void onClick(View v) {

        for (ImageView btn : btnArray) {
            if (btn.equals(v)) {
               // btn.setImageResource(R.mipmap.memory_image_moon);

            }
        }
    }

}
