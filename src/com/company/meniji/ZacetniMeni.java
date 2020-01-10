package com.company.meniji;

import javax.swing.*;
import java.awt.*;

public class ZacetniMeni extends JPanel {
    JLabel naslov = new JLabel("Zajčja prevlada!");
    JLabel podnaslov = new JLabel("Pomagaj zajčkom osvojiti svet!");
    JButton zacni = new JButton("Začni igro");
    JButton nadaljuj = new JButton("Nadaljuj");
    JButton lestvica = new JButton("Lestvica");
    JButton pravila = new JButton("Pravila igre");

    public ZacetniMeni() {
        init();
    }

    public void init() {
        naslov.setFont(new Font("Calibri", Font.BOLD, 60));
        podnaslov.setFont(new Font("Calibri", Font.ITALIC, 30));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(naslov);
        add(podnaslov);
        add(zacni);
        add(nadaljuj);
        add(lestvica);
        add(pravila);
    }
}
