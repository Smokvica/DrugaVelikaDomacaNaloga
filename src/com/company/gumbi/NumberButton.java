package com.company.gumbi;

import javax.swing.*;

public class NumberButton extends JButton {
    private int barva;
    private int i;
    private int j;
    private boolean prebarvan = false;

    //Konstruktor
    public NumberButton(int barva, int i, int j) {
        this.barva = barva;
        this.i = i;
        this.j = j;
//      TODO  dodajIcon();
        setText(Integer.toString(barva));
    }


    public void spremeniBarvo(int novaBarva) {
        this.barva = novaBarva;
        this.setPrebarvan(true);
        setText(Integer.toString(novaBarva));
    }

    public void dodajIcon() {
//        TODO Icon buca = new ImageIcon(this.getClass().getResource("Slikice/buca.jpg"));
//        setIcon(buca);
    }

    //Getters & setters
    public int getBarva() {
        return barva;
    }

    public void setBarva(int barva) {
        this.barva = barva;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean isPrebarvan() {
        return prebarvan;
    }

    public void setPrebarvan(boolean prebarvan) {
        this.prebarvan = prebarvan;
    }
}
