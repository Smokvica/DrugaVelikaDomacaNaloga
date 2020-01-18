package com.company.meniji;

import com.company.GridListener;
import com.company.Konstante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeniMedIgro extends JMenuBar {

    JButton nazajMedIgro = new JButton("Nazaj");
    JButton shrani = new JButton("Shrani"); //Todo action listener

    CardLayout cardLayout;
    JPanel kartice;
    JFrame okno;


    String nazajNaMeni; // da lahko prilagodim AL za gumb nazaj - da gre ali na MeniTezavnost ali na MeniMojSvet

    public MeniMedIgro(CardLayout cardLayout, JPanel kartice, JFrame okno, String nazajNaMeni) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        this.okno = okno;
        this.nazajNaMeni = nazajNaMeni;
        ustvariMeniMedIgro();
    }

    public void ustvariMeniMedIgro() {

        add(nazajMedIgro);
        add(shrani);

        if(nazajNaMeni.equals(Konstante.MENI_MOJ_SVET)) {
            ActionListener nazaj = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    okno.setJMenuBar(null);
                    cardLayout.show(kartice, Konstante.MENI_MOJ_SVET);
                }
            };
            nazajMedIgro.addActionListener(nazaj);
        }

        if(nazajNaMeni.equals(Konstante.MENI_TEZAVNOST)) {
            ActionListener nazaj = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    okno.setJMenuBar(null);
                    cardLayout.show(kartice, Konstante.MENI_TEZAVNOST);
                }
            };
            nazajMedIgro.addActionListener(nazaj);
        }
    }

    public void shrani() { //TODO

    }

}
