package ls11.aufgaben.mitarbeitergui.util.employe.mitarbeiter_csv.mobility;


import ls11.aufgaben.mitarbeitergui.util.employe.mitarbeiter_csv.employee.Employee;
import ls11.aufgaben.mitarbeitergui.util.employe.mitarbeiter_csv.mobility.util.VehicleType;

public class Bus extends PassengerTransportVehicle {

    public Bus(double maxFuelLevel, int passengerSeatCount, Employee[] employees) {
        super(maxFuelLevel, passengerSeatCount, employees);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BUS;
    }
}
