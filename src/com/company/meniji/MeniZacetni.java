package com.company.meniji;

import com.company.gumbi.MenuButton;

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

    JFrame okno; //Definiram novo okno. Konstruktor prejme JFrame okno iz Aplikacije, ki ga nato enačim s tem oknom. Ker ga definiram tukaj, ga lahko uporabljam v spodnjih metodah.

    public MeniZacetni(JFrame okno) {
        this.okno = okno;
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

        //Action Listeners
        ActionListener zacniListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //počistim okno
                okno.removeAll();
                //naredim panel z zgodbico
                JPanel zgodbica = new JPanel();
                JLabel zgodbicaBesedilo = new JLabel("<html>To je moja zgodbica, ki je lahko dolga in mislim, <br>da bo prikazana cela, tudi če bo v več vrsticah. Tralala, hopsasa, kje je moja zgodbica.</html>");
                zgodbicaBesedilo.setFont(new Font("Calibri", Font.ITALIC, 25));
                zgodbica.add(zgodbicaBesedilo);
                //naredim panel z menijem težavnosti
                MeniTezavnost meniTezavnost = new MeniTezavnost();
                //dodam oba panela na okno
                okno.add(zgodbica, BorderLayout.NORTH);
                okno.add(meniTezavnost, BorderLayout.CENTER);
                okno.setVisible(true);
            }
        };
        zacni.addActionListener(zacniListener);

    }
}
