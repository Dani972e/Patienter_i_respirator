package com.respirator.i.patienter.patienter_i_respirator.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class MenuFragment extends Fragment implements View.OnClickListener {

    private ImageView game_btn;
    private ImageView communication_btn;
    private ImageView settings_btn;
    private ViewGroup menu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        menu = (ViewGroup) inflater.inflate(R.layout.menu_fragment, container, false);

        game_btn = menu.findViewById(R.id.game_btn);
        communication_btn = menu.findViewById(R.id.communication_btn);
        settings_btn = menu.findViewById(R.id.settings_btn);

        game_btn.setOnClickListener(this);
        communication_btn.setOnClickListener(this);
        settings_btn.setOnClickListener(this);

        return menu;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.game_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new GameFragment()).addToBackStack(null).commit();
                break;
            case R.id.communication_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new CommFragment()).addToBackStack(null).commit();
                break;



        }

    }
}
