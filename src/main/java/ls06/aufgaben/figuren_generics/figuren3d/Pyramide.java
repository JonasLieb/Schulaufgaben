package ls06.aufgaben.figuren_generics.figuren3d;

import ls06.aufgaben.figuren_generics.figuren2d.*;

public abstract class Pyramide<T extends Figur2D> extends Figur3D {
    private double hoehe;
    private T grundflaeche;

    public Pyramide(T grundflaeche, double hoehe) {
        setGrundflaeche(grundflaeche);
        setHoehe(hoehe);
    }

    public void setGrundflaeche(T grundFlaeche) {
        this.grundflaeche = grundFlaeche;
    }

    public T getGrundFlaeche() {
        return grundflaeche;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getHoehe() {
        return hoehe;
    }

    public abstract double oberflaeche();

    @Override
    public double volumen() {
        return (grundflaeche.flaeche() * hoehe) / 3;
    }

}
