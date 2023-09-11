package ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.employee;

import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.util.MitarbeiterType;
import ls11.aufgaben.mitarbeitergui.util.swing.EmployeeDialogCreatable;

public class OfficeWorker extends Employee {
    // Laut der Regel "muss mit 5 beginnen" w�re hier auch MIN_ID = 5000 m�glich. Da
    // aber die IDs der Manager mit 50 anfangen und somit 5000 bis 5099 abdecken
    // fange ich hier bei 5100 an, um sp�ter abh�ngig von der ID herausfinden zu
    // k�nnen, welcher MA welcher Typ von MA ist. Au�erdem ist der Platz von 100
    // Managern bereits knapp bemessen und sollte nicht weiter verk�rzt werden indem
    // hier B�roarbeiter-IDs gespeichert werden...

    /**
     * Unteres Limit des zul�ssigen ID-Bereichs
     */
    private static final int MIN_ID = 5100;
    /**
     * Oberes Limit des zul�ssigen ID-Bereichs
     */
    private static final int MAX_ID = 5999;
    /**
     * Festgehalt des B�roarbeiters
     */
    protected double fixSalary = -1;

    @EmployeeDialogCreatable(parameterNames = {"Name", "ID", "Festgehalt"})
    public OfficeWorker(String name, int id, double festgehalt) {
        setName(name);
        setFestgehalt(festgehalt);
        setId(id);
    }

    protected void setFestgehalt(double festgehalt) {
        if (festgehalt < 0) {
            throw new IllegalArgumentException("Das Festgehalt eines Managers kann nicht negativ sein!");
        }
        this.fixSalary = festgehalt;
    }

    // Hier habe ich eine andere L�sung gew�hlt. Statt einer eigenen setID-Methode
    // habe ich mich dazu entschieden, die Pr�fung der ID in der Parent-Class
    // (Mitarbeiter) einzubauen und nur abh�ng von den Mitarbeitern eine Spannweite
    // der zul�ssigen IDs vorzugeben. Im Beispiel B�roarbeiter w�ren das 5000 oder
    // 5100 bis
    // 5999
//	@Override
//	protected void setId(int id) {
//		if (id < 0) {
//			throw new IllegalArgumentException("Die ID eines B�roarbeiters darf nicht negativ sein!");
//		}
//		if (id > 9999) {
//			throw new IllegalArgumentException("Die ID eines B�roarbeiters darf maximal vierstellig sein!");
//		}
//		if (id < 5100 || id > 5999) {
//			throw new IllegalArgumentException("Die ID eines B�roarbeiters muss mit 30 beginnen!");
//		}
//		this.id = id;
//	}

    @Override
    public double income() {
        return fixSalary;
    }

    @Override
    public MitarbeiterType getType() {
        return MitarbeiterType.OFFICE_WORKER;
    }

    @Override
    protected int getMinID() {
        return MIN_ID;
    }

    @Override
    protected int getMaxID() {
        return MAX_ID;
    }

    @Override
    protected String getCSVString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCSVString(this));
        sb.append(COLUMN_DELIMITER);
        sb.append(getCSVString(getName()));
        sb.append(COLUMN_DELIMITER);
        sb.append(getCSVString(getId()));
        sb.append(COLUMN_DELIMITER);
        sb.append(getCSVString(fixSalary));
        return sb.toString();
    }
}
