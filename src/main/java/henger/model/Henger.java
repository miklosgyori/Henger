package main.java.henger.model;

/**
 * A Henger osztaly
 */
public class Henger {

    private final double magassag;
    private final double sugar;

    public Henger(double magassag, double sugar) {
        this.magassag = magassag;
        this.sugar = sugar;
    }

    public double getMagassag() {
        return magassag;
    }

    public double getSugar() {
        return sugar;
    }

    /**
     * A henger objektum terfogatat szamolja
     * @return terfogat == pi * sugar * sugar * magassag
     */
    public double getTerfogat(){
        return Math.PI * sugar * sugar * magassag;
    }

    /**
     * A henger objektum feluletet szamolja
     * @return felulet == 2 * pi * sugar * (sugar + magassag)
     */
    public double getFelulet(){
        return 2 * Math.PI * sugar * (sugar + magassag);
    }
}
