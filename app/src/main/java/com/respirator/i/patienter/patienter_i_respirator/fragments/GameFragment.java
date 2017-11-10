package com.respirator.i.patienter.patienter_i_respirator.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class GameFragment extends Fragment implements View.OnClickListener {

    private ImageView balloon_btn, memory_game_btn, ticTacToe_btn, puzzle_btn;
    private ViewGroup menu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        menu = (ViewGroup) inflater.inflate(R.layout.game_fragment, container, false);

        balloon_btn = menu.findViewById(R.id.balloon_btn);
        memory_game_btn = menu.findViewById(R.id.memoryGame_btn);
        ticTacToe_btn = menu.findViewById(R.id.ticTacToe_btn);
        puzzle_btn = menu.findViewById(R.id.puzzle_btn);


        balloon_btn.setOnClickListener(this);
        memory_game_btn.setOnClickListener(this);
        ticTacToe_btn.setOnClickListener(this);
        puzzle_btn.setOnClickListener(this);

        return menu;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


        }
    }
}
