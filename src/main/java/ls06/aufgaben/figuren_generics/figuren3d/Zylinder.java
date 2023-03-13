package ls06.aufgaben.figuren_generics.figuren3d;

import ls06.aufgaben.figuren_generics.figuren2d.Figur2D;
import ls06.aufgaben.figuren_generics.figuren2d.Kreis;

public class Zylinder extends GeradesPrisma<Kreis> {

    public Zylinder(Kreis grundflaeche, double hoehe) {
        super(grundflaeche, hoehe);
    }

    private void validateType() {
        return;
    }
}
