package ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.mobility;


import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.mobility.util.Vehicle;
import ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.mobility.util.VehicleType;

public class Truck extends Vehicle {

    private double maxLoadingArea;
    private double curLoadingArea;

    public Truck(double maxFuelLevel, double max, double maxLoadingArea) {
        super(maxFuelLevel);
        setMaxLoadingArea(maxLoadingArea);
    }

    private void setMaxLoadingArea(double maxLoadingArea) {
        if (maxLoadingArea < 0) {
            throw new IllegalArgumentException("Die Ladefl�che kann nicht leer sein!");
        }
        this.maxLoadingArea = maxLoadingArea;
    }

    public void load(double area) {
        if (curLoadingArea + area > maxLoadingArea) {
            throw new IllegalArgumentException("Diese Fl�che passt nicht mehr auf den Laster!");
        }
    }

    // Hier gebe ich den echt entladenen Wert zur�ck
    public double unload(double area) {
        double ret;
        if (curLoadingArea < area) {
            System.out.println("Es k�nnen maximal " + curLoadingArea + " m� entladen werden.");
            ret = curLoadingArea;
            curLoadingArea = 0;
        } else {
            ret = area;
            curLoadingArea -= area;
        }
        return ret;
    }

    @Override
    public double getUtilization() {
        return curLoadingArea / maxLoadingArea;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

}
