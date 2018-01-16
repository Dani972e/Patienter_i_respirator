package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment implements View.OnClickListener {

    Button svar1, svar2, svar3, svar4;
    TextView spørgsmål, info;

    private quizSpørgsmål sp = new quizSpørgsmål();
    private String rigtigesvar;
    private int spørgsmålnr = 0;
    private int score = 0;

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View quiz = inflater.inflate(R.layout.quizgamefragment, container, false);
        svar1 = quiz.findViewById(R.id.svar1);

        svar2 = quiz.findViewById(R.id.svar2);

        svar3 = quiz.findViewById(R.id.svar3);

        svar4 = quiz.findViewById(R.id.svar4);

        spørgsmål = quiz.findViewById(R.id.spørgsmål);
        info = quiz.findViewById(R.id.quizInfo);

        opdaterSpørgsmål();

        svar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (svar1.getText() == rigtigesvar)
                    opdaterSpørgsmål();
                else
                    spilSlut();
            }
        });

        svar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (svar2.getText() == rigtigesvar) {
                    opdaterSpørgsmål();
                }
                else
                    spilSlut();
            }
        });

        svar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (svar3.getText() == rigtigesvar)
                    opdaterSpørgsmål();
                else
                    spilSlut();
            }
        });

        svar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (svar4.getText() == rigtigesvar)
                    opdaterSpørgsmål();
                else
                    spilSlut();
            }
        });


        return quiz;


    }

    @Override
    public void onClick(View view) {


    }

    public void opdaterSpørgsmål() {
        spørgsmål.setText(sp.getminespørgsmål(spørgsmålnr));
        svar1.setText(sp.getsvar1(spørgsmålnr));
        svar2.setText(sp.getsvar2(spørgsmålnr));
        svar3.setText(sp.getsvar3(spørgsmålnr));
        svar4.setText(sp.getsvar4(spørgsmålnr));
        rigtigesvar = sp.getkorrektsvar(spørgsmålnr);
        spørgsmålnr++;
        if (spørgsmålnr > 7){
            info.setText("Du gættede rigtigt på dem alle :)");
            spørgsmålnr = 1;
            score = 0;
        }

    }

    private void spilSlut() {
        info.setText("Forkert svar! Prøv igen :)");
    }
}
