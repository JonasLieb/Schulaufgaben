package ls07.aufgaben.figuren_factories.figuren3d;

import ls07.aufgaben.figuren_factories.figuren2d.Kreis;

public class Kreiskegel extends Pyramide<Kreis> {

    public Kreiskegel(Kreis grundflaeche, double hoehe) {
        super(grundflaeche, hoehe);
    }

    @Override
    public double oberflaeche() {
        double radius = getGrundFlaeche().getRadius();
        double sideheight = Math.sqrt(Math.pow(radius, 2) * Math.pow(getHoehe(), 2));
        return Math.pow(radius, 2) * Math.PI + radius * Math.PI * sideheight;
    }
}
