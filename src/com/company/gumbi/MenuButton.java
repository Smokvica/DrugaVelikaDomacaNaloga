package com.company.gumbi;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {

    //V vsak konstruktor dodam spremenjen font, zato da je spremenjen ne glede na to, na kakšen način naredim nov My Button

    public MenuButton() {
        setFont(new Font("Calibri", Font.PLAIN, 25));
    }

    public MenuButton(Icon icon) {
        super(icon);
        setFont(new Font("Calibri", Font.PLAIN, 25));
    }

    public MenuButton(String text) {
        super(text);
        setFont(new Font("Calibri", Font.PLAIN, 25));
    }

    public MenuButton(Action a) {
        super(a);
        setFont(new Font("Calibri", Font.PLAIN, 25));
    }

    public MenuButton(String text, Icon icon) {
        super(text, icon);
        setFont(new Font("Calibri", Font.PLAIN, 25));
    }
}
