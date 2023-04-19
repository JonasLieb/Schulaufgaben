package ls06.aufgaben.figuren_generics.pricecalculation;


import ls06.aufgaben.figuren_generics.figuren3d.Figur3D;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;

public class PriceCalculator {
    private CSVReader stuffingPriceReader;
    private CSVReader surfacePriceReader;
    private ClassLoader loader;

    public PriceCalculator() {
        loader = getClass().getClassLoader();
        try {
            stuffingPriceReader = new CSVReader(getClass().getResource("Material_Pricing_Stuffing.csv"), ';');
            surfacePriceReader = new CSVReader(getClass().getResource("Material_Pricing_Surface.csv"), '\t');
        } catch (Exception e) {
            System.out.println("Dateien konnten nicht eingelesen werden. Preisermittlung nicht möglich.");
        }
    }


    public double calculatePrice(Figur3D shape, String stuffingName, String surfaceName) {
        double stuffingPrice;
        double surfacePrice;

        stuffingPrice = getStuffingPrice(stuffingName);
        surfacePrice = getSurfacePrice(surfaceName);
        if (stuffingPrice == -1 || surfacePrice == -1)
            throw new RuntimeException("Fehler bei der Berechnung des Gesamtpreises. Der Preis ist in der Preisliste wahrscheinlich nicht hinterlegt.");
        return stuffingPrice * shape.volumen() + surfacePrice * shape.oberflaeche();
    }

    private double getStuffingPrice(final String name) {
        return getPrice(stuffingPriceReader, name);
    }

    private double getSurfacePrice(final String name) {
        return getPrice(surfacePriceReader, name);
    }

    private double getPrice(CSVReader reader, final String name) {
        String ret = "";
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Der Name darf nie leer oder null sein");
        for (CSVReader.Row r : reader.getContent()) {
            if (r.content.length < 2) continue;
            if (name.equals(r.content[0])) {
                ret = r.content[1];
            }
        }

        try {
            return Double.parseDouble(ret.trim());
        } catch (Exception e) {
            return -1;
        }

    }

//    public double calculatePrice(Figur3D shape, String stuffingName, String surfaceName) {
//        double stuffingPrice;
//        try {
//            stuffingPrice = getPrice(stuffingName, ';', getClass().getResource("Material_Pricing_Stuffing.csv"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("Der Preis des Objektes konnte nicht ermittelt werden."); //Hier sollte eine passendere Fehlerbehandlung gefunden werden
//        }
//        if (stuffingPrice <= 0) {
//            throw new IllegalArgumentException("Der Preis des Objektes konnte nicht ermittelt werden.");
//        }
//
//        double surfacePrice;
//        try {
//            surfacePrice = getPrice(surfaceName, '\t', getClass().getResource("Material_Pricing_Surface.csv"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("Der Preis des Objektes konnte nicht ermittelt werden."); //Hier sollte eine passendere Fehlerbehandlung gefunden werden
//        }
//        if (surfacePrice <= 0) {
//            throw new IllegalArgumentException("Der Preis des Objektes konnte nicht ermittelt werden.");
//        }
//
//        return stuffingPrice * shape.volumen() + surfacePrice * shape.oberflaeche();
//    }
//
//
//    private double getPrice(String name, char columnSeperator, URL url) throws FileNotFoundException {
//        File file = new File(url.getFile());
//        ArrayList<CSVReader.Row> content = CSVReader.getContent(file, columnSeperator);
//        name = name.trim().toUpperCase();
//        for (CSVReader.Row row : content) {
//            String col = row.getCol(0).trim().toUpperCase();
//            if (name.equals(col)) {
//                return Double.parseDouble(row.getCol(1));
//            }
//        }
//        return -1;
//    }
}
