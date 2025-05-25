package main.java.henger.controller;

import main.java.henger.model.Henger;
import main.java.henger.view.HengerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * HengerController osztaly
 * A Henger osztaly es a GUI (Hengerview osztaly) kozti kapcsolatot biztositja; felhasznaloi input beolvasasa, megfelelo
 * szamolasi fuggvenyek hivasa a Henger osztalybol, eredmenyek visszakuldese GUI-ba.
 */
public class HengerController {

    private final HengerView view;
    private final DecimalFormat fmt = new DecimalFormat("#.00");

    public HengerController(HengerView view) {
        this.view = view;
        this.view.addSzamolasListener(new SzamolasListener());
    }

    class SzamolasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double m = Double.parseDouble(view.getMagassagText());
                double s = Double.parseDouble(view.getSugarText());
                Henger henger = new Henger(m, s);

                String terfogatString = fmt.format(henger.getTerfogat());
                String feluletString  = fmt.format(henger.getFelulet());
                view.setTerfogatText(terfogatString);
                view.setFeluletText(feluletString);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view,
                        "Nem ervenyes szamo(ka)t adtal meg!",
                        "Hiba!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
