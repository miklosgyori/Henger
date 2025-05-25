package main.java.henger.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * GUI osztaly
 */
public class HengerView extends JFrame {

    private final JTextField magassagField = new JTextField(10);
    private final JTextField sugarField = new JTextField(10);
    private final JButton szamolasButton = new JButton("Számol");
    private final JLabel terfogatLabel = new JLabel("V = ");
    private final JLabel feluletLabel = new JLabel("A = ");

    public HengerView() {

        super("Henger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4,4,4,4);
        gbc.anchor = GridBagConstraints.WEST;

        // Sugar elemek
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("R:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(sugarField, gbc);

        // Magassag elemek
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(new JLabel("M:"), gbc);

        gbc.gridx = 1;  gbc.gridy = 1;
        add(magassagField, gbc);

        // Terfogat elem
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(terfogatLabel, gbc);

        // Felulet elem
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(feluletLabel, gbc);

        // "Szamol" gomb
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(szamolasButton, gbc);
        gbc.gridwidth = 1;

        pack();
        setSize(500, 200);
        setMinimumSize(new Dimension(400, 200));
        setLocationRelativeTo(null);
    }

    public String getMagassagText()  { return magassagField.getText(); }
    public String getSugarText()     { return sugarField.getText(); }
    public void   setTerfogatText(String t) { terfogatLabel.setText("V = " + t); }
    public void   setFeluletText(String f)  { feluletLabel.setText("A = " + f); }
    public void   addCalcListener(ActionListener l) { szamolasButton.addActionListener(l); }

    /**
     * Csak az osztaly gyors tesztelesere, meg mielott a controller es az App osztalyok elkeszulnek.
     * @param args - irrelevans
     */
    public static void main(String[] args) {
        // Always start Swing UIs on the EDT
        SwingUtilities.invokeLater(() -> {
            HengerView view = new HengerView();
            view.setTerfogatText("..........");
            view.setFeluletText("..........");
            view.setVisible(true);
        });
    }
}
