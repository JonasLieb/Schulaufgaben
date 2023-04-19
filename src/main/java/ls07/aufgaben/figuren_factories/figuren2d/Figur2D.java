package ls07.aufgaben.figuren_factories.figuren2d;

public abstract class Figur2D {
	
	public Figur2D(double...itemsToBeChecked) {
		checkForValidEntry(itemsToBeChecked);
	}
	
	public abstract double umfang();

	public abstract double flaeche();

	protected void checkForValidEntry(double... items) {
		if (items == null) {
			throw new IllegalArgumentException("Zu prüfender Wert darf nicht null sein.");
		}
		for (double item : items) {
			if (item <= 0) {
				throw new IllegalArgumentException("Wert darf nicht negativ sein, ist aber: " + item);
			}
		}
	}
}