package ls07.aufgaben.mitarbeiter_csv;

import ls07.aufgaben.mitarbeiter_csv.employee.Employee;
import ls07.aufgaben.mitarbeiter_csv.employee.Manager;

import java.util.ArrayList;


/**
 * Definiert eine Abteilung einer Firma wie beispielsweise die Personalabteilung
 * 
 * @author Jonas Lieben
 *
 */
public class Departement {
	/**
	 * Der Name der Abteilung
	 */
	private String name;
	/**
	 * Die zur Zeit vorhandenen Mitarbeiter der Abteilung
	 */
	private ArrayList<Employee> employees = new ArrayList<>();
	/**
	 * der jetzige Leiter der Abteilung
	 */
	private Manager leiter;

	public Departement(String name, Manager leiter) {
		setName(name);
		changeLeiter(leiter);
	}

	private void changeLeiter(Manager leiter) {
		if (leiter == null) {
			throw new IllegalArgumentException("Der neue Leiter kann nicht leer sein!");
		}
		// Fehler abfangen: Ein Mitarbeiter kann nicht MA und Leiter sein, sonst w�rde
		// es bei der Gehaltsliste zu einer Verf�lschung kommen!
		if (employees.contains(leiter)) {
			System.out.println("Der Mitarbeiter wird aus den Mitarbeitern entfernt und zum Abteilungsleiter gemacht!");
			employees.remove(leiter);
		}
		this.leiter = leiter;
	}

	public Manager getManager() {
		return leiter;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	private void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Der Name einer Abteilung darf nicht leer sein");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void add(Employee neuer) {
		if (leiter.equals(neuer)) {
			throw new IllegalArgumentException("Der Mitarbeiter ist der Leiter dieser Abteilung!");
		}
		if (employees.contains(neuer)) {
			throw new IllegalArgumentException("Der Mitarbeiter ist in der Abteilung bereits enthalten!");
		}
		employees.add(neuer);
	}

	public void remove(Employee welcher) {
		employees.remove(welcher);
	}

	/**
	 * Baut eine Auflistung der Geh�lter der Mitarbeiter (und des Leiters)
	 * 
	 * @return liste in Form eines Strings
	 */
	public String salaryList() {
		String list = leiter + " Gehalt: " + leiter.income() + " (Abteilungsleiter)\n";
		double betrag = leiter.income();
		for (Employee m : employees) {
			list += m + " Gehalt: " + m.income() + "\n";
			betrag += m.income();
		}
		list += "\nGesamt: " + betrag;
		return list;
	}
}
