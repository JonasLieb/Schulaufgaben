package ls06.aufgaben.shapes3d.prisms;

import ls05.aufgaben.shapes2d.Shape2D;
import ls06.aufgaben.shapes3d.Shape3D;

public class Prism implements Shape3D {
    private double height;
    private Shape2D base;

    @Override
    public double getVolume() {
        return base.berechneFlaeche() * height;
    }

    @Override
    public double getSurface() {
        return -1; //TODO
    }
}
