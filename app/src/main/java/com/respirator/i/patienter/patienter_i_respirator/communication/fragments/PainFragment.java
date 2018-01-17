package com.respirator.i.patienter.patienter_i_respirator.communication.fragments;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;

import static com.respirator.i.patienter.patienter_i_respirator.settings.fragments.FontsizeFragment.fontsize;


public class PainFragment extends Fragment implements View.OnClickListener {


    private final int front_btn_amount = 17;
    private final Button[] frontBtnArray = new Button[front_btn_amount];
    private final int[] frontBtnId = {R.id.rightUpperArmShoulder, R.id.rightLowerArm, R.id.rightHand, R.id.leftHand, R.id.leftLowerArm, R.id.leftUpperArmShoulder, R.id.stomach, R.id.chest,
            R.id.throat, R.id.head, R.id.abdomen, R.id.rightUpperLeg, R.id.rightLowerLeg, R.id.rightLeg, R.id.leftLeg, R.id.leftLowerLeg, R.id.leftUpperLeg};


    private final int back_Btn_Amount = 17;
    private final Button[] backBtnArray = new Button[back_Btn_Amount];
    private final int[] backBtnId = {R.id.backhead, R.id.neck, R.id.backUpperBack, R.id.lowerBack, R.id.buttocks, R.id.backLeftUpperLeg, R.id.backRightUpperLeg, R.id.backRightLowerLeg, R.id.backLeftLowerLeg, R.id.backLeftFoot, R.id.backRightFoot, R.id.backLeftUpperArmShoulder, R.id.backLeftLowerArm,
            R.id.backLeftHand, R.id.backRigtUpperArmShoulder, R.id.backRightLowerArm, R.id.backRightHand};


    private final int button_amount = 5;
    private final Button[] buttonArray = new Button[button_amount];
    private final int[] buttonId = {R.id.burning, R.id.stinging, R.id.stabbing, R.id.pounding, R.id.pressuring};

    private ImageView front_btn, behind_btn;

    public Button burnTxt, stabTtx, stingTxt, pressuringTxt, poundingTxt;

    public TextView painTxt;

    public PainFragment() {
        // Required empty public constructor
    }

    private void SmallFontSize() {
        burnTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        stingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        stabTtx.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        pressuringTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        painTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        poundingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
    }

    private void MediumFontSize() {
        burnTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        stingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        stabTtx.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        pressuringTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        painTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        poundingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
    }

