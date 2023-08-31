package ls07.aufgaben.mitarbeiter_csv.util;


import ls07.aufgaben.mitarbeiter_csv.BusinessManagement;
import ls07.aufgaben.mitarbeiter_csv.Departement;
import ls07.aufgaben.mitarbeiter_csv.employee.Manager;
import ls07.aufgaben.mitarbeiter_csv.employee.OfficeWorker;
import ls07.aufgaben.mitarbeiter_csv.employee.ShiftWorker;

public class Test {
	public static void main(String[] args) {
		ShiftWorker shiftWorkerUdo;
		ShiftWorker shiftWorkerMarvin;
		ShiftWorker shiftWorkerJan;
		ShiftWorker shiftWorkerStan;

		OfficeWorker officeWorkerFrank;
		OfficeWorker officeWorkerMartin;

		Manager managerManni;
		Manager managerStefan;

		// Problemf�lle:
		try {
			// Stundensatz <0
			shiftWorkerUdo = new ShiftWorker("Udo der Schichtarbeiter", 4012, -11.05);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			// Name leer
			officeWorkerFrank = new OfficeWorker("", 5111, 5050);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			// ID zu lang
			managerManni = new Manager("Manni der manager", 50000, 10000, .5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// echte F�lle
		shiftWorkerUdo = new ShiftWorker("Udo der Schichtarbeiter", 3001, 15.00);
		shiftWorkerMarvin = new ShiftWorker("Marvin der Schichtarbeiter", 3002, 7.05);
		shiftWorkerJan = new ShiftWorker("Marvin der Schichtarbeiter", 3003, 12.25);
		shiftWorkerStan = new ShiftWorker("Marvin der Schichtarbeiter", 3004, 13.00);

		officeWorkerFrank = new OfficeWorker("Frank der B�romitarbeiter", 5111, 4500);
		officeWorkerMartin = new OfficeWorker("Martin der B�romitarbeiter", 5112, 7000);

		managerManni = new Manager("Manni der Manager", 5000, .5, 10000);
		managerStefan = new Manager("Stefan der Manager", 5000, .5, 110000);

		// richtiger Aufruf
		Departement warehouse = new Departement("Lager", managerManni);

		Departement humanResources = new Departement("HR", managerStefan);

		BusinessManagement management = new BusinessManagement();
		management.addDepartement(warehouse);
		management.addDepartement(humanResources);

		management.addEmployee(shiftWorkerUdo, warehouse);
		management.addEmployee(shiftWorkerMarvin, warehouse);
		management.addEmployee(shiftWorkerJan, warehouse);
		management.addEmployee(shiftWorkerStan, warehouse);

		management.addEmployee(officeWorkerFrank, humanResources);
		management.addEmployee(officeWorkerMartin, humanResources);

		// Test Geh�lter
		System.out.println("\nGeh�lter Lager:\n" + warehouse.salaryList());
		System.out.println("\n\nDie arbeiter machen sich mal n�tzlich...");

		management.workOneDay(); // Achtung, hier sind AUCH alle potentiellen Zeitarbeiter der anderen
									// Abteilungen angesprochen!

		System.out.println("\nGeh�lter Lager:\n" + warehouse.salaryList());

		System.out.println("\nGeh�lter HR:\n" + humanResources.salaryList());
	}
}
