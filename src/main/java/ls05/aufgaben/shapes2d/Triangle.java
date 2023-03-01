package ls05.aufgaben.shapes2d;

public class Triangle extends NEck {

    private int seiteA;
    private int seiteB;
    private int seiteC;

    @Override
    public double berechneFlaeche() {
        double s = (getSeiteA() + getSeiteB() + getSeiteC()) / 2;
        double zwischenergebnis = s * (s - getSeiteA()) * (s - getSeiteB()) * (s - getSeiteC());
        return Math.sqrt(zwischenergebnis);
    }

    @Override
    public double berechneUmfang() {
        return getSeiteA() + getSeiteB() + getSeiteC();
    }

    public int getSeiteA() {
        return seiteA;
    }

    public void setSeiteA(int seiteA) {
        this.seiteA = seiteA;
    }

    public int getSeiteB() {
        return seiteB;
    }

    public void setSeiteB(int seiteB) {
        this.seiteB = seiteB;
    }

    public int getSeiteC() {
        return seiteC;
    }

    public void setSeiteC(int seiteC) {
        this.seiteC = seiteC;
    }

}
