package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;


public class TicTacToeGameFragment extends Fragment implements View.OnClickListener {

    private Button[][] playButtons = new Button[3][3];
    private boolean patientTurn = true;

    //counts the round of the game
    private int roundCount;

    private int patientPoint;
    private int nursePoint;

    private TextView patient_view, nurse_view;


    public TicTacToeGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View game = inflater.inflate(R.layout.tic_tac_toe_game_fragment, container, false);

        patient_view = game.findViewById(R.id.patient_view);
        nurse_view = game.findViewById(R.id.nurse_view);


        /*with this nested loop we will loop through our rows and columns
        * This is the resID i use to pass to find viewById.
        * in this case we create it dynamically with this nested loop instead of
        * designing them one by one.
        */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "btn_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getActivity().getPackageName());
                playButtons[i][j] = game.findViewById(resID);
                playButtons[i][j].setOnClickListener(this);
            }
        }

        Button reset_btn = game.findViewById(R.id.reset_btn);
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });


        return game;


    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }

        if (patientTurn) {
            ((Button) view).setText(R.string.kryds);
        } else {
            ((Button) view).setText(R.string.bolle);
        }

        roundCount++;

        if (finishGame()) {
            if (patientTurn) {
                patientWin();
            } else {
                nurseWin();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            patientTurn = !patientTurn;
        }

    }

    private boolean finishGame() {
        String[][] fields = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fields[i][j] = playButtons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (fields[i][0].equals(fields[i][1])
                    && fields[i][0].equals(fields[i][2])
                    && !fields[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (fields[0][i].equals(fields[0][i])
                    && fields[0][i].equals(fields[2][i])
                    && !fields[0][i].equals("")) {
                return true;
            }
        }

        if (fields[0][0].equals(fields[1][1])
                && fields[0][0].equals(fields[2][2])
                && !fields[0][0].equals("")) {
            return true;
        }
        if (fields[0][2].equals(fields[1][1])
                && fields[0][2].equals(fields[2][0])
                && !fields[0][2].equals("")) {
            return true;
        }

        return false;
    }

    private void patientWin() {
        patientPoint++;
        updatePointsText();
        resetGameboard();
    }

    private void nurseWin() {
        nursePoint++;
        updatePointsText();
        resetGameboard();

    }

    private void draw() {
        resetGameboard();

    }

    private void updatePointsText() {
        patient_view.setText("Patienten: " + patientPoint);
        nurse_view.setText("Sygeplejersken: " + nursePoint);
    }

    private void resetGameboard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                playButtons[i][j].setText("");
            }
        }

        roundCount = 0;
        patientTurn = true;

    }

    private void resetGame() {
        patientPoint = 0;
        nursePoint = 0;
        updatePointsText();
        resetGameboard();
    }

    /*
    this method will be called if we rotate the device.
    It will save those values in the outState Bundle
    */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("patientPoint", patientPoint);
        outState.putInt("nursePoint", nursePoint);
        outState.putBoolean("patientTurn", patientTurn);

    }

    /*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        roundCount = savedInstanceState.getInt("roundCount");
        patientPoint = savedInstanceState.getInt("patientPoint");
        nursePoint = savedInstanceState.getInt("nursePoint");
        patientTurn = savedInstanceState.getBoolean("patientTurn");

   }
    */
}
