package ls09.aufgaben.legokompositum.util;

import java.lang.reflect.Field;

/**
 * Genau wie LegoBauteil nur mit fertiger toString methode
 */
public abstract class LegoBauteilAutoToString {
    /**
     * gibt den Preis des Bauteils zurück. Jedes Bauteil berechnet seinen Preis auf eigene Art und Weise.
     *
     * @return den Gesamtpreis des Bauteils
     */
    public abstract double preis();

    @Override
    public String toString() {
        Class<? extends LegoBauteilAutoToString> c = getClass();
        Field[] fields = c.getFields();

        StringBuilder sb = new StringBuilder(getClass().getName() + ":[");
        String name;
        Object value;
        for (int i = 0; i < fields.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            Field f = fields[i];

            name = f.getName();
            try {
                value = f.get(this);
            } catch (Exception e) {
                value = null;
            }
            sb.append(name);
            sb.append(":");
            sb.append(value);
        }
        sb.append("]");
        return sb.toString();
    }
}

