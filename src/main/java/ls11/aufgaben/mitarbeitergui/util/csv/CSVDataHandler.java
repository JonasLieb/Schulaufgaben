package ls11.aufgaben.mitarbeitergui.util.csv;

import ls11.aufgaben.mitarbeitergui.util.employee.mobility.util.DrivingLicense;

import java.lang.reflect.*;
import java.util.Arrays;

public class CSVDataHandler {

    public static <T> T getFilledObject(Class<T> clazz, String[] data) throws Exception {
        Field[] fields = getNonConstantFields(clazz);
        if (fields == null) fields = new Field[0];
        if (fields.length != data.length)
            throw new IllegalArgumentException("CSV-Daten \"" + Arrays.toString(data) + "\" passen nicht auf das Objekt \"" + clazz.getName() + "\"!");

        Constructor<T> constructor;
        try {
            constructor = clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            //Hier soll eine gescheite Message ausgegeben werden -> Exception throw in Catch
            throw new Exception("Eine CSV-initialisierbare Klasse benötigt einen leeren Konstruktor!");
        }
        T instance = constructor.newInstance();
        for (int i = 0; i < fields.length; i++) {
            try {
                boolean shouldBeAccessible = fields[i].isAccessible();
                fields[i].setAccessible(true);
                fields[i].set(instance, getObjectFromString(fields[i], data[i]));
                fields[i].setAccessible(shouldBeAccessible);
            } catch (Exception e) {
                throw new RuntimeException("Feld \"" + fields[i] + "\"konnte nicht gefüllt werden! Mitarbeiter wird nicht verarbeitet.");
            }
        }
        return instance;
    }

    public static Object getObjectFromString(Field p, String value) {
        String typeName = p.getType().getName();
        value = value.trim();
        //Integer
        if (typeName.equalsIgnoreCase("INT") || typeName.equalsIgnoreCase(Integer.class.getName()))
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return 0;
            }

        //Short
        if (typeName.equalsIgnoreCase("SHORT") || typeName.equalsIgnoreCase(Short.class.getName()))
            try {
                return Short.parseShort(value);
            } catch (NumberFormatException e) {
                return (short) 0;
            }

        //Long
        if (typeName.equalsIgnoreCase("LONG") || typeName.equalsIgnoreCase(Long.class.getName()))
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException e) {
                return 0L;
            }

        //Float
        if (typeName.equalsIgnoreCase("FLOAT") || typeName.equalsIgnoreCase(Float.class.getName()))
            try {
                return Float.parseFloat(value);
            } catch (NumberFormatException e) {
                return 0F;
            }

        //Double
        if (typeName.equalsIgnoreCase("DOUBLE") || typeName.equalsIgnoreCase(Double.class.getName()))
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                return 0D;
            }

        //Boolean
        if (typeName.equalsIgnoreCase("BOOLEAN") || typeName.equalsIgnoreCase(Boolean.class.getName()))
            try {
                return Boolean.parseBoolean(value);
            } catch (NumberFormatException e) {
                return false;
            }

        //Character
        if (typeName.equalsIgnoreCase("CHAR") || typeName.equalsIgnoreCase(Character.class.getName()))
            return value.charAt(0);

        //String
        if (typeName.equalsIgnoreCase(String.class.getName()))
            return value;

        //DrivingLicense
        if (typeName.equalsIgnoreCase(DrivingLicense.class.getName())) {
            String[] vals = value.replace("[", "").replace("]", "").replace(" ", "").split(",");
            char[] chars = new char[vals.length];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = vals[i].charAt(0);
            }
            return new DrivingLicense(chars);
        }

        throw new RuntimeException("Type nicht unterstützt: " + typeName);
    }


    public static Field[] getNonConstantFields(Class<?> clazz) {
        //1. bin ich noch eine passende Klasse? Falls nein return
        if (!Object.class.isAssignableFrom(clazz)) return null;

        //2. Ich bin eine passende Klasse -> Felder der höheren Klassen holen, meine anhängen
        Class<?> parent = clazz.getSuperclass();
        Field[] additionalFields = (parent == null) ? null : getNonConstantFields(parent);
        Field[] myFields = Arrays.stream(clazz.getDeclaredFields()).filter(CSVDataHandler::isNotStaticFinal).toArray(Field[]::new);
        return concatenate(additionalFields, myFields);
    }

    private static <T> T[] concatenate(T[] a, T[] b) {
        if (a == null && b == null) return null;
        else if (a == null) return b;
        else if (b == null) return a;

        int aLen = a.length;
        int bLen = b.length;
        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    private static boolean isNotStaticFinal(Field field) {
        return !isStaticFinal(field);
    }

    private static boolean isStaticFinal(Field field) {
        int modifiers = field.getModifiers();
        return (Modifier.isStatic(modifiers) && Modifier
                .isFinal(modifiers));
    }
}
