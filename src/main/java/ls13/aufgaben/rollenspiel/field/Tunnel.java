package ls13.aufgaben.rollenspiel.field;

import java.awt.*;
import java.util.Objects;

public class Tunnel {
    private final Point p1;
    private final Point p2;
    private final Color color;

    //Eine Art Portal...
    public Tunnel(Point p1, Point p2) {
        if (Objects.equals(p1, p2))
            throw new IllegalArgumentException("Ein Tunnel kann nicht auf dem Selben Feld starten und enden");
        this.p1 = p1;
        this.p2 = p2;
        this.color = getColor();
    }

    public Point getPoint1() {
        return p1;
    }

    public Point getPoint2() {
        return p2;
    }

    public Color getColor() {
        //TODO
        return Color.GREEN;
    }
}
