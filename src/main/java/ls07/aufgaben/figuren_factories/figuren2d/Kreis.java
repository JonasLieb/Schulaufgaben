package ls07.aufgaben.figuren_factories.figuren2d;

public class Kreis extends Figur2D {
	private double radius;

	public Kreis(double radius) {
		super(radius);
		this.radius = radius;
	}

	@Override
	public double umfang() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double flaeche() {
		return Math.PI * radius * radius;
	}

	public double getRadius() {
		return radius;
	}
}