package ls06.aufgaben.figuren_anna.figuren2D;

public class Rechteck extends Figur2D {

	private double seiteA;
	private double seiteB;

	public Rechteck(double seiteA, double seiteB) {
		super(seiteA, seiteB);
		this.seiteA = seiteA;
		this.seiteB = seiteB;
	}

	@Override
	public double Umfang() {
		return 2 * seiteA + 2 * seiteB;
	}

	@Override
	public double Flaeche() {
		return seiteA * seiteB;
	}

	public double GetSeiteA() {
		return seiteA;
	}

	public double GetSeiteB() {
		return seiteB;
	}
}