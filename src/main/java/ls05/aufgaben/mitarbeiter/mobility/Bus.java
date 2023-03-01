package ls05.aufgaben.mitarbeiter.mobility;


import ls05.aufgaben.mitarbeiter.employee.Employee;
import ls05.aufgaben.mitarbeiter.mobility.util.VehicleType;

public class Bus extends PassengerTransportVehicle {

    public Bus(double maxFuelLevel, int passengerSeatCount, Employee[] employees) {
        super(maxFuelLevel, passengerSeatCount, employees);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BUS;
    }
}
