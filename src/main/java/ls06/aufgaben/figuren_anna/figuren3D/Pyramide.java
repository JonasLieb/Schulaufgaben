package ls06.aufgaben.figuren_anna.figuren3D;
import ls06.aufgaben.figuren_anna.figuren2D.*;

public abstract class Pyramide extends Figur3D {
    private double hoehe;
    private Figur2D grundflaeche;

    public Pyramide(Figur2D grundflaeche, double hoehe) {
        setGrundflaeche(grundflaeche);
        setHoehe(hoehe);
    }

    public double volumen() {
        return (grundflaeche.Flaeche() * hoehe) / 3;
    }

    public void setGrundflaeche(Figur2D grundFlaeche) {
        this.grundflaeche = grundFlaeche;
    }

    public Figur2D getGrundFlaeche() {
        return grundflaeche;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getHoehe() {
        return hoehe;
    }
}
