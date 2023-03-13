package ls06.aufgaben.figuren_generics.figuren2d;

public class NEck extends Figur2D {

    private int anzahlSeiten;
    private double seiteLaenge;

    public NEck(int anzahlSeiten, double seiteLaenge) {
        super(anzahlSeiten, seiteLaenge);
        this.anzahlSeiten = anzahlSeiten;
        this.seiteLaenge = seiteLaenge;
    }

    @Override
    public double umfang() {
        return anzahlSeiten * seiteLaenge;
    }

    @Override
    public double flaeche() {
        double inkreisRadius = seiteLaenge / (2 * Math.tan(Math.PI / anzahlSeiten));
        double height = seiteLaenge / 2;
        return inkreisRadius * height * anzahlSeiten;
    }

    public int getAnzahlSeiten() {
        return anzahlSeiten;
    }

    public double getSeiteLaenge() {
        return seiteLaenge;
    }

    public double getOuterRadius() {
        //Der Math.sin arbeitet mit Radians. Daher müssen die 180° in 180 rad umgewandelt werden.
        return getSeiteLaenge() / (2 * Math.sin(Math.toRadians(180) / getAnzahlSeiten()));
    }
}