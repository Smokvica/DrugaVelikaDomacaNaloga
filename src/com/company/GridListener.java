package com.company;

import com.company.gumbi.NumberButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GridListener implements ActionListener {

    NumberButton prvi;
    NumberButton drugi;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        NumberButton clicked = (NumberButton)actionEvent.getSource();
        if (prvi == null && drugi == null) {
            prvi = clicked;
            System.out.println("Prvi clicked");
        } else if (prvi != null && drugi == null) {
            drugi = clicked;
            System.out.println("Drugi clicked");

            //koda TODO

            prvi = null;
            drugi = null;
        }

    }
}
