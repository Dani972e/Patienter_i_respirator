package com.respirator.i.patienter.patienter_i_respirator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by Johnny on 05/11/17.
 */

public class Menu_Frag extends Fragment implements View.OnClickListener {

    ImageView game_btn;
    ImageView communication_btn;
    ImageView settings_btn;

    ViewGroup menu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        menu = (ViewGroup) inflater.inflate(R.layout.menu_frag, container,false);

        game_btn = menu.findViewById(R.id.game_btn);
        game_btn.setOnClickListener(this);

        communication_btn = menu.findViewById(R.id.communication_btn);
        communication_btn.setOnClickListener(this);

        settings_btn = menu.findViewById(R.id.settings_btn);
        settings_btn.setOnClickListener(this);

        return menu;
    }

    @Override
    public void onClick(View v) {
        if (v == game_btn) {
            getFragmentManager().beginTransaction().setCustomAnimations(R.anim.pop_in, R.anim.pop_in, R.anim.pop_in, R.anim.pop_in)
                    .replace(R.id.fragment_container, new Game_Frag())
                    .addToBackStack(null)
                    .commit();
        }

    }
}
