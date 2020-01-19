package com.company.meniji;

import com.company.GridListener;
import com.company.Konstante;
import com.company.gumbi.NumberButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MeniMedIgro extends JMenuBar {

    JButton nazajMedIgro = new JButton("Nazaj");
    JButton shrani = new JButton("Shrani"); //Todo action listener

    CardLayout cardLayout;
    JPanel kartice;
    JFrame okno;

    //Za shrani
    int steviloPotez;
    NumberButton[][] matrikaGumbovZaShrani;
    int n;
    int m;


    String nazajNaMeni; // da lahko prilagodim AL za gumb nazaj - da gre ali na MeniTezavnost ali na MeniMojSvet

    public MeniMedIgro(CardLayout cardLayout, JPanel kartice, JFrame okno, String nazajNaMeni, int steviloPotez, NumberButton[][] matrikaGumbovZaShrani, int n, int m) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        this.okno = okno;
        this.nazajNaMeni = nazajNaMeni;
        this.steviloPotez = steviloPotez;
        this.matrikaGumbovZaShrani = matrikaGumbovZaShrani;
        this.n = n;
        this.m = m;
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

        ActionListener shraniListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                shraniIgro();
            }
        };
        shrani.addActionListener(shraniListener);
    }

    public void shraniIgro() {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File("ShranjenaIgra.txt")));
            bufferedWriter.write(steviloPotez);
            bufferedWriter.newLine();
            bufferedWriter.write(n);
            bufferedWriter.newLine();
            bufferedWriter.write(m);
            bufferedWriter.newLine();

            //loop čez gumbke v trenutnem stanju, za vsakega dam write v text file
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    bufferedWriter.write(matrikaGumbovZaShrani[i][j].getBarva());
                    bufferedWriter.newLine();
                }
            }
            System.out.println("Uspeh");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
