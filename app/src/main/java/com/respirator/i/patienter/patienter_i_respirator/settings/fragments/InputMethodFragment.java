package com.respirator.i.patienter.patienter_i_respirator.settings.fragments;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.respirator.i.patienter.patienter_i_respirator.R;

import org.w3c.dom.Text;

import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.fontsize;
import static com.respirator.i.patienter.patienter_i_respirator.main.MainActivity.lang;


public class InputMethodFragment extends Fragment {

    public RadioGroup inputG;

    public RadioButton touch, headTouch;

    public TextView inputTxt;

    public int checked;

    public InputMethodFragment() {
        // Required empty public constructor
    }

    private void SmallFontSize() {
        touch.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        headTouch.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        inputTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);    }

    private void MediumFontSize() {
        touch.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        headTouch.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        inputTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
    }

    private void LargeFontSize() {
        touch.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        headTouch.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        inputTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View input = inflater.inflate(R.layout.input_method_fragment, container, false);

        SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);

        inputTxt = input.findViewById(R.id.inputMethod_view);
        inputG = input.findViewById(R.id.inputG);
        touch = input.findViewById(R.id.touch_btn);
        headTouch = input.findViewById(R.id.facialControl_btn);

        if (fontsizePref.getInt("fontsizePref",fontsize) == 0) {
            SmallFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 1) {
            MediumFontSize();
        }
        else if (fontsizePref.getInt("fontsizePref",fontsize) == 2) {
            LargeFontSize();
        }

        inputG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                checked = inputG.indexOfChild(radioGroup.findViewById(checkedId));
                switch (checked) {
                    case 0:
                        break;
                    case 1:
                        touch.setChecked(true);
                        headTouch.setChecked(false);
                        Toast.makeText(getContext(),R.string.inputToast,Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        return input;
    }



}
