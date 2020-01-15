package com.company;

import com.company.gumbi.NumberButton;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class IgralnaPlosca extends JPanel {

    private int n;
    private int m;
    private int k;

    //Konstruktor
    public IgralnaPlosca(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        postaviPlosco();
    }



    public void postaviPlosco() {

        Random rand = new Random();
        setLayout(new GridLayout(n, m));
        NumberButton[][] matrikaGumbov = new NumberButton[n][m];
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

    public void beleziSteviloPotez() {

    }

    public void shrani() {

    }

    /**
     * vzemi barvo gumba (0,0)
     *
     * primerjaj barvo gumba z ostalimi gumbi ("dvojni forloop" - Benjamin, 13. 1. 2020)
     *
     */
    public boolean aliJeKonec() {
        return false;
    }

    public void poteza() {

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
