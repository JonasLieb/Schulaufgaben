package ls07.aufgaben.figuren_factories.figuren3d;

import ls07.aufgaben.figuren_factories.figuren2d.Kreis;

public class Zylinder extends GeradesPrisma<Kreis> {

    public Zylinder(Kreis grundflaeche, double hoehe) {
        super(grundflaeche, hoehe);
    }

    private void validateType() {
        return;
    }
}
