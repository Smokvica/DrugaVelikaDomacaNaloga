package com.company;

import com.company.meniji.MeniMedIgro;
import com.company.meniji.MeniMojSvet;
import com.company.meniji.MeniTezavnost;
import com.company.meniji.MeniZacetni;

import javax.swing.*;
import java.awt.*;

public class Aplikacija {

    JFrame okno = new JFrame();


    MeniZacetni meniZacetni = new MeniZacetni(okno);
    MeniMojSvet meniMojSvet = new MeniMojSvet();
    MeniMedIgro meniMedIgro = new MeniMedIgro();




    public void zazeni() {

        //Izgled okna
        okno.setTitle("Zajčja prevlada!");
        okno.setSize(1000, 800);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        //Meni z zgodbico in težavnostjo
//        JPanel zgodbica = new JPanel();
//        JLabel zgodbicaBesedilo = new JLabel("<html>To je moja zgodbica, ki je lahko dolga in mislim, <br>da bo prikazana cela, tudi če bo v več vrsticah. Tralala, hopsasa, kje je moja zgodbica.</html>");
//        zgodbicaBesedilo.setFont(new Font("Calibri", Font.ITALIC, 25));
//        zgodbica.add(zgodbicaBesedilo);


        okno.add(meniZacetni);

        okno.setVisible(true);


    }
}
