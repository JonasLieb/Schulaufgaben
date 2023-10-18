package ls11.aufgaben.mitarbeitergui.util.employee.mobility.util;

import java.util.Arrays;

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

	public String toString(){
		return Arrays.toString(types);
	}
}
