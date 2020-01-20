package com.company.gumbi;

import com.company.ResizeIcon;

import javax.swing.*;
import java.awt.*;


public class NumberButton extends JButton {
    private int barva;
    private int i;
    private int j;
    private ResizeIcon slika;
    private boolean prebarvan = false;

    //Konstruktor
    public NumberButton(int barva, int i, int j) {
        this.barva = barva;
        this.i = i;
        this.j = j;
        dodajIcon();
    }

    public void spremeniBarvo(int novaBarva) {
        this.barva = novaBarva;
        this.setPrebarvan(true);
        dodajIcon();
    }

    public void dodajIcon() {
        setBackground(Color.WHITE);

        if (barva == 1) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/zajcek.gif"));
            setIcon(slika);
        } else if (barva == 2) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/deteljica.png"));
            setIcon(slika);
        } else if (barva == 3) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/korenje.jpg"));
            setIcon(slika);
        }else if (barva == 4) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/cvetaca.jpg"));
            setIcon(slika);
        }else if (barva == 5) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/jabolko.png"));
            setIcon(slika);
        }else if (barva == 6) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/psenica.jpg"));
            setIcon(slika);
        }else if (barva == 7) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/goba.jpg"));
            setIcon(slika);
        }else if (barva == 8) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/buca.jpg"));
            setIcon(slika);
        }else if (barva == 9) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/koruza.jpg"));
            setIcon(slika);
        }else if (barva == 10) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/krompir.png"));
            setIcon(slika);
        }else if (barva == 11) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/marjetica.png"));
            setIcon(slika);
        }else if (barva == 12) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/hamburger.png"));
            setIcon(slika);
        }else if (barva == 13) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/regrat.png"));
            setIcon(slika);
        }else if (barva == 14) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/paradiznik.png"));
            setIcon(slika);
        }else if (barva == 15) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/zelje.jpg"));
            setIcon(slika);
        }else if (barva == 16) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/paprika.png"));
            setIcon(slika);
        }else if (barva == 17) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/jajcevec.jpg"));
            setIcon(slika);
        }else if (barva == 18) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/grah.png"));
            setIcon(slika);
        }else if (barva == 19) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/hruska.png"));
            setIcon(slika);
        }else if (barva == 20) {
            slika = new ResizeIcon(getClass().getResource("/Slikice/drevo.png"));
            setIcon(slika);
        }

    }

    //Getters & setters
    public int getBarva() {
        return barva;
    }

    public void setBarva(int barva) {
        this.barva = barva;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean isPrebarvan() {
        return prebarvan;
    }

    public void setPrebarvan(boolean prebarvan) {
        this.prebarvan = prebarvan;
    }
}
