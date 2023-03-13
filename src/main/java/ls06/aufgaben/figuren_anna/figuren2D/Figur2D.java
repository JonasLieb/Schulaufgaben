package ls06.aufgaben.figuren_anna.figuren2D;

public abstract class Figur2D {
	
	public Figur2D(double...itemsToBeChecked) {
		CheckForValidEntry(itemsToBeChecked);
	}
	
	public abstract double Umfang();

	public abstract double Flaeche();

	protected void CheckForValidEntry(double... items) {
		if (items == null) {
			throw new IllegalArgumentException("Zu pr�fender Wert darf nicht null sein.");
		}
		for (double item : items) {
			if (item <= 0) {
				throw new IllegalArgumentException("Wert darf nicht negativ sein, ist aber: " + item);
			}
		}
	}
}