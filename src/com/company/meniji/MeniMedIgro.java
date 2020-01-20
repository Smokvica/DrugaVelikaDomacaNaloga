package com.company.meniji;

import com.company.GridListener;
import com.company.IgralnaPlosca;
import com.company.Konstante;
import com.company.gumbi.NumberButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLOutput;

public class MeniMedIgro extends JMenuBar {

    private JButton nazajMedIgro = new JButton("Nazaj");
    private JButton shrani = new JButton("Shrani");

    private CardLayout cardLayout;
    private JPanel kartice;
    private JFrame okno;

    //Za shrani
    private NumberButton[][] matrikaGumbovZaShrani;
    private int n;
    private int m;
    private IgralnaPlosca plosca; // da lahko dobim število potez za shrani

    private String nazajNaMeni; // da lahko prilagodim AL za gumb nazaj - da gre ali na MeniTezavnost ali na MeniMojSvet

    public MeniMedIgro(CardLayout cardLayout, JPanel kartice, JFrame okno, String nazajNaMeni, NumberButton[][] matrikaGumbovZaShrani, int n, int m, IgralnaPlosca plosca) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        this.okno = okno;
        this.nazajNaMeni = nazajNaMeni;
        this.matrikaGumbovZaShrani = matrikaGumbovZaShrani;
        this.n = n;
        this.m = m;
        this.plosca = plosca;
        ustvariMeniMedIgro();
    }

    private void ustvariMeniMedIgro() {

        add(nazajMedIgro);
        add(shrani);

        ActionListener nazajListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(nazajNaMeni.equals(Konstante.MENI_ZACETNI)) {
                    okno.setJMenuBar(null);
                    cardLayout.show(kartice, Konstante.MENI_ZACETNI);
                } else if(nazajNaMeni.equals(Konstante.MENI_TEZAVNOST)) {
                    okno.setJMenuBar(null);
                    cardLayout.show(kartice, Konstante.MENI_TEZAVNOST);
                } else if(nazajNaMeni.equals(Konstante.MENI_MOJ_SVET)) {
                    okno.setJMenuBar(null);
                    cardLayout.show(kartice, Konstante.MENI_MOJ_SVET);
                }
            }
        };
        nazajMedIgro.addActionListener(nazajListener);

        ActionListener shraniListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                shraniIgro();
            }
        };
        shrani.addActionListener(shraniListener);
    }

    private void shraniIgro() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("ShranjenaIgra.txt")));

            bufferedWriter.write(String.valueOf(plosca.getSteviloPotez()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(n));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(m));
            bufferedWriter.newLine();

            //loop čez gumbke v trenutnem stanju, za vsakega dam write v text file
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    bufferedWriter.write(String.valueOf(matrikaGumbovZaShrani[i][j].getBarva()));  //brez String.valueOf je v txt zapisovalo neke kvadratke
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
