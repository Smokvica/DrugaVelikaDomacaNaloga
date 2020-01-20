package com.company.meniji;

import com.company.Aplikacija;
import com.company.IgralnaPlosca;
import com.company.Konstante;
import com.company.gumbi.MenuButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeniTezavnost extends JPanel {

    private JLabel izberiTezavnost = new JLabel("Izberi težavnost:");
    private MenuButton vas = new MenuButton("VAS");
    private MenuButton drzava = new MenuButton("DRŽAVA");
    private MenuButton planet = new MenuButton("PLANET ZEMLJA");
    private MenuButton mojSvet = new MenuButton("MOJ SVET");
    private MenuButton nazajTezavnost = new MenuButton("Nazaj");

    private CardLayout cardLayout;
    private JPanel kartice;
    private JFrame okno;

    public MeniTezavnost(CardLayout cardLayout, JPanel kartice, JFrame okno) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        this.okno = okno;
        ustvariMeniTezavnost();
    }

    private void ustvariMeniTezavnost() {

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
                cardLayout.show(kartice, Konstante.MENI_ZACETNI);
            }
        };
        nazajTezavnost.addActionListener(nazajMeniZacetni);

        ActionListener odpriMeniMojSvet = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(kartice, Konstante.MENI_MOJ_SVET);
            }
        };
        mojSvet.addActionListener(odpriMeniMojSvet);

        ActionListener igrajVas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                IgralnaPlosca igralnaPloscaVas = new IgralnaPlosca(5, 5, 3, cardLayout, kartice, okno, Konstante.MENI_TEZAVNOST);
                kartice.add(igralnaPloscaVas, Konstante.IGRALNA_PLOSCA_VAS);
                cardLayout.show(kartice, Konstante.IGRALNA_PLOSCA_VAS);
            }
        };
        vas.addActionListener(igrajVas);

        ActionListener igrajDrzava = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                IgralnaPlosca igralnaPloscaDrzava = new IgralnaPlosca(9, 9, 7, cardLayout, kartice, okno, Konstante.MENI_TEZAVNOST);
                kartice.add(igralnaPloscaDrzava, Konstante.IGRALNA_PLOSCA_DRZAVA);
                cardLayout.show(kartice, Konstante.IGRALNA_PLOSCA_DRZAVA);
            }
        };
        drzava.addActionListener(igrajDrzava);

        ActionListener igrajPlanet = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                IgralnaPlosca igralnaPloscaPlanet = new IgralnaPlosca(18, 18, 10, cardLayout, kartice, okno, Konstante.MENI_TEZAVNOST);
                kartice.add(igralnaPloscaPlanet, Konstante.IGRALNA_PLOSCA_PLANET);
                cardLayout.show(kartice, Konstante.IGRALNA_PLOSCA_PLANET);
            }
        };
        planet.addActionListener(igrajPlanet);
    }
}
