package ls07.aufgaben.mitarbeiter_csv.employee;

import ls07.aufgaben.mitarbeiter_csv.util.MitarbeiterType;
import ls07.aufgaben.mitarbeiter_csv.util.exceptions.MissingArgumentException;

import java.io.FileWriter;

public class Manager extends OfficeWorker {
    /**
     * Unteres Limit des zul�ssigen ID-Bereichs
     */
    private static final int MIN_ID = 5000;
    /**
     * Oberes Limit des zul�ssigen ID-Bereichs
     */
    private static final int MAX_ID = 5099;
    /**
     * Prozentsatz des Managers
     */
    private double percentage = -1;

    public Manager(String name, int id, double festgehalt, double prozentsatz) {
        super(name, id, festgehalt);
        setPercentage(prozentsatz);
    }

    // Hier habe ich eine andere L�sung gew�hlt. Statt einer eigenen setID-Methode
    // habe ich mich dazu entschieden, die Pr�fung der ID in der Parent-Class
    // (Mitarbeiter) einzubauen und nur abh�ng von den Mitarbeitern eine Spannweite
    // der zul�ssigen IDs vorzugeben. Im Beispiel Manager w�ren das 5000 bis 5099
//	@Override
//	protected void setId(int id) {
//		if (id < 0) {
//			throw new IllegalArgumentException("Die ID eines Managers darf nicht negativ sein!");
//		}
//		if (id > 9999) {
//			throw new IllegalArgumentException("Die ID eines Managers darf maximal vierstellig sein!");
//		}
//		if (id < 5000 || id > 5099) {
//			throw new IllegalArgumentException("Die ID eines Managers muss mit 30 beginnen!");
//		}
//		this.id = id;
//	}

    private void setPercentage(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Der Prozentsatz eines Managers kann nicht negativ sein!");
        }
        this.percentage = percentage;
    }

    @Override
    public double income() {
        if (fixSalary == -1 || percentage == -1) {
            throw new MissingArgumentException(
                    "Das Festgehalt oder der Prozentsatz des Managers wurden noch nicht gesetzt!");
        }
        return fixSalary + fixSalary * percentage;
    }

    @Override
    public MitarbeiterType getType() {
        return MitarbeiterType.MANAGER;
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
        sb.append(COLUMN_DELIMITER);
        sb.append(getCSVString(percentage));
        return sb.toString();
    }
}
