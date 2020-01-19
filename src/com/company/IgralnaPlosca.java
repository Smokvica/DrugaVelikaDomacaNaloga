package com.company;

import com.company.gumbi.NumberButton;
import com.company.meniji.MeniMedIgro;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class IgralnaPlosca extends JPanel {

    private int n;
    private int m;
    private int k;


    //Za meni med igro
    CardLayout cardLayout;
    JPanel kartice;
    JFrame okno;
    String nazajNaMeni; //da lahko grem iz igre nazaj na pravi meni, ko kliknem nazaj na menubar
    NumberButton[][] matrikaGumbov;

    //Da lahko do tega dostopata gridlistener in meni med igro (shrani)
    int steviloPotez = 0;

    //Konstruktor za novo igro
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

    //Konstruktor za shranjeno igro
    public IgralnaPlosca(CardLayout cardLayout, JPanel kartice, JFrame okno) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        this.okno = okno;
        nazajNaMeni = Konstante.MENI_ZACETNI;
        naloziShranjenoIgro();
        dodajMeniMedIgro();
    }


    public void postaviPlosco() {

        Random rand = new Random();
        setLayout(new GridLayout(n, m));
        matrikaGumbov = new NumberButton[n][m];
        GridListener poslusalec = new GridListener(matrikaGumbov, n, m, cardLayout, kartice, okno, this);

        int steviloZajckov = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                NumberButton igralniGumb = new NumberButton(rand.nextInt(k) + 1, i, j);
                igralniGumb.addActionListener(poslusalec);
                add(igralniGumb);
                matrikaGumbov[i][j] = igralniGumb;
                if(igralniGumb.getBarva() == 1) {
                    steviloZajckov++;
                }
            }
        }
        if(steviloZajckov == 0) {
            NumberButton vsajEnZajcek = matrikaGumbov[rand.nextInt(n)][rand.nextInt(m)];
            vsajEnZajcek.spremeniBarvo(1);
            vsajEnZajcek.setPrebarvan(false);
            System.out.println("It happened!");
        }
    }

    public void dodajMeniMedIgro() {
        MeniMedIgro meniMedIgro = new MeniMedIgro(cardLayout, kartice, okno, nazajNaMeni, matrikaGumbov, n, m, this);
        okno.setJMenuBar(meniMedIgro);
    }

    public void naloziShranjenoIgro() {
        Scanner reader;
        try {
            reader = new Scanner(new File("ShranjenaIgra.txt"));
            steviloPotez = Integer.parseInt(reader.next());
            System.out.println(steviloPotez);
            n = Integer.parseInt(reader.next());
            System.out.println(n);
            m = Integer.parseInt(reader.next());
            System.out.println(m);

            setLayout(new GridLayout(n, m));
            matrikaGumbov = new NumberButton[n][m];
            GridListener poslusalec = new GridListener(matrikaGumbov, n, m, cardLayout, kartice, okno, this);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    NumberButton gumbek = new NumberButton(Integer.parseInt(reader.next()), i, j);
                    gumbek.addActionListener(poslusalec);
                    add(gumbek);
                    matrikaGumbov[i][j] = gumbek;
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void bla() {
        System.out.println("Blala");
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

    public int getSteviloPotez() {
        return steviloPotez;
    }

    public void setSteviloPotez(int steviloPotez) {
        this.steviloPotez = steviloPotez;
    }
}
