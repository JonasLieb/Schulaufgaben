package ls06.aufgaben.shapes3d.pyramids;


import ls05.aufgaben.shapes2d.Circle;

public class CircularCone extends Pyramid {

    public CircularCone(Circle base, double height) {
        super(base, height);
    }

    @Override
    public double getSurface() {
        double radius = ((Circle) getBase()).getRadius();
        double sideHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(getHeight(), 2));
        return Math.PI * (Math.pow(radius, 2) + radius * sideHeight);
    }
}
