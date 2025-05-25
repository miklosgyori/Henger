package main.java.henger;

import main.java.henger.controller.HengerController;
import main.java.henger.view.HengerView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HengerView view = new HengerView();
            new HengerController(view);
            view.setVisible(true);
        });
    }
}
