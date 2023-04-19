package ls07.aufgaben.figuren_factories.figuren2d;

public class Dreieck extends Figur2D {
	private double seiteA;
	private double seiteB;
	private double seiteC;

	public Dreieck(double seiteA, double seiteB, double seiteC) {
		super(seiteA, seiteB, seiteC);

		this.seiteA = seiteA;
		this.seiteB = seiteB;
		this.seiteC = seiteC;

		isTriAngleValid(seiteA, seiteB, seiteC);
	}

	@Override
	public double umfang() {
		return seiteA + seiteB + seiteC;
	}

	@Override
	public double flaeche() {
		double s = (seiteA + seiteB + seiteC) / 2;
		double flaecheZw = s * (s - seiteA) * (s - seiteB) * (s - seiteC);
		return Math.sqrt(flaecheZw);
	}

	public double getSeiteA() {
		return seiteA;
	}

	public void SetSeiteA(double laenge) {
		isTriAngleValid(laenge, seiteB, seiteC);
		this.seiteA = laenge;
	}

	public double getSeiteB() {
		return seiteB;
	}

	public void SetSeiteB(double laenge) {
		isTriAngleValid(seiteA, laenge, seiteC);
		this.seiteB = laenge;
	}

	public double getSeiteC() {
		return seiteC;
	}

	public void setSeiteC(double laenge) {
		isTriAngleValid(seiteA, seiteB, laenge);
		this.seiteC = laenge;
	}

	public static void isTriAngleValid(double seiteA, double seiteB, double seiteC) throws IllegalArgumentException {
		if (seiteA <= 0 || seiteB <= 0 || seiteC <= 0) {
			throw new IllegalArgumentException("Eingegebene Werte d�rfen nicht <= 0 sein");
		}
		double maximum = Math.max(Math.max(seiteA, seiteB), seiteC);
		double lengthSumOtherSites;
		if (maximum == seiteA) {
			lengthSumOtherSites = seiteB + seiteC;
		} else if (maximum == seiteB) {
			lengthSumOtherSites = seiteA + seiteC;
		} else {
			lengthSumOtherSites = seiteA + seiteB;
		}
		if (lengthSumOtherSites <= maximum) {
			throw new IllegalArgumentException(
					"Die l�ngste Seite darf nicht k�rzer als die restlichen zwei Seiten sein");
		}
	}
}
