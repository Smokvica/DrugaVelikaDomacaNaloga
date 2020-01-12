package com.company.meniji;

import com.company.Aplikacija;
import com.company.gumbi.MenuButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeniTezavnost extends JPanel {

    JLabel izberiTezavnost = new JLabel("Izberi težavnost:");
    MenuButton vas = new MenuButton("VAS");
    MenuButton drzava = new MenuButton("DRŽAVA");
    MenuButton planet = new MenuButton("PLANET ZEMLJA");
    MenuButton mojSvet = new MenuButton("MOJ SVET");
    MenuButton nazajTezavnost = new MenuButton("Nazaj");

    CardLayout cardLayout;
    JPanel kartice;

    public MeniTezavnost(CardLayout cardLayout, JPanel kartice) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        ustvariMeniTezavnost();
    }

    public void ustvariMeniTezavnost() {

        //Uredim layout in robove (do kam so lahko gumbi, labels ipd.)
        setLayout(new GridLayout(0, 1, 0, 30));
        setBorder(new EmptyBorder(10, 200, 30, 200));

        //Uredim besedilo
        izberiTezavnost.setHorizontalAlignment(SwingConstants.CENTER);
        izberiTezavnost.setFont(new Font("Calibri", Font.BOLD, 30));

        //Dodam elemente na panel
        add(izberiTezavnost);
        add(vas);
        add(drzava);
        add(planet);
        add(mojSvet);
        add(nazajTezavnost);

        //Action Listeners
        ActionListener nazajMeniZacetni = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(kartice, Aplikacija.MENI_ZACETNI);
            }
        };
        nazajTezavnost.addActionListener(nazajMeniZacetni);

        ActionListener odpriMeniMojSvet = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(kartice, Aplikacija.MENI_MOJ_SVET);
            }
        };
        mojSvet.addActionListener(odpriMeniMojSvet);
    }

}
