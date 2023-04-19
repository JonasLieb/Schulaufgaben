package ls07.aufgaben.figuren_factories;

import ls07.aufgaben.figuren_factories.figuren2d.*;

public class FigurenFactory {

    public static Figur2D getFigur2D(Class<Figur2D> clazz) {
        if (Achteck.class.equals(clazz)) {
            double seitenlaenge = -1; //TODO
            return new Achteck(seitenlaenge);
        } else if (Dreieck.class.equals(clazz)) {
            double seitenlaenge1 = -1; //TODO
            double seitenlaenge2 = -1; //TODO
            double seitenlaenge3 = -1; //TODO
            return new Dreieck(seitenlaenge1, seitenlaenge2, seitenlaenge3);
        }
    }

}
