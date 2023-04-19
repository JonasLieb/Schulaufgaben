package ls06.aufgaben.generics_test;


import ls05.aufgaben.mitarbeiter.employee.Employee;
import ls05.aufgaben.mitarbeiter.employee.Manager;
import ls05.aufgaben.mitarbeiter.employee.OfficeWorker;
import ls05.aufgaben.mitarbeiter.employee.ShiftWorker;

import java.util.*;

public class test {
    public static void main(String[] args) {

        OfficeWorker officeWorker = new OfficeWorker("Günter", 5200, 10000);
        ShiftWorker shiftWorker = new ShiftWorker("Günter", 3001, 10);
        Manager manager = new Manager("Günter", 5000, 10, .5);

        Set<Employee> setMitarbeiter = new TreeSet<Employee>();//BueroArbeiter, SchichtArbeiter und Managers hinzufügen
        try {
            setMitarbeiter.add(officeWorker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            setMitarbeiter.add(shiftWorker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            setMitarbeiter.add(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }


// Not Compilable
//        ArrayList<Employee> arrListMitarbeiter = new ArrayList<ShiftWorker>();//BueroArbeiter, SchichtArbeiter und Managers hinzufügen
//        try {
//            arrListMitarbeiter.add(officeWorker);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            arrListMitarbeiter.add(shiftWorker);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            arrListMitarbeiter.add(manager);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        List<Employee> listMitarbeiter = new ArrayList<Employee>(); //BueroArbeiter, SchichtArbeiter und Managers hinzufügen
        try {
            listMitarbeiter.add(officeWorker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            listMitarbeiter.add(shiftWorker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            listMitarbeiter.add(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }

// Not Compilable
//        LinkedList<OfficeWorker> liliBueroArbeiter = new LinkedList<Manager>(); //BueroArbeiter und Managers hinzufügen
//        try {
//            liliBueroArbeiter.add(officeWorker);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            liliBueroArbeiter.add(manager);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        List<OfficeWorker> listBueroArbeiter = new LinkedList<OfficeWorker>(); //BueroArbeiter und Managers hinzufügen
        try {
            listBueroArbeiter.add(officeWorker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            listBueroArbeiter.add(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
