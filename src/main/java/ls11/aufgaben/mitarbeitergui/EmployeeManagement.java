package ls11.aufgaben.mitarbeitergui;


import ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.employee.Employee;
import ls11.aufgaben.mitarbeitergui.util.employees.mitarbeiter_csv.employee.ShiftWorker;

import java.util.ArrayList;

public class EmployeeManagement {
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<ShiftWorker> shiftWorkers = new ArrayList<>();


    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
        if (employee instanceof ShiftWorker && !shiftWorkers.contains(employee)) {
            shiftWorkers.add((ShiftWorker) employee);
        }
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        if (employee instanceof ShiftWorker) {
            shiftWorkers.remove((ShiftWorker) employee);
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<ShiftWorker> getShiftWorkers() {
        return shiftWorkers;
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
