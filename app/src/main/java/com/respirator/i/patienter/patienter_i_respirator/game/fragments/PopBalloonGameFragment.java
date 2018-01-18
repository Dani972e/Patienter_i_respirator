package com.respirator.i.patienter.patienter_i_respirator.game.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;

import java.util.Random;


public class PopBalloonGameFragment extends Fragment implements View.OnClickListener {

    private final int btn_amount = 5;
    private final ImageView[] btnArray = new ImageView[btn_amount];
    private final int[] btnId = {R.id.balloon_1, R.id.balloon_2, R.id.balloon_3, R.id.balloon_4, R.id.balloon_5};
    private int counter = 0;
    private TextView gameText_view;

    Random random = new Random();

    public PopBalloonGameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View balloon = inflater.inflate(R.layout.pop_balloon_game_fragment, container, false);

        gameText_view = getActivity().findViewById(R.id.gameText_view);

        for (int i = 0; i < btnId.length; i++) {
            btnArray[i] = balloon.findViewById(btnId[i]);
            btnArray[i].setOnClickListener(this);

        }

        return balloon;
    }

    @Override
    public void onClick(View view) {
        for (ImageView btn : btnArray) {
            if (btn.equals(view)) {
                btn.setImageResource(R.drawable.ic_explosion);
                counter++;
                if (counter == 5) {
                    gameText_view.setText(R.string.poppetBalloner);

                }


            }


        }

    }
}
