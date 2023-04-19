package ls07.aufgaben.figuren_factories.figuren3d;

import ls07.aufgaben.figuren_factories.figuren2d.NEck;

public class GleichseitigePyramide extends Pyramide<NEck> {

    public GleichseitigePyramide(NEck grundflaeche, double hoehe) {
        super(grundflaeche, hoehe);
    }

    @Override
    public double oberflaeche() {
        NEck base = getGrundFlaeche();
        double sideHeight = Math.sqrt(Math.pow(base.getOuterRadius(), 2) * Math.pow(getHoehe(), 2));
        double triangleArea = sideHeight * base.getSeiteLaenge();
        return base.flaeche() + (base.getAnzahlSeiten() * triangleArea);
    }
}
