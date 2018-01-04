package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.respirator.i.patienter.patienter_i_respirator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoundFragment extends Fragment implements View.OnClickListener {

    private Button sound_up, sound_down;

    public AudioManager audioManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View sound = inflater.inflate(R.layout.sound_fragment, container, false);

        sound_up = sound.findViewById(R.id.sound_up);
        sound_down = sound.findViewById(R.id.sound_down);

        sound_up.setOnClickListener(this);
        sound_down.setOnClickListener(this);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        return sound;
    }

    @Override
    public void onClick(View view) {
        if (sound_up == view) {
            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
        }
        else if (sound_down == view) {
            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
        }
    }
}
