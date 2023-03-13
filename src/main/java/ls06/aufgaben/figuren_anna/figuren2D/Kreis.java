package ls06.aufgaben.figuren_anna.figuren2D;

public class Kreis extends Figur2D {
	private double radius;

	public Kreis(double radius) {
		super(radius);
		this.radius = radius;
	}

	@Override
	public double Umfang() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double Flaeche() {
		return Math.PI * radius * radius;
	}

	public double GetRadius() {
		return radius;
	}
}