package com.respirator.i.patienter.patienter_i_respirator.game.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.respirator.i.patienter.patienter_i_respirator.R;

import java.util.Arrays;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemoryGameFragment extends Fragment //implements View.OnClickListener {

{


    private ImageView ImageView1, ImageView2, ImageView3, ImageView4, ImageView5, ImageView6;
    private TextView gameText_view, GætToEns;

    //array til billeder
    private Integer[] billedeArray = {101, 102, 103, 201, 202, 203};

    //billeder
    private int billede11, billede12, billede13, billede21, billede22, billede23;

    private int førsteBillede, andetBillede;
    private int førsteKlik, andetKlik;
    private int billedeNummer = 1;


    public MemoryGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View memory = inflater.inflate(R.layout.memory_game_fragment, container, false);

        gameText_view = getActivity().findViewById(R.id.gameText_view);
        GætToEns = memory.findViewById(R.id.GætToEns);

        ImageView1 = memory.findViewById(R.id.ImageView1);
        ImageView2 = memory.findViewById(R.id.ImageView2);
        ImageView3 = memory.findViewById(R.id.ImageView3);
        ImageView4 = memory.findViewById(R.id.ImageView4);
        ImageView5 = memory.findViewById(R.id.ImageView5);
        ImageView6 = memory.findViewById(R.id.ImageView6);


        ImageView1.setTag("0");
        ImageView2.setTag("1");
        ImageView3.setTag("2");
        ImageView4.setTag("3");
        ImageView5.setTag("4");
        ImageView6.setTag("5");


        indlæsBilleder();

        Collections.shuffle(Arrays.asList(billedeArray));


        ImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int billedet = Integer.parseInt((String) view.getTag());
                huskeLogik(ImageView1, billedet);
            }
        });

        ImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int billedet = Integer.parseInt((String) view.getTag());
                huskeLogik(ImageView2, billedet);
            }
        });

        ImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int billedet = Integer.parseInt((String) view.getTag());
                huskeLogik(ImageView3, billedet);
            }
        });

        ImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int billedet = Integer.parseInt((String) view.getTag());
                huskeLogik(ImageView4, billedet);
            }
        });

        ImageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int billedet = Integer.parseInt((String) view.getTag());
                huskeLogik(ImageView5, billedet);
            }
        });

        ImageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int billedet = Integer.parseInt((String) view.getTag());
                huskeLogik(ImageView6, billedet);
            }
        });


        return memory;
    }

    private void huskeLogik(ImageView ImageView, int billede) {
        // vedhæfter billederne til imageviews
        if (billedeArray[billede] == 101) {
            ImageView.setImageResource(R.mipmap.memory_earth);

        } else if (billedeArray[billede] == 102) {
            ImageView.setImageResource(R.mipmap.memory_sun);

        } else if (billedeArray[billede] == 103) {
            ImageView.setImageResource(R.mipmap.memory_venus);

        } else if (billedeArray[billede] == 201) {
            ImageView.setImageResource(R.mipmap.memory_earth);

        } else if (billedeArray[billede] == 202) {
            ImageView.setImageResource(R.mipmap.memory_sun);

        } else if (billedeArray[billede] == 203) {
            ImageView.setImageResource(R.mipmap.memory_venus);
        }


        //tjekker hvilket billede, der er trykket på og gemmer det som en temporær variabel.
        if (billedeNummer == 1) {
            førsteBillede = billedeArray[billede];
            if (førsteBillede > 200) {
                førsteBillede = førsteBillede - 100;
            }
            billedeNummer = 2;
            førsteKlik = billede;

            ImageView.setEnabled(false);

        } else if (billedeNummer == 2) {
            andetBillede = billedeArray[billede];
            if (andetBillede > 200) {
                andetBillede = andetBillede - 100;
            }
            billedeNummer = 1;
            andetKlik = billede;

            ImageView1.setEnabled(false);
            ImageView2.setEnabled(false);
            ImageView3.setEnabled(false);
            ImageView4.setEnabled(false);
            ImageView5.setEnabled(false);
            ImageView6.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    //Tjekker om de valgte billeder er éns
                    calculate();
                }
            }, 1000);

        }


    }

    private void calculate() {
        //Hvis de to billeder, der er trykket på er éns fjernes de fra

        if (førsteBillede == andetBillede) {
            if (førsteKlik == 0) {
                ImageView1.setVisibility(View.INVISIBLE);

            } else if (førsteKlik == 1) {
                ImageView2.setVisibility(View.INVISIBLE);

            } else if (førsteKlik == 2) {
                ImageView3.setVisibility(View.INVISIBLE);

            } else if (førsteKlik == 3) {
                ImageView4.setVisibility(View.INVISIBLE);

            } else if (førsteKlik == 4) {
                ImageView5.setVisibility(View.INVISIBLE);

            } else if (førsteKlik == 5) {
                ImageView6.setVisibility(View.INVISIBLE);
            }

            if (andetKlik == 0) {
                ImageView1.setVisibility(View.INVISIBLE);

            } else if (andetKlik == 1) {
                ImageView2.setVisibility(View.INVISIBLE);

            } else if (andetKlik == 2) {
                ImageView3.setVisibility(View.INVISIBLE);

            } else if (andetKlik == 3) {
                ImageView4.setVisibility(View.INVISIBLE);

            } else if (andetKlik == 4) {
                ImageView5.setVisibility(View.INVISIBLE);

            } else if (andetKlik == 5) {
                ImageView6.setVisibility(View.INVISIBLE);
            }
        } else {
            ImageView1.setImageResource(R.drawable.button_rounded_turquoise);
            ImageView2.setImageResource(R.drawable.button_rounded_turquoise);
            ImageView3.setImageResource(R.drawable.button_rounded_turquoise);
            ImageView4.setImageResource(R.drawable.button_rounded_turquoise);
            ImageView5.setImageResource(R.drawable.button_rounded_turquoise);
            ImageView6.setImageResource(R.drawable.button_rounded_turquoise);
        }

        ImageView1.setEnabled(true);
        ImageView2.setEnabled(true);
        ImageView3.setEnabled(true);
        ImageView4.setEnabled(true);
        ImageView5.setEnabled(true);
        ImageView6.setEnabled(true);

        spilVundet();

    }


    private void indlæsBilleder() {

        billede11 = R.mipmap.memory_earth;
        billede12 = R.mipmap.memory_sun;
        billede13 = R.mipmap.memory_venus;
        billede21 = R.mipmap.memory_earth;
        billede22 = R.mipmap.memory_sun;
        billede23 = R.mipmap.memory_venus;

    }

    private void spilVundet() {

        if (ImageView1.getVisibility() == View.INVISIBLE &&
                ImageView2.getVisibility() == View.INVISIBLE &&
                ImageView3.getVisibility() == View.INVISIBLE &&
                ImageView4.getVisibility() == View.INVISIBLE &&
                ImageView5.getVisibility() == View.INVISIBLE &&
                ImageView6.getVisibility() == View.INVISIBLE) {


            gameText_view.setText(R.string.spilVundet);
            GætToEns.setText(R.string.spilIgen);
        }
    }




}
