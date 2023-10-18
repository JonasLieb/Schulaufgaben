package ls11.aufgaben.mitarbeitergui.util.employee;


import ls11.aufgaben.mitarbeitergui.util.employee.mobility.util.DrivingLicense;
import ls11.aufgaben.mitarbeitergui.util.employee.mobility.util.GPSPosition;
import ls11.aufgaben.mitarbeitergui.util.employee.mobility.util.Vehicle;
import ls11.aufgaben.mitarbeitergui.util.annotations.ClassName;
import ls11.aufgaben.mitarbeitergui.util.annotations.EmployeeDialogCreatable;
import ls11.aufgaben.mitarbeitergui.util.annotations.ParameterName;

@ClassName(name = "Fahrer")
public class Driver extends ShiftWorker {

    // Instead of using a char to safe the driving license i want to create my own
    // Object for that. Like this it will be pretty easy to determine if the license
    // is valid for the given type of car
    @ParameterName(name = "Führerscheintyp")
    private DrivingLicense license;

    @EmployeeDialogCreatable(parameterNames = {"Name", "ID", "Stundensatz", "Führerscheinklassen (Aneinander geschrieben, nicht separiert)"})
    public Driver(String name, int id, double hourlyRate, String licenses /*die einzelnen Lizenz-Chars ohne Separator*/) {
        this(name, id, hourlyRate, new DrivingLicense(licenses.toCharArray()));
    }

    public Driver(String name, int id, double hourlyRate, char licenseClass) {
        this(name, id, hourlyRate, new DrivingLicense(licenseClass));
    }

    public Driver(String name, int id, double hourlyRate, DrivingLicense license) {
        super(name, id, hourlyRate);
        setDrivingLicense(license);
    }

    public Driver(){
        super();
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
