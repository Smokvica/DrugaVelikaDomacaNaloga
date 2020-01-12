package com.company.meniji;

import com.company.Aplikacija;
import com.company.gumbi.MenuButton;
import javafx.application.Application;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeniZacetni extends JPanel {

    //Ustvarim elemente
    JLabel naslov = new JLabel("Zajčja prevlada!");
    JLabel podnaslov = new JLabel("Pomagaj zajčkom osvojiti svet!");
    MenuButton zacni = new MenuButton("Začni igro");
    MenuButton nadaljuj = new MenuButton("Nadaljuj");
    MenuButton lestvica = new MenuButton("Lestvica");
    MenuButton pravila = new MenuButton("Pravila igre");
    MenuButton izhodZacetni = new MenuButton("Izhod");

    //Definiram nov CardLayout in JPanel. Konstruktor prejme ta dva objekta iz Aplikacije, ki ga nato enačim s tem oknom. Ker ga definiram tukaj, ga lahko uporabljam v spodnjih metodah.
    CardLayout cardLayout;
    JPanel kartice;

    public MeniZacetni(CardLayout cardLayout, JPanel kartice) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        ustvariMeniZacetni();
    } //konstruktor, da ga lahko uporabim v aplikaciji

    public void ustvariMeniZacetni() {
        //Uredim layout in robove (do kam so lahko gumbi, labels ipd.)
        setLayout(new GridLayout(0, 1, 0, 30));
        setBorder(new EmptyBorder(100, 200, 50, 200));

        //Uredim naslova
        naslov.setFont(new Font("Calibri", Font.BOLD, 60));
        naslov.setHorizontalAlignment(SwingConstants.CENTER); //da je besedilo na sredini
        podnaslov.setFont(new Font("Calibri", Font.ITALIC, 35));
        podnaslov.setHorizontalAlignment(SwingConstants.CENTER);

        //Dodam besedilo in gumbe na panel
        add(naslov);
        add(podnaslov);
        add(zacni);
        add(nadaljuj);
        add(lestvica);
        add(pravila);
        add(izhodZacetni);


        // Action listeners
        ActionListener pokaziNaslednjoKartico = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(kartice, Aplikacija.MENU_TEZAVNOST);
            }
        };

        zacni.addActionListener(pokaziNaslednjoKartico);

    }
}
