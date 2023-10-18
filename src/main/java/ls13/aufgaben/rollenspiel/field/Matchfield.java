package ls13.aufgaben.rollenspiel.field;

import ls13.aufgaben.rollenspiel.util.ImageHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.Arrays;

public class Matchfield extends JPanel {
    private static final int MIN_WIDTH = 10;
    private static final int MIN_HEIGHT = 10;
    private static final int FIELD_LENGTH = 20 /* px */;
    private static final Color GRID_COLOR = Color.LIGHT_GRAY;
    private ArrayList<Tunnel> tunnels = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private int width;
    private int height;


    public Matchfield(int width, int height) {
        setHorizontalFieldCount(width);
        setVerticalFieldCount(height);

        initMatchfield(/*, TODO */);
    }

    private void initMatchfield() {
        Tunnel t1 = new Tunnel(new Point(1, 1), new Point(3, 3));
        Tunnel t2 = new Tunnel(new Point(3, 1), new Point(5, 3));
        this.setTunnels(t1, t2);
    }

    public int getHorizontalFieldCount() {
        return width;
    }

    public void setHorizontalFieldCount(int width) {
        if (width < 0)
            throw new IllegalArgumentException("Die Breite eines Spielfeldes muss Mindestens " + MIN_WIDTH + " betragen! Ihre Angabe: " + width);
        this.width = width;
        setMinimumSize(new Dimension(FIELD_LENGTH * getVerticalFieldCount(), FIELD_LENGTH * getHorizontalFieldCount()));
        setPreferredSize(new Dimension(FIELD_LENGTH * getVerticalFieldCount(), FIELD_LENGTH * getHorizontalFieldCount()));
    }

    public int getVerticalFieldCount() {
        return height;
    }

    public void setVerticalFieldCount(int height) {
        if (height < 0)
            throw new IllegalArgumentException("Die Höhe eines Spielfeldes muss Mindestens " + MIN_HEIGHT + " betragen! Ihre Angabe: " + height);
        this.height = height;
        setMinimumSize(new Dimension(FIELD_LENGTH * getVerticalFieldCount(), FIELD_LENGTH * getHorizontalFieldCount()));
        setPreferredSize(new Dimension(FIELD_LENGTH * getVerticalFieldCount(), FIELD_LENGTH * getHorizontalFieldCount()));
    }

    public void setTunnels(Tunnel... tunnels) {
        //leeren
        this.tunnels.clear();

        //Prüfen und ggf. hinzufügen
        Arrays.stream(tunnels).filter(tunnel -> this.containsPoint(tunnel.getPoint1()) && this.containsPoint(tunnel.getPoint2())).
                forEach(this.tunnels::add);
        repaint();
    }

    public void setRooms(Room... rooms) {
        //leeren
        this.rooms.clear();

        //Prüfen und ggf. hinzufügen
        Arrays.stream(rooms).filter(room -> this.containsPoint(room.getPoint1()) && this.containsPoint(room.getPoint2())).forEach(this.rooms::add);
        repaint();
    }

    public boolean containsPoint(Point p) {
        return p.x >= 0 && p.x < getHorizontalFieldCount() && p.y >= 0 && p.y < getHorizontalFieldCount();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        paintFieldBorders(g2D);
        paintRooms(g2D);
        paintTunnels(g2D);
        paintFigures(g2D);
    }

    private void paintFieldBorders(Graphics2D g2D) {
        g2D.setColor(GRID_COLOR);
        //vertical lines
        for (int i = 0; i <= width; i++) {
            g2D.drawLine(i * FIELD_LENGTH, 0, i * FIELD_LENGTH, getVerticalFieldCount() * FIELD_LENGTH);
        }
        for (int i = 0; i <= height; i++) {
            g2D.drawLine(0, i * FIELD_LENGTH, getHorizontalFieldCount() * FIELD_LENGTH, i * FIELD_LENGTH);
        }
    }

    private void paintRooms(Graphics2D g2D) {
        //TODO

        //Paint single Room
        Room r = new Room(new Point(10, 10), new Point(15, 15));

        g2D.setColor(Color.cyan);
        int roomWidth = Math.abs(r.getPoint2().x - r.getPoint1().x);
        int roomHeight = Math.abs(r.getPoint2().y - r.getPoint1().y);
        g2D.fillRect(FIELD_LENGTH * r.getPoint1().x, FIELD_LENGTH * r.getPoint1().y, FIELD_LENGTH * roomWidth, FIELD_LENGTH * roomHeight);
    }

    private void paintTunnels(Graphics2D g2D) {
        tunnels.forEach(tunnel -> {
            g2D.setColor(tunnel.getColor());
            g2D.fillOval(FIELD_LENGTH * tunnel.getPoint1().x, FIELD_LENGTH * tunnel.getPoint1().y, FIELD_LENGTH, FIELD_LENGTH);
            g2D.fillOval(FIELD_LENGTH * tunnel.getPoint2().x, FIELD_LENGTH * tunnel.getPoint2().y, FIELD_LENGTH, FIELD_LENGTH);
        });


        // createImageOp returns a useful image filter
        BufferedImageOp op = /*createImageOp();*/ null;
        // loadSourceImage returns a valid image
        BufferedImage sourceImage =  ImageHandler.getChangedColorImage(ImageHandler.getBufferedImage(ImageHandler.TUNNEL_IMAGE), Color.CYAN);

//        g2D.drawImage(null, );
    }

    private void paintFigures(Graphics2D g2D) {
        //TODO
    }
}
