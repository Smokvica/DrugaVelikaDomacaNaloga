package com.company.meniji;

import com.company.gumbi.MenuButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MeniTezavnost extends JPanel {

    JLabel izberiTezavnost = new JLabel("Izberi težavnost:");
    MenuButton vas = new MenuButton("VAS");
    MenuButton drzava = new MenuButton("DRŽAVA");
    MenuButton planet = new MenuButton("PLANET ZEMLJA");
    MenuButton mojSvet = new MenuButton("MOJ SVET");
    MenuButton nazajTezavnost = new MenuButton("Nazaj");

    public MeniTezavnost() {
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
    }

}
