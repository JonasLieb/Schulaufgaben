package ls13.aufgaben.rollenspiel.field;

import java.awt.*;

public class Room {
    private final Point p1;
    private final Point p2;

    public Room(Point p1, Point p2) {
        if (p1 == null || p2 == null) throw new IllegalArgumentException("Raumkoordinaten unbekannt");
        if (p1.equals(p2)) throw new IllegalArgumentException("Der Raum von " + p1 + " und " + p2 + " wäre leer");
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getPoint1() {
        return p1;
    }

    public Point getPoint2() {
        return p2;
    }
}
