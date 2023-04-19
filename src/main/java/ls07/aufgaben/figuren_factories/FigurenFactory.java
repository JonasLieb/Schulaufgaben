package ls07.aufgaben.figuren_factories;

import ls07.aufgaben.figuren_factories.figuren2d.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FigurenFactory {

    public static Figur2D getFigur2D(Class<Figur2D> clazz) {
        if (clazz == null)
            return null;
        if (Achteck.class.equals(clazz)) {
            double seitenlaenge = -1; //TODO: ermitteln
            return new Achteck(seitenlaenge);
        } else if (Dreieck.class.equals(clazz)) {
            double s1 = -1; //TODO: ermitteln
            double s2 = -1; //TODO: ermitteln
            double s3 = -1; //TODO: ermitteln
            return new Dreieck(s1, s2, s3);
        } else if (Kreis.class.equals(clazz)) {
            double radius = -1; //TODO: ermitteln
            return new Kreis(radius);
        } else if (NEck.class.equals(clazz)) {
            int seitenAnzahl = -1; //TODO: ermitteln
            double seitenlaenge = -1; //TODO: ermitteln
            return new NEck(seitenAnzahl, seitenlaenge);
        } else if (Rechteck.class.equals(clazz)) {
            double s1 = -1; //TODO: ermitteln
            double s2 = -1; //TODO: ermitteln
            return new Rechteck(s1, s2);
        } else if (Sechseck.class.equals(clazz)) {
            double seitenlaenge = -1; //TODO: ermitteln
            return new Sechseck(seitenlaenge);
        } else {
            throw new IllegalArgumentException("Die Klasse clazz ist keine bekannte Figur2D");
        }
    }

    public static List<Figur2D> reflectFigures(File f) throws FileNotFoundException {
        List<Figur2D> figuren = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        reader.lines().forEach(line -> {
            Figur2D fig = reflect(line);
            if (fig != null)
                figuren.add(fig);
        });
        return figuren;
    }


    public static Figur2D reflect(String csvLine) {
        //TODO
    }

}
