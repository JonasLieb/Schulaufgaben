package ls05.aufgaben.mitarbeiter.employee;


import ls05.aufgaben.mitarbeiter.util.MitarbeiterType;
import ls05.aufgaben.mitarbeiter.util.exceptions.MissingArgumentException;

public class ShiftWorker extends Employee {
    /**
     * Unteres Limit des zul�ssigen ID-Bereichs
     */
    private static final int MIN_ID = 3000;
    /**
     * Oberes Limit des zul�ssigen ID-Bereichs
     */
    private static final int MAX_ID = 3099;
    /**
     * Stundensatz des Arbeiters
     */
    private double hourlyRate;
    /**
     * Anzahl der bisher abgeleisteten Stunden
     */
    private int hourCount;

    public ShiftWorker(String name, int id, double hourlyRate) {
        setName(name);
        setHourlyRate(hourlyRate);
        setId(id);
    }

    protected void setHourCount(int hourCount) {
        if (hourCount < 0) {
            throw new IllegalArgumentException("Die Stundenanzahl kann nicht negativ sein!");
        }
        this.hourCount = hourCount;
    }

    protected void setHourlyRate(double stundenSatz) {
        this.hourlyRate = stundenSatz;
    }

    // Hier habe ich eine andere L�sung gew�hlt. Statt einer eigenen setID-Methode
    // habe ich mich dazu entschieden, die Pr�fung der ID in der Parent-Class
    // (Mitarbeiter) einzubauen und nur abh�ng von den Mitarbeitern eine Spannweite
    // der zul�ssigen IDs vorzugeben. Im Beispiel Schichtarbeiter w�ren das 3000 bis
    // 3999
//	@Override
//	protected void setId(int id) {
//		if (id < 0) {
//			throw new IllegalArgumentException("Die ID eines Schichtarbeiters darf nicht negativ sein!");
//		}
//		if (id > 9999) {
//			throw new IllegalArgumentException("Die ID eines Schichtarbeiters darf maximal vierstellig sein!");
//		}
//		if (id < 3000 || id > 3099) {
//			throw new IllegalArgumentException("Die ID eines Schichtarbeiters muss mit 30 beginnen!");
//		}
//		this.id = id;
//	}

    @Override
    public double income() {
        if (hourCount == -1 || hourlyRate == -1) {
            throw new MissingArgumentException(
                    "Die Stundenanzahl oder der Stundensatz des Schichtarbeiters wurden noch nicht gesetzt.");
        }
        return hourCount * hourlyRate;
    }

    public void work(int anzahlStunden) {
        if (anzahlStunden < 0) {
            throw new IllegalArgumentException("Es kann blo� eine positive Anzahl von Stunden gearbeitet werden");
        }
        setHourCount(this.hourCount + anzahlStunden);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHourCount() {
        return hourCount;
    }

    @Override
    public MitarbeiterType getType() {
        return MitarbeiterType.SHIFT_WORKER;
    }

    @Override
    protected int getMinID() {
        return MIN_ID;
    }

    @Override
    protected int getMaxID() {
        return MAX_ID;
    }
}
