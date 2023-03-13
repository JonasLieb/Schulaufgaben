package ls06.aufgaben.figuren_generics.figuren3d;

import ls06.aufgaben.figuren_generics.figuren2d.*;

public class GeradesPrisma<T extends Figur2D> extends Figur3D {
    private double hoehe;
    private T grundflaeche;

    public GeradesPrisma(T grundflaeche, double hoehe) {
        validateType();
        setGrundflaeche(grundflaeche);
        setHoehe(hoehe);
    }


    private void validateType() {
        if(grundflaeche instanceof Kreis)throw new IllegalArgumentException("Ein grade Prisma kann nicht mit einem Kreis als Grundfläche gebaut werden. Das wäre ein Zylinder");
    }

    @Override
    public double oberflaeche() {
        double mantelFlaeche = getGrundflaeche().umfang() * hoehe;
        double obenUnten = getGrundflaeche().flaeche() * 2;
        return mantelFlaeche + obenUnten;
    }

    @Override
    public double volumen() {
        return getGrundflaeche().flaeche() * getHoehe();
    }

    public void setGrundflaeche(T grundflaeche) {
        this.grundflaeche = grundflaeche;
    }

    public Figur2D getGrundflaeche() {
        return grundflaeche;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getHoehe() {
        return hoehe;
    }
}
