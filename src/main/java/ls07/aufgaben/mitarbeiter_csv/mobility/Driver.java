package ls07.aufgaben.mitarbeiter_csv.mobility;


import ls07.aufgaben.mitarbeiter_csv.employee.ShiftWorker;
import ls07.aufgaben.mitarbeiter_csv.mobility.util.DrivingLicense;
import ls07.aufgaben.mitarbeiter_csv.mobility.util.GPSPosition;
import ls07.aufgaben.mitarbeiter_csv.mobility.util.Vehicle;

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
