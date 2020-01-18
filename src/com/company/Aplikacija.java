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

        //Zdruzi z meni tezavnost
//        //naredim panel z zgodbico
//        JPanel zgodbica = new JPanel();
//        JLabel zgodbicaBesedilo = new JLabel("<html>To je moja zgodbica, ki je lahko dolga in mislim, <br>da bo prikazana cela, tudi če bo v več vrsticah. Tralala, hopsasa, kje je moja zgodbica.</html>");
//        zgodbicaBesedilo.setFont(new Font("Calibri", Font.ITALIC, 25));
//        zgodbica.add(zgodbicaBesedilo);
//        //naredim panel z menijem težavnosti
//        MeniTezavnost meniTezavnost = new MeniTezavnost();
//        //dodam oba panela na okno
//        okno.add(zgodbica, BorderLayout.NORTH);
//        okno.add(meniTezavnost, BorderLayout.CENTER);
//        okno.setVisible(true);


        kartice.setLayout(cardLayout);

        kartice.add(meniZacetni, Konstante.MENI_ZACETNI);
        kartice.add(meniTezavnost, Konstante.MENI_TEZAVNOST);
        kartice.add(meniMojSvet, Konstante.MENI_MOJ_SVET);


        okno.add(kartice);

        okno.setVisible(true);

    }


}
