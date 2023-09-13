package ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.mobility.util;


import ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.employee.Driver;

public abstract class Vehicle {
    // 'final'
    protected double maxFuelLevel;

    // variabel
    protected double curFuelLevel = 0;
    protected GPSPosition curPosition;
    protected Driver driver;
    protected boolean isMotorOn;

    public Vehicle(double maxFuelLevel) {
        setMaxFuelLevel(maxFuelLevel);
    }

    protected void setMaxFuelLevel(double maxFuelLevel) {
        this.maxFuelLevel = maxFuelLevel;
    }

    public void setPosition(GPSPosition curPosition) {
        if (curPosition == null) {
//			throw new IllegalArgumentException("Eine Position kann nicht leer sein");
            System.out.println(this.toString() + " GPS-Signal verloren!");
        }
        this.curPosition = curPosition;
    }

    public void setDriver(Driver driver) {
        if (!driver.getLicense().isValidForVehicle(this)) {
            System.out
                    .println("Der Fahrer " + driver + " darf leider kein Fahrzeug der Typen " + getType() + " fahren!");
            return;
        }
        if (driver != this.driver) {
            System.out.println(this.toString() + " Fahrer steigt aus.");
            if (isMotorOn) {
                System.out.println("Nat�rlich schaltet " + driver + " den Motor noch ab...");
                switchOff();
            }
        }
        this.driver = driver;
    }

    public double getMaxFuelLevel() {
        return maxFuelLevel;
    }

    public double getCurFuelLevel() {
        return curFuelLevel;
    }

    public GPSPosition getCurPosition() {
        if (curPosition == null)
            System.out.println("Leider wurde das GPS-Signal verloren. Der Wagen kann nicht geortet werden!");
        return curPosition;
    }

    public boolean isMotorOn() {
        return isMotorOn;
    }

    public double refuel(double liters) {
        if (liters < 0) {
            throw new IllegalArgumentException("Man kann keine negativen Werte tanken");
        }
        double overflow = 0;
        curFuelLevel += liters;
        if (curFuelLevel > maxFuelLevel) {
            overflow = curFuelLevel - maxFuelLevel;
            curFuelLevel = maxFuelLevel;
        }
        return overflow;
    }

    public void switchOn() {
        if (this.driver == null) {
            System.out.println("Es sitzt kein Fahrer im Auto. Niemand kann den Motor einschalten");
            return;
        }
        isMotorOn = true;
    }

    public void switchOff() {
        isMotorOn = false;
    }

    public void driveTo(GPSPosition pos) {

        /*
         * Frage: warum sollen wir hier Abfragen, ob der Tank leer ist? W�re er leer,
         * dann w�re automatisch auch der Motor aus...
         */

        if (curFuelLevel <= 0) {
            System.out.println("Der Tank ist leer und das Fahrzeug kann nicht fahren");
            return;
        } else if (driver == null) {
            System.out.println("Es sitzt kein Fahrer im Fahrzeug der es zu der Position " + pos + " steuern k�nnte...");
            return;
        } else if (isMotorOn == false) {
            System.out.println("Der Motor ist aus und das Fahrzeug bewegt sich nicht...");
            return;
        }
    }

    public void parkCar() {
        switchOff();
        setDriver(null);
    }

    @Override
    public String toString() {
//		return "[Fahrzeug: (Maximale Sitzanzahl:" + passengerSeatCount + " | Maximales Tankvolumen:" + maxFuelLevel + ")]";
        StringBuilder sb = new StringBuilder();
        sb.append("[Fahrzeug: ");
        sb.append("(Maximales Tankvolumen:" + maxFuelLevel + " | Position:" + curPosition + " | Motorstatus:"
                + isMotorOn + ")");
        sb.append("(Fahrer:" + driver + " | Tankinhalt:" + curFuelLevel + ")");
        sb.append("]");
        return sb.toString();
    }

    /**
     * Ermittelt die Auslastung des Fahrzeugs
     */
    public abstract double getUtilization();

    /**
     * Ermittelt den Fahrzeugtyp
     */
    public abstract VehicleType getType();
}
