package ls07.aufgaben.figuren_factories.figuren3d;

public class Kugel extends Figur3D {

    private double radius;

    public Kugel(double radius) {
        setRadius(radius);
    }

    @Override
    public double oberflaeche() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double volumen() {
        // Weil sonst 1, Division mit Integern
        return (4d / 3) * Math.PI * Math.pow(radius, 3);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
