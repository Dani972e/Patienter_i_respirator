package com.respirator.i.patienter.patienter_i_respirator.settings.fragments;


import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoundFragment extends Fragment implements View.OnClickListener {

    private Button sound_up, sound_down;

    public RadioButton sound1_btn, sound2_btn;

    public TextView volumeTxt, callTxt;

    public AudioManager audioManager;

    private RadioGroup soundsG;

    int checked;

    private void SmallFontSize() {
        volumeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        sound1_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        sound2_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        sound_up.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        sound_down.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
    }

    private void MediumFontSize() {
        volumeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        sound1_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        sound2_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        sound_up.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
        sound_down.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
    }

    private void LargeFontSize() {
        volumeTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        callTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        sound1_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        sound2_btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        sound_up.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        sound_down.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View sound = inflater.inflate(R.layout.sound_fragment, container, false);

        SharedPreferences soundSettings = getContext().getSharedPreferences("soundChoice", 0);
        final SharedPreferences.Editor editor = soundSettings.edit();

        SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);

        volumeTxt = sound.findViewById(R.id.volume_view);
        callTxt = sound.findViewById(R.id.callsound_view);
        soundsG = sound.findViewById(R.id.soundsG);
        sound1_btn = sound.findViewById(R.id.callsound_btn);
        sound2_btn = sound.findViewById(R.id.callsound2_btn);
        sound_up = sound.findViewById(R.id.sound_up);
        sound_down = sound.findViewById(R.id.sound_down);
        sound_up.setOnClickListener(this);
        sound_down.setOnClickListener(this);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final MediaPlayer help_sound = MediaPlayer.create(getContext(), R.raw.sound1);
        final MediaPlayer help_sound2 = MediaPlayer.create(getContext(), R.raw.sound2);

        if (soundSettings.getBoolean("1",true)) {
            sound1_btn.setChecked(true);
        }
        else {
            sound2_btn.setChecked(true);
        }

        if (fontsizePref.getInt("fontsizePref",fontsize) == 0) {
            SmallFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 1) {
            MediumFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 2) {
            LargeFontSize();
        }

        soundsG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                checked = soundsG.indexOfChild(radioGroup.findViewById(checkedId));
                switch (checked) {
                    case 0:
                        editor.putBoolean("1",true).apply();
                        help_sound.start();
                        break;
                    case 1:
                        editor.putBoolean("1",false).apply();
                        help_sound2.start();
                        break;
                    default:
                        break;
                }
            }
        });
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
