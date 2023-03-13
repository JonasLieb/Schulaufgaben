package ls06.aufgaben.figuren_generics.figuren2d;

public class Rechteck extends Figur2D {

	private double seiteA;
	private double seiteB;

	public Rechteck(double seiteA, double seiteB) {
		super(seiteA, seiteB);
		this.seiteA = seiteA;
		this.seiteB = seiteB;
	}

	@Override
	public double umfang() {
		return 2 * seiteA + 2 * seiteB;
	}

	@Override
	public double flaeche() {
		return seiteA * seiteB;
	}

	public double getSeiteA() {
		return seiteA;
	}

	public double getSeiteB() {
		return seiteB;
	}
}