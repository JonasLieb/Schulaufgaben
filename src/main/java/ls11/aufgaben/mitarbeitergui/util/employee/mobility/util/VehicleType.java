package ls11.aufgaben.mitarbeitergui.util.employee.mobility.util;

public class VehicleType {
	public static final VehicleType PASSENGER_CAR = new VehicleType('B', 'D');
	public static final VehicleType BUS = new VehicleType('D');
	public static final VehicleType TRUCK = new VehicleType('C');

	char[] validLicenseTypes;

	public VehicleType(char... validLicenseTypes) {
		setValidLicenseTypes(validLicenseTypes);
	}

	private void setValidLicenseTypes(char[] validLicenseTypes) {
		for (int i = 0, j = i; i < validLicenseTypes.length; i++, j += 2) {
			// Man k�nnte auch eingach immer toUpperCase machen, dann m�sste man aber bei
			// jeder Abfrage daran denken...
			this.validLicenseTypes[j] = Character.toLowerCase(validLicenseTypes[i]);
			this.validLicenseTypes[j + 1] = Character.toUpperCase(validLicenseTypes[i]);
		}
	}

	public boolean isValidType(char licenseType) {
		for (char c : validLicenseTypes) {
			if (c == licenseType) {
				return true;
			}
		}
		return false;
	}

}
