package test.java.henger.model;

import main.java.henger.model.Henger;

/**
 * A Henger osztaly egyszeru tesztelesere.
 * ChatGPT-vel generalva, minimalisan modositva.
 */
public class HengerTest {
    private static final double EPS = 1e-6;

    public static void main(String[] args) {
        boolean ok = true;
        ok &= testGetters();
        ok &= testVolume();
        ok &= testSurface();
        if (ok) {
            System.out.println("Tesztek: OK.");
        } else {
            System.out.println("Legalabb 1 teszt hibat mutat.");
            System.exit(1);
        }
    }

    private static boolean testGetters() {
        Henger h = new Henger(4.2, 1.5);
        boolean pass = true;
        if (Math.abs(h.getMagassag() - 4.2) > EPS) {
            System.err.printf("getMagassag(): elvart 4.2, kapott %.6f%n", h.getMagassag());
            pass = false;
        }
        if (Math.abs(h.getSugar() - 1.5) > EPS) {
            System.err.printf("getSugar(): elvart 1.5, kapott %.6f%n", h.getSugar());
            pass = false;
        }
        if (pass) System.out.println("Getterek tesztje OK.");
        return pass;
    }

    private static boolean testVolume() {
        double hVal = 5.0, rVal = 2.0;
        Henger h = new Henger(hVal, rVal);
        double expected = Math.PI * rVal * rVal * hVal;
        double actual   = h.getTerfogat();
        if (Math.abs(expected - actual) <= EPS) {
            System.out.println("Terfogat tesztje OK.");
            return true;
        } else {
            System.err.printf("Terfogat tesztje: elvart %.6f, kapott %.6f%n", expected, actual);
            return false;
        }
    }

    private static boolean testSurface() {
        double hVal = 5.0, rVal = 2.0;
        Henger h = new Henger(hVal, rVal);
        double expected = 2 * Math.PI * rVal * (rVal + hVal);
        double actual   = h.getFelulet();
        if (Math.abs(expected - actual) <= EPS) {
            System.out.println("Felszin tesztje OK.");
            return true;
        } else {
            System.err.printf("Felszin tesztje: elvart %.6f, kapott %.6f%n", expected, actual);
            return false;
        }
    }
}
