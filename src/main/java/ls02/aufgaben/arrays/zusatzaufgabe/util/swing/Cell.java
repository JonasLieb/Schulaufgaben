package ls02.aufgaben.arrays.zusatzaufgabe.util.swing;

import java.awt.*;

import javax.swing.JPanel;

/**
 * This class imitates a single cell in the "game of life"
 *
 * @author Jonas Lieben
 */
public class Cell extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int BORDER_WIDTH = 0;
    int posX;
    int posY;
    private boolean isAlive;
    private static final Color STANDARD_ALIVE_BACKGROUND = Color.GREEN;
    private static final Color STANDARD_DEAD_BACKGROUND = Color.LIGHT_GRAY;
    private Color alive_color = Color.GREEN;
    private Color dead_color = Color.WHITE;
    private static final int LOWER_LIVING_LIMIT = 2;
    private static final int UPPER_LIVING_LIMIT = 3;

    /**
     * Constructor
     *
     * @param alive determins if the cell is alive or dead
     * @param x     the positions x-coordinate of this cell
     * @param y     the  positions y-coordinate of this cell
     */
    public Cell(boolean alive, int x, int y) {
        this(alive, x, y, STANDARD_DEAD_BACKGROUND, STANDARD_ALIVE_BACKGROUND);
    }

    /**
     * Constructor
     *
     * @param alive determins if the cell is alive or dead
     * @param x     the positions x-coordinate of this cell
     * @param y     the  positions y-coordinate of this cell
     */
    public Cell(boolean alive, int x, int y, Color deadColor, Color aliveColor) {
        this.posX = x;
        this.posY = y;
        this.setToolTipText("X:" + x + " Y: " + y);
        alive_color = aliveColor;
        dead_color = deadColor;
        setState(alive);
    }

    /**
     * changes the cells state to the given boolean (true = alive, false = dead)
     *
     * @param alive the boolean that determins if the cell is alive or dead
     */
    private void setState(boolean alive) {
        isAlive = alive;
        repaint();
    }

    /**
     * provides information about the cells current state (dead/alive)
     *
     * @return if the cell is alive
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * updates the cells state by watching the neighbour-cells
     *
     * @param field the games field
     */
    public void updateState(Cell[][] field) {
        boolean nextState = false;
        int livingNeighbours = getAliveNeighboursCount(field);

        if (isAlive()) {
            if (livingNeighbours < LOWER_LIVING_LIMIT || livingNeighbours > UPPER_LIVING_LIMIT) {
                // Einsamkeit und überbevölkerung:
                nextState = false;
            } else {
                // Gute bedingungen:
                nextState = true;
            }
        } else {
            if (livingNeighbours == 3)
                nextState = true;
        }
        setState(nextState);
    }

    /**
     * determins the count of this cells living neighbours
     *
     * @param field the games field
     * @return the count of living cells right next to this
     */
    private int getAliveNeighboursCount(Cell[][] field) {
        int minX = posX - 1;
        int maxX = minX + 3;
        int minY = posY - 1;
        int maxY = minY + 3;
        int count = 0;

        // Falsche Werte abfangen
        if (minX < 0)
            minX = 0;
        if (minY < 0)
            minY = 0;
        if (maxX > field.length - 1)
            maxX = field.length - 1;
        if (maxY > field[0].length - 1)
            maxY = field[0].length - 1;

        for (int curY = minY; curY < maxY; curY++) {
            for (int curX = minX; curX < maxX; curX++) {
                if (field[curY][curX].isAlive() && (curX != posX || curY != posY)) {
                    count++;
                }
            }
        }
        return count;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Hintergrund
        if (isAlive) g.setColor(alive_color);
        else g.setColor(dead_color);
        g.fillRect(0, 0, getWidth(), getHeight());

        //Rahmen
        g.setColor(Color.LIGHT_GRAY);
        for (int layer = 0; layer < BORDER_WIDTH; layer++) {
            g.drawRect(layer, layer, getWidth() - (2 * layer), getHeight() - (2 * layer));
        }


    }
}
