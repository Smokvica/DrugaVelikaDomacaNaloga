package com.company;

import com.company.gumbi.NumberButton;
import com.company.meniji.MeniMedIgro;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class IgralnaPlosca extends JPanel {

    private int n;
    private int m;
    private int k;


    //Za meni med igro
    CardLayout cardLayout;
    JPanel kartice;
    JFrame okno;
    String nazajNaMeni; //da lahko grem iz igre nazaj na pravi meni, ko kliknem nazaj na menubar

    //Za shrani
    NumberButton[][] matrikaGumbov;

    //Konstruktor
    public IgralnaPlosca(int n, int m, int k, CardLayout cardLayout, JPanel kartice, JFrame okno, String nazajNaMeni) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        this.okno = okno;
        this.nazajNaMeni = nazajNaMeni;
        postaviPlosco();
        dodajMeniMedIgro();
    }



    public void postaviPlosco() {

        Random rand = new Random();
        setLayout(new GridLayout(n, m));
        matrikaGumbov = new NumberButton[n][m];
        GridListener poslusalec = new GridListener(matrikaGumbov, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                NumberButton igralniGumb = new NumberButton(rand.nextInt(k) + 1, i, j);
                igralniGumb.addActionListener(poslusalec);
                add(igralniGumb);
                matrikaGumbov[i][j] = igralniGumb;
            }
        }
    }

    public void dodajMeniMedIgro() {
        MeniMedIgro meniMedIgro = new MeniMedIgro(cardLayout, kartice, okno, nazajNaMeni);
        okno.setJMenuBar(meniMedIgro);
    }

    public void beleziSteviloPotez() {

    }




    //Getters & setters
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
