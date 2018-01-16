package com.respirator.i.patienter.patienter_i_respirator.fragments;

/**
 * Created by Thomas on 13-01-2018.
 */

public class QuizQuestions {

    public String[] minespørgsmål = {"Hvor mange mennesker bor i Danmark?", "Hvad er Danmarks hovedstad?", "Hvilket land grænser op til det sydlige Danmark?",
            "Hvad hedder det danske flag?", "Hvad er 10 gange 5?", "Hvilket sprog taler de i Australien?",
            "Hvad er Danmarks største ø?", "Hvilket dyr nedstammer hunde fra?"};

    private String minesvar[][] = {
            {"ca. 2 millioner", "ca. 5.5 millioner", "ca. 10 millioner", "ca. 7.5 millioner"}, {"Odense", "Århus", "København", "Esbjerg"},
            {"Tyskland", "Norge", "Sverige", "Polen"},
            {"Højbrog", "Dronningebrog", "Dannebrog", "Nørrebrog"}, {"25", "50", "500", "150"}, {"Fransk", "Engelsk", "Australsk", "Spansk"},
            {"Sjælland", "Fyn", "Bornholm", "Langeland"}, {"Hyæner", "Bjørne", "Løver", "Ulve"}
    };

    public String korrektesvar[] = {"ca. 5.5 millioner", "København", "Tyskland", "Dannebrog", "50", "Engelsk", "Sjælland", "Ulve"};

    public String getminespørgsmål(int a){
        String spørgsmål = minespørgsmål[a];
        return spørgsmål;
    }

    public String getsvar1(int a){
        String valg = minesvar[a][0];
        return valg;
    }

    public String getsvar2(int a){
        String valg = minesvar[a][1];
        return valg;
    }

    public String getsvar3(int a){

        String valg = minesvar[a][2];
        return valg;
    }

    public String getsvar4(int a){
        String valg = minesvar[a][3];
        return valg;
    }

    public String getkorrektsvar(int a){
        String svar = korrektesvar[a];
        return svar;
    }





    }


