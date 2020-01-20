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
import java.io.File;

public class MeniZacetni extends JPanel {

    //Ustvarim elemente
    private JLabel naslov = new JLabel("Zajčja prevlada!");
    private JLabel podnaslov = new JLabel("Pomagaj zajčkom osvojiti svet!");
    private MenuButton zacni = new MenuButton("Začni igro");
    private MenuButton nadaljuj = new MenuButton("Nadaljuj");
    private MenuButton pravila = new MenuButton("Pravila igre");
    private MenuButton izhodZacetni = new MenuButton("Izhod");

    private JLabel pravilaIgre = new JLabel("<html>Čestitke! Zajčki so te izvolili za svojo vodjo.<br><br>Tvoja naloga je, da jim pomagaš uresničiti zloben načrt: ZAVZETI SVET!<br>Ker se v vlogi osvajalca verjetno še ne znajdeš, lahko začneš postopoma:<br>najprej osvoji vas, nato državo, na koncu pa Zemljo. Ker ti to seveda ni dovolj,<br>lahko osvojiš še vse ostale namišljene svetove.<br><br>Cilj igre je, da celotno igralno polje preplavijo zajčki. Slediti moraš preprostemu<br>načelu: klikneš polje, ki ga želiš razširiti ter njemu sosednje polje, ki ga želiš<br>spremeniti v prvo. Ni nujno, da vedno najprej označiš zajčka. Če ti uspe pobiti<br>vse zajčke na polju, je konec igre.<br><br>Ne pozabi, usoda zajčkov je v tvojih rokah!<br><br><html>");

    //Definiram nov CardLayout in JPanel in ju nato v konstruktorju enačim s tistima iz classa Aplikacije.
    private CardLayout cardLayout;
    private JPanel kartice;

    private JFrame okno;


    public MeniZacetni(CardLayout cardLayout, JPanel kartice, JFrame okno) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        this.okno = okno;
        ustvariMeniZacetni();
    } //konstruktor, da ta class lahko uporabim v Aplikaciji; prejme cardlayout in panel, da ju lahko uporabljam v spodnji metodi

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
        add(pravila);
        add(izhodZacetni);


        // Action listeners

        ActionListener odpriMeniTezavnost = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(kartice, Konstante.MENI_TEZAVNOST);
            }
        };
        zacni.addActionListener(odpriMeniTezavnost);

        ActionListener ugasniIgro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        };
        izhodZacetni.addActionListener(ugasniIgro);

        ActionListener pravilaListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(kartice, pravilaIgre, "Zajčja prevlada! - Pravila igre", JOptionPane.PLAIN_MESSAGE);
            }
        };
        pravila.addActionListener(pravilaListener);

        ActionListener nadaljujListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (aliObstajaShranjenaIgra()) {
                    IgralnaPlosca shranjenaIgralnaPlosca = new IgralnaPlosca(cardLayout, kartice, okno);
                    kartice.add(shranjenaIgralnaPlosca, Konstante.SHRANJENA_IGRALNA_PLOSCA);
                    cardLayout.show(kartice, Konstante.SHRANJENA_IGRALNA_PLOSCA);
                }
            }
        };
        nadaljuj.addActionListener(nadaljujListener);
    }

    private boolean aliObstajaShranjenaIgra() {
        File file = new File("ShranjenaIgra.txt");
        if (!file.exists()) {
//            nadaljuj.setEnabled(false);
            return false;
        } else {
//            nadaljuj.setEnabled(true);
            return true;
        }
    }
}
