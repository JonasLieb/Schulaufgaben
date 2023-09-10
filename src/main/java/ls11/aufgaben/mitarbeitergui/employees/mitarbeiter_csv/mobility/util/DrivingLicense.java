package ls11.aufgaben.mitarbeitergui.employees.mitarbeiter_csv.mobility.util;

public class DrivingLicense {
	private char[] types;

	public DrivingLicense(char... types) {
		setTypes(types);
	}

	private void setTypes(char[] types) {
		this.types = types;
	}

	public char[] getType() {
		return types;
	}

	public boolean isValidForVehicle(Vehicle vehicle) {
		VehicleType type = vehicle.getType();
		for (char c : types)
			if (type.isValidType(c))
				return true;
		return false;
	}
}
