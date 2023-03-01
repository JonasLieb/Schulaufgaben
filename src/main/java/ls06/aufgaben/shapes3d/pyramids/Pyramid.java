package ls06.aufgaben.shapes3d.pyramids;


import ls05.aufgaben.shapes2d.Shape2D;
import ls06.aufgaben.shapes3d.Shape3D;

public abstract class Pyramid implements Shape3D {
    private double height;
    private Shape2D base;

    public Pyramid(Shape2D base, double height) {
        setHeight(height);
        setBase(base);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0)
            throw new IllegalArgumentException("Die Höhe einer Pyramide kann nur positiv größer null sein");
        this.height = height;
    }

    public Shape2D getBase() {
        return base;
    }

    public void setBase(Shape2D base) {
        if (base == null) throw new IllegalArgumentException("Die Grundfläche einer Pyramide kann nicht null sein");
        this.base = base;
    }

    @Override
    public double getVolume() {
        return (getSurface() * getHeight()) / 3; //TODO idk ob diese Formel hier richtig ist
    }

    @Override
    public abstract double getSurface();
}
