package ls11.aufgaben.mitarbeitergui.util.employe.mitarbeiter_csv.employee;

import ls11.aufgaben.mitarbeitergui.util.employe.mitarbeiter_csv.util.MitarbeiterType;
import ls11.aufgaben.mitarbeitergui.util.annotations.ParameterName;
import ls11.aufgaben.mitarbeitergui.util.csv.CSVDataHandler;

import java.lang.reflect.Field;
import java.util.Arrays;


/*
 * AUFGABE:
 *
 * � Die Software soll je nach Mitarbeitertyp die Geh�lter unterschiedlich
 * bestimmen k�nnen. Schichtarbeiter werden nach Stunden und Stundensatz
 * bezahlt. B�roarbeiter erhalten ein Festgehalt. Manager erhalten neben einem
 * Festgehalt auch einen Bonus, abh�ngig von einem individuell vereinbarten
 * Prozentsatz.
 *
 * � IDs werden einmalig erstellt und unterliegen bestimmten Regeln: Mitarbeiter
 * IDs sind immer positiv und vierstellig. Schichtarbeiter IDs sind positiv,
 * vierstellig und beginnen mit der Ziffer 3. B�roarbeiter IDs sind positiv,
 * vierstellig und beginnen mit 5. Manager IDs sind positiv, vierstellig und
 * beginnen mit 50.
 *
 * � Eine Verwaltung der Mitarbeiter soll in der Lage sein, Eine Gehaltsliste
 * mit abschlie�ender Gehaltssumme zu erstellen. Neue Mitarbeiter einzustellen
 * und Mitarbeiter zu entlassen.
 *
 */

public abstract class Employee {
    public static final String COLUMN_DELIMITER = ";";
    @ParameterName(name = "ID")
    protected int id;
    @ParameterName(name = "Name")
    protected String name;

    /**
     * Ermittelt die Minimale ID des Mitarbeiters
     *
     * @return die tiefstm�gliche ID
     */
    protected abstract int getMinID();

    /**
     * Ermittelt die Maximale ID des Mitarbeiters
     *
     * @return die h�chstm�gliche ID
     */
    protected abstract int getMaxID();

    /**
     * Ermittelt das Einkommen des Mitarbeiters
     *
     * @return das Einkommen des Mitarbeiters
     */
    public abstract double income();

    /**
     * Ermittelt den Typen des Mitarbeiters
     *
     * @return den Typ des Mitarbeiters
     */
    public abstract MitarbeiterType getType();

    /**
     * Setzt die ID f�r den Mitarbeiter
     *
     * @param id die ID, die gesetzt werden soll
     */
    protected void setId(int id) {
        // Die Pr�fung f�r 0 / 9999 w�re theoretisch nicht n�tig, macht die
        // ausgegebene Fehlermeldung jedoch vielleicht etwas sprechender
        if (id < 0) {
            throw new IllegalArgumentException(
                    "Die ID '" + id + "' ist f�r keinen Mitarbeiter zul�ssig. Jede ID muss positiv sein!");
        }
        if (id > 9999) {
            throw new IllegalArgumentException(
                    "Die ID '" + id + "' ist f�r keinen Mitarbeiter zul�ssig. Jede ID ist maximal vierstellig!");
        }
        if (id < getMinID() || id > getMaxID()) {
            throw new IllegalArgumentException("Die ID eines Mitarbeiters des Typen \"" + getType()
                    + "\" muss zwischen " + getMinID() + " und " + getMaxID() + "liegen!");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    protected void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Der Name eines Mitarbeiters darf nicht leer sein");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | ID: " + id + " | Typ: " + getType();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee ma = (Employee) o;
        if (name.equals(ma.name) && ma.getId() == id) {
            return true;
        }
        return false;
    }

    public final String getCSVString() {
        //Einzelne Felder finden
        Field[] fields = CSVDataHandler.getNonConstantFields(getClass());

        //Späteres Format: [Klasse];[parm1],[parm2],[parm3]...

        //String bauen
        StringBuilder sb = new StringBuilder(getClass().getName());
        for (int i = 0; i < fields.length; i++) {
            sb.append(COLUMN_DELIMITER);
            boolean shouldBeAccessible = fields[i].isAccessible();
            fields[i].setAccessible(true);
            try {
                sb.append(fields[i].get(this));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            fields[i].setAccessible(shouldBeAccessible);
        }
        return sb.toString();
    }

    public static Employee getEmployeeFromCSVString(String input) throws Exception {
        if(input == null || input.isEmpty())return null;
        String[] vals = input.split(COLUMN_DELIMITER);
        Class<? extends Employee> c = (Class<? extends Employee>) Class.forName(vals[0]);
        vals = Arrays.copyOfRange(vals, 1, vals.length);
        return CSVDataHandler.getFilledObject(c, vals);
    }
}