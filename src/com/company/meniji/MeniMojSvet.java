package com.company.meniji;

import com.company.IgralnaPlosca;
import com.company.Konstante;
import com.company.gumbi.MenuButton;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeniMojSvet extends JPanel {
    private JLabel tvojSvet = new JLabel("Kakšen je tvoj svet?");

    private JLabel nVisina = new JLabel("Višina: ");
    private JLabel mSirina = new JLabel("Širina: ");
    private JLabel kPridelki = new JLabel("Pridelki: ");
    private JSpinner n;
    private JSpinner m;
    private JSpinner k;

    private MenuButton zacniMojSvet = new MenuButton("Igraj!");
    private MenuButton nazajMojSvet = new MenuButton("Nazaj");

    private JPanel parametri = new JPanel();
    private JPanel spodnjaGumba = new JPanel();

    private CardLayout cardLayout;
    private JPanel kartice;
    private JFrame okno; //da lahko dam meni med igro na okno, ko pritisnem gumb igraj

    public MeniMojSvet(CardLayout cardLayout, JPanel kartice, JFrame okno) {
        this.cardLayout = cardLayout;
        this.kartice = kartice;
        this.okno = okno;
        ustvariMeniMojSvet();
    }

    private void ustvariMeniMojSvet() {

        //Uredim layout in robove (do kam so lahko gumbi, labels ipd.)
        setLayout(new GridLayout(0,1,0, 90));
        setBorder(new EmptyBorder(10, 200, 30, 200));
        parametri.setLayout(new GridLayout(3, 2, 50, 20));
        spodnjaGumba.setLayout(new GridLayout(0,1, 0, 30));

        //Uredim besedilo
        tvojSvet.setHorizontalAlignment(SwingConstants.CENTER);
        tvojSvet.setVerticalAlignment(SwingConstants.CENTER);
        tvojSvet.setFont(new Font("Calibri", Font.BOLD, 30));
        nVisina.setFont(new Font("Calibri", Font.PLAIN, 20));
        mSirina.setFont(new Font("Calibri", Font.PLAIN, 20));
        kPridelki.setFont(new Font("Calibri", Font.PLAIN, 20));


        //Naredim Spinners
        SpinnerModel modelN = new SpinnerNumberModel(10, 2, 49, 1);
        SpinnerModel modelM = new SpinnerNumberModel(10, 2, 49, 1);
        SpinnerModel modelK = new SpinnerNumberModel(5, 2, 20, 1);
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
                cardLayout.show(kartice, Konstante.MENI_TEZAVNOST);
            }
        };
        nazajMojSvet.addActionListener(nazajMeniTezavnost);

        ActionListener igrajMojSvet = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int novN = (Integer)n.getValue();
                int novM = (Integer)m.getValue();
                int novK = (Integer)k.getValue();
                if (novK <= (novN * novM)) {
                    IgralnaPlosca igralnaPloscaMojSvet = new IgralnaPlosca(novN, novM, novK, cardLayout, kartice, okno, Konstante.MENI_MOJ_SVET);
                    kartice.add(igralnaPloscaMojSvet, Konstante.IGRALNA_PLOSCA_MOJ_SVET);
                    cardLayout.show(kartice, Konstante.IGRALNA_PLOSCA_MOJ_SVET);
                } else {
                    JOptionPane.showMessageDialog(kartice, "Število pridelkov je previsoko za tvoj svet.", "Ne bo šlo.", JOptionPane.PLAIN_MESSAGE);
                }
            }
        };
        zacniMojSvet.addActionListener(igrajMojSvet);


        //Dodam elemente na panel
        add(tvojSvet);
        parametri.add(nVisina);
        parametri.add(n);
        parametri.add(mSirina);
        parametri.add(m);
        parametri.add(kPridelki);
        parametri.add(k);
        add(parametri);
        spodnjaGumba.add(zacniMojSvet);
        spodnjaGumba.add(nazajMojSvet);
        add(spodnjaGumba);
    }
}