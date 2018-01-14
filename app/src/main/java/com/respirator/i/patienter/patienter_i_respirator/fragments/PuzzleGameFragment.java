package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.util.Log;


import com.respirator.i.patienter.patienter_i_respirator.R;

/*
 * A simple {@link Fragment} subclass.
 */


public class PuzzleGameFragment extends Fragment implements View.OnClickListener {
    ImageButton b1, b2, b3, b4;
    Button switch1, switch2;
    View v;
    boolean buttons1AreVisible = true;

    public PuzzleGameFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View game = inflater.inflate(R.layout.puzzle_game_fragment, container, false);
        b1 = game.findViewById(R.id.Danmark1);
        b1.setOnClickListener(this);

        b2 = game.findViewById(R.id.Dannark2);
        b2.setOnClickListener(this);

        b3 = game.findViewById(R.id.Danmark3);
        b3.setOnClickListener(this);

        b4 =  game.findViewById(R.id.imageButton6);
        b4.setOnClickListener(this);

        switch1 = game.findViewById(R.id.exchange1);
        switch1.setOnClickListener(this);

        switch2 = game.findViewById(R.id.exchange2);
        switch2.setOnClickListener(this);



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.puzzle_game_fragment, container, false);

    }

    private void skiftpositioner(ImageButton b1, ImageButton b2){
        if (buttons1AreVisible) {
            this.b1.setVisibility(View.GONE);
            this.b2.setVisibility(View.GONE);

        } else {
            this.b1.setVisibility(View.VISIBLE);
            this.b2.setVisibility(View.VISIBLE);
        }

        buttons1AreVisible = !buttons1AreVisible;
    }


    @Override
    public void onClick(View view) {
        if (v == switch1) {
            skiftpositioner(b1, b2);

        }

    }}

