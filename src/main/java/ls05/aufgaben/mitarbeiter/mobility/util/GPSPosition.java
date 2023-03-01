package ls05.aufgaben.mitarbeiter.mobility.util;

public class GPSPosition {
	private double longtitude;
	private double latitude;

	public void setLongtitude(double d) {
		if (d < 0) {
			throw new IllegalArgumentException("Der L�ngengrad kann nicht kleiner als 0 sein!");
		}
		// Here we can use our value %360
		this.longtitude = d % 360;
	}

	public void setLatitude(double d) {
		// Here we can use our value %90
		this.latitude = d % 90;
	}

	private double getLongtitude() {
		return longtitude;
	}

	private double getLatitude() {
		return latitude;
	}
}
