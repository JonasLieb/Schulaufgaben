package ls07.aufgaben.figuren_factories;

import ls07.aufgaben.figuren_factories.figuren2d.Figur2D;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.stream.Stream;

public class FigurenFactory {

    private static final char COLUMN_DELIMITER = ';';

//    public static Figur2D getFigur2D(String fromLine) throws ClassNotFoundException {
//        String[] cols = fromLine.split(String.valueOf(COLUMN_DELIMITER));
//        if (cols.length < 2)
//            throw new IllegalArgumentException("Mitgegebene Zeile hat nicht ausreichend viele parameter");
//
//        String classPathAndName = cols[0];
//        Class<Figur2D> clazz = (Class<Figur2D>) Class.forName(classPathAndName);
//
//        String[] values = new String[cols.length - 1];
//        System.arraycopy(cols, 1, values, 0, cols.length - 1);
//        return reflect(clazz, values);
//    }

//    public static <T extends Figur2D> T reflect(Class<T> clazz, String[] vals) {
//        //Richtigen Konstruktor ermitteln
//        Constructor<?>[] Constructors = clazz.getConstructors();
//        int num;
//        try {
//            num = Integer.parseInt(vals[0]);
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("Der Index des zu nutzende Konstruktors ist nicht definiert: " + vals[0])
//        }
//        Object[] parms = new Object[vals.length - 1];
//
//        //parms abhängig von dem ausgefehlten Konstruktor füllen
//
//
//        Constructors[num].newInstance()
//    }

}
