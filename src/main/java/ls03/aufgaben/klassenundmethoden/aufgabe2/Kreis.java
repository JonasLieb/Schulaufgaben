package ls03.aufgaben.klassenundmethoden.aufgabe2;

public class Kreis {
    private double radius;

    public Kreis(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Der Radius eines Kreises kann nicht kleiner oder gleich 0 sein.");
        this.radius = radius;
    }

    public double umfang() {
        return 2d * Math.PI * radius;
    }

    public double flaeche() {
        return Math.PI * Math.pow(radius, 2);
    }
}
