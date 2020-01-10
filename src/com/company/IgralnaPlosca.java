package com.company;

import javax.swing.*;

public class IgralnaPlosca extends JPanel {

    private int n;
    private int m;
    private int k;

    //Konstruktor
    public IgralnaPlosca(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
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
