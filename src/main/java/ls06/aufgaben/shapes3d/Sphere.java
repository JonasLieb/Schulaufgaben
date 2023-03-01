package ls06.aufgaben.shapes3d;

public class Sphere implements Shape3D {
    private double radius;

    public Sphere(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Der Radius einer Kugel kann nicht negativ sein!");
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return 4d / 3 * Math.PI * (Math.pow(getRadius(), 3));
    }

    @Override
    public double getSurface() {
        return 4d * Math.PI * Math.pow(radius, 2);
    }
}
