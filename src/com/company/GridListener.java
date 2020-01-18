package com.company;

import com.company.gumbi.NumberButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GridListener implements ActionListener {

    NumberButton prvi;
    NumberButton drugi;
    int staraBarva; //da iščem sosede po stari barvi in ne po ravno spremenjeni
    int steviloPotez = 0;

    NumberButton[][] matrikaGumbov;
    int n;
    int m;

    public GridListener(NumberButton[][] matrikaGumbov, int n, int m) {
        this.matrikaGumbov = matrikaGumbov;
        this.n = n;
        this.m = m;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        NumberButton clicked = (NumberButton)actionEvent.getSource();
        if (prvi == null && drugi == null) {
            prvi = clicked;
            System.out.println("Prvi clicked");
        } else if (prvi != null && drugi == null) {
            drugi = clicked;


            //koda TODO
            // preveri, če je sosed prvemu
            if (drugi.getI() == prvi.getI() || drugi.getJ() == prvi.getJ()) {
                if(drugi.getI() == prvi.getI() - 1 || drugi.getI() == prvi.getI() + 1 || drugi.getJ() == prvi.getJ() - 1 || drugi.getJ() == prvi.getJ() + 1) {
                    if(drugi.getBarva() != prvi.getBarva()) {
                        staraBarva = drugi.getBarva();
                        drugi.spremeniBarvo(prvi.getBarva());
                        pobarvajOstale(drugi);
                        resetirajBool();
                        steviloPotez++;
                        System.out.println("Drugi clicked" + steviloPotez);
                    }
                }
            }
            // ali je drugačne barve
            // prebarvaj
            //označi, da si prebarvan



            prvi = null;
            drugi = null;
        }

    }

    //vsem sosedom daj metodo: 1) ali je iste barve 2) ali še ni prebarvan 3)prebarvaj, označi da si prebarvan, vsem sosedom daj metodo
    //  *pazi: lahko nima vseh sosedov
    public void pobarvajOstale(NumberButton zacetni) {

        //Polje sosednjih gumbov
        ArrayList<NumberButton> sosedje = new ArrayList<NumberButton>();

        //Poiščem sosede in jih dam v polje
        if(zacetni.getJ() > 0) {
            NumberButton sosedLevo = matrikaGumbov[zacetni.getI()][zacetni.getJ() - 1];
            sosedje.add(sosedLevo);
        }
        if(zacetni.getJ() < m - 1) {
            NumberButton sosedDesno = matrikaGumbov[zacetni.getI()][zacetni.getJ() + 1];
            sosedje.add(sosedDesno);
        }
        if(zacetni.getI() > 0) {
            NumberButton sosedZgoraj = matrikaGumbov[zacetni.getI() - 1][zacetni.getJ()];
            sosedje.add(sosedZgoraj);
        }
        if(zacetni.getI() < n - 1) {
            NumberButton sosedSpodaj = matrikaGumbov[zacetni.getI() + 1][zacetni.getJ()];
            sosedje.add(sosedSpodaj);
        }

        //Forloop čez arraylist
        for (int i = 0; i < sosedje.size(); i++) {
            //NumberButton sosed = sosedje.get(i);
            if(sosedje.get(i).getBarva() == staraBarva && !sosedje.get(i).isPrebarvan()) {
                sosedje.get(i).spremeniBarvo(zacetni.getBarva());
                pobarvajOstale(sosedje.get(i));
            }
        }

    }

    public void resetirajBool() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrikaGumbov[i][j].setPrebarvan(false);
            }
        }
    }

    public boolean aliJeKonec() {
        return false;
    }

    public void konecIgre() {
        // cardlayout, kartice TODO v konstruktor
        if(aliJeKonec()) {
            JOptionPane.showMessageDialog(null, "<html>Bravo, uspelo ti je! Zajčki so se s tvojo pomočjo pridno namnožili!<br><br>Število potez: " + steviloPotez+"<html>", "Zmaga!", JOptionPane.PLAIN_MESSAGE);
        }
        if(!aliJeKonec()) {
            JOptionPane.showMessageDialog(null, "<html>O, ne! Zajčki so pod tvojim poveljem pomrli!<br><br>Ubil si jih v toliko potezah: " + steviloPotez+"<html>", "Zmaga!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
