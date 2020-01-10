package com.company;

import com.company.meniji.ZacetniMeni;

import javax.swing.*;

public class Aplikacija {

    JFrame okno = new JFrame();


    ZacetniMeni zacetniMeni = new ZacetniMeni();

    //Meni izbira težavnosti
    JPanel tezavnostMeni = new JPanel();
    JTextArea zgodbica = new JTextArea("To je moja zgodbica, ki je lahko dolga in mislim, da bo prikazana cela, tudi če bo v več vrsticah. Tralala, hopsasa, kje je moja zgodbica.");
    JLabel izberiTezavnost = new JLabel("Izberi težavnost:");
    JButton vas = new JButton("VAS");
    JButton drzava = new JButton("DRŽAVA");
    JButton planet = new JButton("PLANET ZEMLJA");
    JButton mojSvet = new JButton("MOJ SVET");
    JButton nazaj1 = new JButton("Nazaj");

    //Meni težavnost moj svet (po meri)
    JPanel mojSvetMeni = new JPanel();
    JLabel tvojSvet = new JLabel("Kakšen je tvoj svet?");
    //višina, širina, št različnih pridelkov --> textfield?
    JButton nazaj2 = new JButton("Nazaj");

    //Meni vrstica zgoraj med igro
    JPanel meniMedIgro = new JPanel();
    JButton nazaj3 = new JButton("Nazaj");
    JButton shrani = new JButton("Shrani");



    public void zazeni() {

        //kakšno je okno
        okno.setTitle("Zajčja prevlada!");
        okno.setSize(1000, 800);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //začetni meni

        okno.add(zacetniMeni);

        okno.setVisible(true);


    }
}
