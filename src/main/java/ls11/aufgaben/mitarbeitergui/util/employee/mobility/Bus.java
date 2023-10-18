package ls11.aufgaben.mitarbeitergui.util.employee.mobility;


import ls11.aufgaben.mitarbeitergui.util.employee.Employee;
import ls11.aufgaben.mitarbeitergui.util.employee.mobility.util.VehicleType;

public class Bus extends PassengerTransportVehicle {

    public Bus(double maxFuelLevel, int passengerSeatCount, Employee[] employees) {
        super(maxFuelLevel, passengerSeatCount, employees);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BUS;
    }
}
