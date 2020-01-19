package com.company;

import com.company.meniji.MeniMedIgro;
import com.company.meniji.MeniMojSvet;
import com.company.meniji.MeniTezavnost;
import com.company.meniji.MeniZacetni;

import javax.swing.*;
import java.awt.*;

public class Aplikacija {

    JFrame okno = new JFrame();
    JPanel kartice = new JPanel(); //panel, na katerega lepim ostale panels ("cards"), npr. meniji
    CardLayout cardLayout = new CardLayout(); //posebej


    MeniZacetni meniZacetni = new MeniZacetni(cardLayout, kartice);
    MeniMojSvet meniMojSvet = new MeniMojSvet(cardLayout, kartice, okno);
    MeniTezavnost meniTezavnost = new MeniTezavnost(cardLayout, kartice, okno);


    public void zazeni() {

        //Lastnosti okna
        okno.setTitle("Zajčja prevlada!");
        okno.setSize(1000, 800);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Dodam panele na panel kartice
        kartice.setLayout(cardLayout);
        kartice.add(meniZacetni, Konstante.MENI_ZACETNI);
        kartice.add(meniTezavnost, Konstante.MENI_TEZAVNOST);
        kartice.add(meniMojSvet, Konstante.MENI_MOJ_SVET);

        okno.add(kartice);

        okno.setVisible(true);
    }
}
