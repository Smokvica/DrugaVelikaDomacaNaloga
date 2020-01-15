package com.company.gumbi;

import javax.swing.*;

public class NumberButton extends JButton {
    private int barva;
    private int i;
    private int j;

    //Konstruktor
    public NumberButton(int barva, int i, int j) {
        this.barva = barva;
        this.i = i;
        this.j = j;

        setText(Integer.toString(barva));
    }


    public void spremeniBarvo(int novaBarva) {
        this.barva = novaBarva;
        setText(Integer.toString(novaBarva));
    }





    //Getters & setters
    public int getBarva() {
        return barva;
    }

    public void setBarva(int barva) {
        this.barva = barva;
    }
}
