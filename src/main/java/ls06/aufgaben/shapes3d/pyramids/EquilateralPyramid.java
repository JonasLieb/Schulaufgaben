package ls06.aufgaben.shapes3d.pyramids;


import ls05.aufgaben.shapes2d.NEck;

public class EquilateralPyramid extends Pyramid {

    public EquilateralPyramid(double height, NEck base) {
        super(base, height);
    }

    @Override
    public double getSurface() {
        return -1; //TODO
    }
}