package ls07.aufgaben.mitarbeiter_csv;

import ls07.aufgaben.mitarbeiter_csv.employee.Employee;
import ls07.aufgaben.mitarbeiter_csv.employee.ShiftWorker;
import ls07.aufgaben.mitarbeiter_csv.mobility.util.Vehicle;

import java.util.ArrayList;


public class BusinessManagement {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Departement> departements = new ArrayList<>();

    // Durch diese Listen werden die Mitarbeiter Redundant und die Schichtarbeiter
    // sogar doppel redundant gespeichert. Das ist keine sinnvolle Aufteilung...
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<ShiftWorker> shiftWorkers = new ArrayList<>();

    public BusinessManagement() {

    }

    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
        }
    }

    public void addDepartement(Departement departement) {
        if (!departements.contains(departement)) {
            departements.add(departement);
        }
    }

    public void addEmployee(Employee employee, Departement departement) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
        if (employee instanceof ShiftWorker && !shiftWorkers.contains(employee)) {
            shiftWorkers.add((ShiftWorker) employee);
        }
        departement.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        for (Departement departement : departements) {
            if (departement.getEmployees().contains(employee)) {
                departement.getEmployees().remove(employee);
                break;
            }
        }
        if (employee instanceof ShiftWorker) {
            shiftWorkers.remove((ShiftWorker) employee);
        }
    }

    public void workOneDay() {
        for (ShiftWorker worker : shiftWorkers) {
            worker.work(8);
        }
    }

    public void workOneDay(ShiftWorker... workers) {
        for (ShiftWorker worker : workers) {
            worker.work(8);
        }
    }
}
