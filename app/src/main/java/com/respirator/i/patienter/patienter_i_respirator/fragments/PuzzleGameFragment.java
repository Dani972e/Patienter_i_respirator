package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
import com.respirator.i.patienter.patienter_i_respirator.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */


public class PuzzleGameFragment extends Fragment implements View.OnClickListener {

    private static final int antalknapper  = 9;
    private final ImageView[] btnArray = new ImageView[antalknapper];
    private final int[] btnId = {R.billede, R.id.balloon_2, R.id.balloon_3, R.id.balloon_4, R.id.balloon_5};
    public PuzzleGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.puzzle_game_fragment, container, false);

    }

    private void begin(){
        btnArray = new String[antalknapper];
        for (int i = 0; i < btnArray.length; i++){
            btnArray[i] = String.valueOf(i);
        }
    }

    private void showimages(){
        ArrayList<Button> buttons = new ArrayList<>();
        Button btn;
        for (int i = 0; i < tilelist.length; i++){
            btn = new Button();

            if (tilelist[i].equals("0"))
               btn.setBackgroundResource(R.drawable.image_part_001);
            else if (tilelist[i].equals("1"))
                btn.setBackgroundResource(R.drawable.image_part_002);
            else if (tilelist[i].equals("2"))
                btn.setBackgroundResource(R.drawable.image_part_003);
            else if (tilelist[i].equals("3"))
                btn.setBackgroundResource(R.drawable.image_part_004);
            else if (tilelist[i].equals("4"))
                btn.setBackgroundResource(R.drawable.image_part_005);
            else if (tilelist[i].equals("5"))
                btn.setBackgroundResource(R.drawable.image_part_006);
            else if (tilelist[i].equals("6"))
                btn.setBackgroundResource(R.drawable.image_part_007);
            else if (tilelist[i].equals("7"))
                btn.setBackgroundResource(R.drawable.image_part_008);
            else if (tilelist[i].equals("8"))
                btn.setBackgroundResource(R.drawable.image_part_009);
    }

}

    @Override
    public void onClick(View view) {

    }
}


