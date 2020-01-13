package com.company.meniji;

import com.company.Aplikacija;
import com.company.gumbi.MenuButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;

public class MeniMojSvet extends JPanel {
    JLabel tvojSvet = new JLabel("Kakšen je tvoj svet?");

    JLabel nVisina = new JLabel("Višina: "); //Todo je n res višina in m širina
    JLabel mSirina = new JLabel("Širina: ");
    JLabel kPridelki = new JLabel("Število različnih pridelkov: ");
    JSpinner n;
    JSpinner m;
    JSpinner k;
    SpinnerModel modelN;
    SpinnerModel modelM;
    SpinnerModel modelK;

    MenuButton zacniCustom = new MenuButton("Igraj!"); //TODO action listener
    MenuButton nazajMojSvet = new MenuButton("Nazaj");

    CardLayout cardLayout;
    JPanel kartice;

    public MeniMojSvet(CardLayout cardLayout, JPanel kartice) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        ustvariMeniMojSvet();
    }

    public void ustvariMeniMojSvet() {

        //Uredim layout in robove (do kam so lahko gumbi, labels ipd.)
        setLayout(new GridLayout(0, 2, 0, 30));
        setBorder(new EmptyBorder(10, 200, 30, 200));

        //Uredim besedilo
        tvojSvet.setHorizontalAlignment(SwingConstants.CENTER);
        tvojSvet.setFont(new Font("Calibri", Font.BOLD, 30));


        //Naredim Spinners
        modelN = new SpinnerNumberModel(10, 2, 49, 1);
        modelM = new SpinnerNumberModel(10, 2, 49, 1);
        modelK = new SpinnerNumberModel(5, 2, 49, 1);
        n = new JSpinner(modelN);
        m = new JSpinner(modelM);
        k = new JSpinner(modelK);


        //Action Listeners

        ActionListener nazajMeniTezavnost = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                n.setValue(10);
                m.setValue(10);
                k.setValue(5);
                cardLayout.show(kartice, Aplikacija.MENI_TEZAVNOST);
            }
        };
        nazajMojSvet.addActionListener(nazajMeniTezavnost);



        //Dodam elemente na panel
        add(tvojSvet);
        add(nVisina);
        add(mSirina);
        add(kPridelki);
        add(n);
        add(m);
        add(k);
        add(zacniCustom);
        add(nazajMojSvet);

    }
}
