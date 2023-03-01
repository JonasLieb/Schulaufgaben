package ls05.aufgaben.mitarbeiter.mobility;


import ls05.aufgaben.mitarbeiter.employee.ShiftWorker;
import ls05.aufgaben.mitarbeiter.mobility.util.DrivingLicense;
import ls05.aufgaben.mitarbeiter.mobility.util.GPSPosition;
import ls05.aufgaben.mitarbeiter.mobility.util.Vehicle;

public class Driver extends ShiftWorker {

    // Instead of using a char to safe the driving license i want to create my own
    // Object for that. Like this it will be pretty easy to determine if the license
    // is valid for the given type of car
    private DrivingLicense license;

    public Driver(String name, int id, double hourlyRate, char licenseClass) {
        this(name, id, hourlyRate, new DrivingLicense(licenseClass));
    }

    public Driver(String name, int id, double hourlyRate, DrivingLicense license) {
        super(name, id, hourlyRate);
        setDrivingLicense(license);
    }

    private void setDrivingLicense(DrivingLicense license) {
        this.license = license;
    }

    public DrivingLicense getLicense() {
        return license;
    }

    public void driveTo(Vehicle c, GPSPosition pos) {
        // TODO
    }

}
