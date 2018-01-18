package com.respirator.i.patienter.patienter_i_respirator.game.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;
import com.respirator.i.patienter.patienter_i_respirator.game.quizQuestions.QuizQuestions;

/**
 * A simple {@link Fragment} subclass.
 *
 * Made with great inspiration from the following source:
 * https://www.youtube.com/watch?v=4g1_UH_6VQc&t=1s
 */
public class QuizFragment extends Fragment implements View.OnClickListener {

    private Button svar1, svar2, svar3, svar4, Nulstil;
    private TextView spørgsmål, info;

    private QuizQuestions sp = new QuizQuestions();
    private String rigtigesvar;
    private int spørgsmålnr = 0;

    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View quiz = inflater.inflate(R.layout.quiz_fragment, container, false);
        svar1 = quiz.findViewById(R.id.svar1);

        svar2 = quiz.findViewById(R.id.svar2);

        svar3 = quiz.findViewById(R.id.svar3);

        svar4 = quiz.findViewById(R.id.svar4);

        Nulstil = quiz.findViewById(R.id.ResetQuiz);
        Nulstil.setOnClickListener(this);

        spørgsmål = quiz.findViewById(R.id.spørgsmål);


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
        if (view == Nulstil)
            spørgsmålnr = 0;
            Nulstil.setVisibility(View.GONE);
        svar1.setVisibility(View.VISIBLE);
        svar2.setVisibility(View.VISIBLE);
        svar3.setVisibility(View.VISIBLE);
        svar4.setVisibility(View.VISIBLE);
        spørgsmål.setText(sp.getminespørgsmål(spørgsmålnr));





    }

    public void opdaterSpørgsmål() {
        Nulstil.setVisibility(View.GONE);
        spørgsmål.setText(sp.getminespørgsmål(spørgsmålnr));
        svar1.setText(sp.getsvar1(spørgsmålnr));
        svar2.setText(sp.getsvar2(spørgsmålnr));
        svar3.setText(sp.getsvar3(spørgsmålnr));
        svar4.setText(sp.getsvar4(spørgsmålnr));
        rigtigesvar = sp.getkorrektsvar(spørgsmålnr);
        spørgsmålnr++;
        if (spørgsmålnr > 7){
            Nulstil.setVisibility(View.VISIBLE);
            svar1.setVisibility(View.GONE);
            svar2.setVisibility(View.GONE);
            svar3.setVisibility(View.GONE);
            svar4.setVisibility(View.GONE);
            spørgsmål.setText(R.string.guessTrue);
        }

    }

    private void spilSlut() {
        spørgsmål.setText(R.string.guessWrong);
        svar1.setVisibility(View.GONE);
        svar2.setVisibility(View.GONE);
        svar3.setVisibility(View.GONE);
        svar4.setVisibility(View.GONE);
        Nulstil.setVisibility(View.VISIBLE);
    }
}
