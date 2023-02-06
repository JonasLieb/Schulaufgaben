package ls03.aufgaben.klassenundmethoden.aufgabe2;

public class Rechteck {

    private double laenge;
    private double breite;

    public Rechteck(double laenge, double breite) {
        setLaenge(laenge);
        setBreite(breite);
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        if (laenge <= 0)
            throw new IllegalArgumentException("Die Länge eines Rechtecks kann nicht kleiner oder gleich 0 sein.");
        this.laenge = laenge;
    }

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        if (breite <= 0)
            throw new IllegalArgumentException("Die Breite eines Rechtecks kann nicht kleiner oder gleich 0 sein.");
        this.breite = breite;
    }

    public double umfang() {
        return 2 * getLaenge() + 2 * getBreite();
    }

    public double flaeche() {
        return getLaenge() * getBreite();
    }
}
