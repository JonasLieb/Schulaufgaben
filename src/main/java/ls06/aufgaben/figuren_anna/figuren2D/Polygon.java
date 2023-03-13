package ls06.aufgaben.figuren_anna.figuren2D;

public class Polygon extends Figur2D {

	private int anzahlSeiten;
	private double seiteLaenge;

	public Polygon(int anzahlSeiten, double seiteLaenge) {
		super(anzahlSeiten, seiteLaenge);
		this.anzahlSeiten = anzahlSeiten;
		this.seiteLaenge = seiteLaenge;
	}

	@Override
	public double Umfang() {
		return anzahlSeiten * seiteLaenge;
	}

	@Override
	public double Flaeche() {
		double inkreisRadius = seiteLaenge / (2 * Math.tan(Math.PI / anzahlSeiten));
		double height = seiteLaenge / 2;
		return inkreisRadius * height * anzahlSeiten;
	}

	public int GetAnzahlSeiten() {
		return anzahlSeiten;
	}

	public double GetSeiteLaenge() {
		return seiteLaenge;
	}
}