    private void LargeFontSize() {
        burnTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        stingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        stabTtx.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        pressuringTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        painTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        poundingTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View pain = inflater.inflate(R.layout.pain_fragment, container, false);

        SharedPreferences fontsizePref = getContext().getSharedPreferences("fontsizePref",0);

        burnTxt = pain.findViewById(R.id.burning);
        stabTtx = pain.findViewById(R.id.stabbing);
        stingTxt = pain.findViewById(R.id.stinging);
        pressuringTxt = pain.findViewById(R.id.pressuring);
        poundingTxt = pain.findViewById(R.id.pounding);
        painTxt = pain.findViewById(R.id.pain_view);
        front_btn = pain.findViewById(R.id.front_btn);
        behind_btn = pain.findViewById(R.id.behind_btn);
        front_btn.setOnClickListener(this);
        behind_btn.setOnClickListener(this);


        for (int i = 0; i < frontBtnId.length; i++) {
            frontBtnArray[i] = pain.findViewById(frontBtnId[i]);
            frontBtnArray[i].setOnClickListener(this);
        }

        for (int i = 0; i < backBtnId.length; i++) {
            backBtnArray[i] = pain.findViewById(backBtnId[i]);
            backBtnArray[i].setOnClickListener(this);
        }


        for (int i = 0; i < buttonId.length; i++) {
            buttonArray[i] = pain.findViewById(buttonId[i]);
            buttonArray[i].setOnClickListener(this);
            buttonArray[i].setVisibility(View.INVISIBLE);
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

        return pain;
    }


    @Override
    public void onClick(View view) {
        showButtons();

        switch (view.getId()) {
            case R.id.rightUpperArmShoulder:
                front_btn.setImageResource(R.drawable.right_upper_arm_shoulder);
                break;
            case R.id.rightLowerArm:
                front_btn.setImageResource(R.drawable.right_lower_arm);
                break;
            case R.id.rightHand:
                front_btn.setImageResource(R.drawable.righthand);
                break;
            case R.id.leftHand:
                front_btn.setImageResource(R.drawable.lefthand);
                break;
            case R.id.leftLowerArm:
                front_btn.setImageResource(R.drawable.left_lower_arm);
                break;
            case R.id.leftUpperArmShoulder:
                front_btn.setImageResource(R.drawable.left_upper_arm_shoulder);
                break;
            case R.id.stomach:
                front_btn.setImageResource(R.drawable.stomach);
                break;
            case R.id.chest:
                front_btn.setImageResource(R.drawable.chest);
                break;
            case R.id.throat:
                front_btn.setImageResource(R.drawable.throat);
                break;
            case R.id.head:
                front_btn.setImageResource(R.drawable.head);
                break;
            case R.id.abdomen:
                front_btn.setImageResource(R.drawable.abdomen);
                break;
            case R.id.rightUpperLeg:
                front_btn.setImageResource(R.drawable.right_upper_leg);
                break;
            case R.id.rightLowerLeg:
                front_btn.setImageResource(R.drawable.right_lower_leg);
                break;
            case R.id.rightLeg:
                front_btn.setImageResource(R.drawable.rightleg);
                break;
            case R.id.leftLeg:
                front_btn.setImageResource(R.drawable.leftleg);
                break;
            case R.id.leftLowerLeg:
                front_btn.setImageResource(R.drawable.left_lower_leg);
                break;
            case R.id.leftUpperLeg:
                front_btn.setImageResource(R.drawable.left_upper_leg);
                break;
        }


        switch (view.getId()) {

            case R.id.backhead:
                behind_btn.setImageResource(R.drawable.backhead);
                break;
            case R.id.neck:
                behind_btn.setImageResource(R.drawable.neck);
                break;
            case R.id.backUpperBack:
                behind_btn.setImageResource(R.drawable.back_upper_back);
                break;
            case R.id.lowerBack:
                behind_btn.setImageResource(R.drawable.lower_back);
                break;
            case R.id.buttocks:
                behind_btn.setImageResource(R.drawable.buttocks);
                break;
            case R.id.backLeftUpperLeg:
                behind_btn.setImageResource(R.drawable.back_left_upper_leg);
                break;
            case R.id.backRightUpperLeg:
                behind_btn.setImageResource(R.drawable.back_right_upper_leg);
                break;
            case R.id.backRightLowerLeg:
                behind_btn.setImageResource(R.drawable.back_right_lower_leg);
                break;
            case R.id.backLeftLowerLeg:
                behind_btn.setImageResource(R.drawable.back_left_lower_leg);
                break;
            case R.id.backRightFoot:
                behind_btn.setImageResource(R.drawable.back_right_foot);
                break;
            case R.id.backLeftFoot:
                behind_btn.setImageResource(R.drawable.back_left_foot);
                break;
            case R.id.backLeftUpperArmShoulder:
                behind_btn.setImageResource(R.drawable.back_left_upper_arm_shoulder);
                break;
            case R.id.backLeftLowerArm:
                behind_btn.setImageResource(R.drawable.back_left_lower_arm);
                break;
            case R.id.backLeftHand:
                behind_btn.setImageResource(R.drawable.back_left_hand);
                break;
            case R.id.backRigtUpperArmShoulder:
                behind_btn.setImageResource(R.drawable.back_right_upper_arm_shoulder);
                break;
            case R.id.backRightLowerArm:
                behind_btn.setImageResource(R.drawable.back_right_lower_arm);
                break;
            case R.id.backRightHand:
                behind_btn.setImageResource(R.drawable.back_right_hand);
                break;
        }

        for (Button btn : buttonArray) {
            if (btn.equals(view)) {
                btn.setBackgroundResource(R.drawable.button_rounded_darkblue);
            } else {
                btn.setBackgroundResource(R.drawable.button_rounded_blue);
            }

        }
    }

    public void showButtons() {
        for (int i = 0; i < buttonId.length; i++) {
            buttonArray[i].setVisibility(View.VISIBLE);
        }
    }
}




