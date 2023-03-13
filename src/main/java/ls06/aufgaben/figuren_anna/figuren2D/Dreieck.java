package ls06.aufgaben.figuren_anna.figuren2D;

public class Dreieck extends Figur2D {
    private double seiteA;
    private double seiteB;
    private double seiteC;

    public Dreieck(double seiteA, double seiteB, double seiteC) {
        super(seiteA, seiteB, seiteC);

        this.seiteA = seiteA;
        this.seiteB = seiteB;
        this.seiteC = seiteC;

        IsTriAngleValid(seiteA, seiteB, seiteC);
    }

    @Override
    public double Umfang() {
        return seiteA + seiteB + seiteC;
    }

    @Override
    public double Flaeche() {
        double s = (seiteA + seiteB + seiteC) / 2;
        double flaecheZw = s * (s - seiteA) * (s - seiteB) * (s - seiteC);
        return Math.sqrt(flaecheZw);
    }

    public double GetSeiteA() {
        return seiteA;
    }

    public void SetSeiteA(double laenge) {
        IsTriAngleValid(laenge, seiteB, seiteC);
        this.seiteA = laenge;
    }

    public double GetSeiteB() {
        return seiteB;
    }

    public void SetSeiteB(double laenge) {
        IsTriAngleValid(seiteA, laenge, seiteC);
        this.seiteB = laenge;
    }

    public double GetSeiteC() {
        return seiteC;
    }

    public void SetSeiteC(double laenge) {
        IsTriAngleValid(seiteA, seiteB, laenge);
        this.seiteC = laenge;
    }

    public static void IsTriAngleValid(double seiteA, double seiteB, double seiteC) throws IllegalArgumentException {
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
                    "Die längste Seite darf nicht kürzer als die restlichen zwei Seiten sein");
        }
    }
}
