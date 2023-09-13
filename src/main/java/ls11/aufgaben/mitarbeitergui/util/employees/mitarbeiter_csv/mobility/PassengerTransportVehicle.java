package ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.mobility;

import ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.employee.Employee;
import ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.mobility.util.Vehicle;
import ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.mobility.util.VehicleType;

import java.util.Arrays;


public class PassengerTransportVehicle extends Vehicle {

    private Employee[] passengers;
    protected int passengerSeatCount;

    public PassengerTransportVehicle(double maxFuelLevel, int passengerSeatCount, Employee... employees) {
        super(maxFuelLevel);
        setPassengerSeatCount(passengerSeatCount);
        passengers = new Employee[this.passengerSeatCount];
        addAllPassengers(employees);
    }

    protected void setPassengerSeatCount(int passengerSeatCount) {
        if (passengerSeatCount < 0) {
            throw new IllegalArgumentException("Ein Fahrzeug hat immer mindestens einen Sitz");
        }
        this.passengerSeatCount = passengerSeatCount;
    }

    public int getPassengerSeatCount() {
        return passengerSeatCount;
    }

    public void addAllPassengers(Employee... employees) {
        if (employees == null || employees.length == 0) {
            return;
        }
        Arrays.stream(employees).forEach(this::addSinglePassenger);
    }

    public void addSinglePassenger(Employee employee) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = employee;
                return;
            }
        }
        System.out.println("Das Fahrzeug is voll und der Mitarbeiter " + employee + " kann leider nicht mit fahren...");
    }

    public void removePassenger(int seatNum) {
        if (seatNum > passengers.length - 1) {
            throw new IllegalArgumentException("Der Sitz " + seatNum + " ist unzul�ssig!");
        }
        passengers[seatNum] = null;
    }

    @Override
    public void parkCar() {
        super.parkCar();
        this.passengers = new Employee[passengers.length]; // Alle steigen aus...
    }

    @Override
    public double getUtilization() {
        int count = 0;
        for (Employee e : passengers) {
            if (e != null)
                count++;
        }
        return count / passengerSeatCount;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.PASSENGER_CAR;
    }

}
