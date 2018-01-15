package com.respirator.i.patienter.patienter_i_respirator.fragments;

/**
 * Created by Thomas on 13-01-2018.
 */

public class quizSpørgsmål {

    public String[] minespørgsmål = {"Hvor mange mennesker bor i Danmark?", "Hvad er Danmarks hovedstad?", "Hvilket to lande grænser op til Danmark?",
            "Hvor mange stater er der i USA?", "Hvad er 10 gange 5?", "Hvilke planeter ligger tættere på Solen end Jorden?",
            "Hvor mange planeter er der i Solsystemet?", "Hvilket dyr nedstammer hunde fra?"};

    private String minesvar[][] = {
            {"ca. 2 millioner", "ca. 5.5 millioner", "ca. 10 millioner", "ca. 7.5 millioner"}, {"Odense, Århus, København, Esbjerg"},
            {"Tyskland og Sverige", "Norge og Finland", "Storbritanien og Sverige", "Tyskland og Norge"},
            {"17", "20", "50", "35"}, {"25", "50", "500", "150"}, {"Jupiter og Mars", "Merkur og Venus", "Venus og Saturn", "Merkur og Neptun"},
            {"8", "12", "5", "10"}, {"Hyæner", "Bjørne", "Ræve", "Ulve"}
    };

    public String korrektesvar[] = {"ca. 5.5 millioner", "København", "Tyskland og Sverige", "50", "Merkur og Venus", "8", "Ulve"};

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


