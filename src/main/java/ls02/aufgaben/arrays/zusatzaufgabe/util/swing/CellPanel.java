package ls02.aufgaben.arrays.zusatzaufgabe.util.swing;

import ls02.aufgaben.arrays.zusatzaufgabe.util.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;


/**
 * A JPanel configured to be used in the 'game of life'. Contains and controlls
 * all the cells (the actual 'playground' -> 'Spielwiese')
 *
 * @author Jonas Lieben
 */
public class CellPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private static final Color bgColor = Color.DARK_GRAY;

    private static final int STANDARD_SIZE = 100;
    private static final int GAME_START_ALIVE_CELLS_COUNT = 1000;
    private final int sideLength;
    private final int aliveCellsOnGameStart;

    private Cell[][] cells;

    /**
     * constructor
     *
     * @param sideLength the sidelength of the field
     */
    public CellPanel(int sideLength, int aliveCellsOnGameStart, Color bgColor) {
        if (sideLength <= 0)
            sideLength = STANDARD_SIZE;
        if (aliveCellsOnGameStart <= 0)
            aliveCellsOnGameStart = GAME_START_ALIVE_CELLS_COUNT;
        this.sideLength = sideLength;
        this.aliveCellsOnGameStart = aliveCellsOnGameStart;
        cells = new Cell[sideLength][sideLength];
        initField();
        initGui(bgColor);
    }

    /**
     * initializes the field with a size of sidelength * sidelength
     */
    private void initField() {
        // determine the cells that are alive at the games beginning
        ArrayList<Position> list = new ArrayList<Position>();
        int x;
        int y;
        Position p;
        while (list.size() < Math.min(aliveCellsOnGameStart, Math.pow(sideLength, 2))) {
            x = ThreadLocalRandom.current().nextInt(0, sideLength);
            y = ThreadLocalRandom.current().nextInt(0, sideLength);
            p = new Position(x, y);
            if (!list.contains(p))
                list.add(p);
        }

        // actually filling our field
        Position currentPos;
        for (int curY = 0; curY < cells.length; curY++) {
            for (int curX = 0; curX < cells.length; curX++) {
                currentPos = new Position(curY, curX);
                if (list.contains(currentPos)) {
                    cells[curY][curX] = new Cell(true, curX, curY, bgColor, Color.green);
                } else {
                    cells[curY][curX] = new Cell(false, curX, curY, bgColor, Color.green);
                }
            }
        }
    }

    /**
     * builds the gui (in this case we do only add some cells to the field)
     */
    private void initGui(Color bgColor) {
        this.setLayout(new GridLayout(sideLength, sideLength));
        for (int curY = 0; curY < cells.length; curY++) {
            for (int curX = 0; curX < cells.length; curX++) {
                this.add(cells[curY][curX]);
            }
        }
        this.setBackground(bgColor);
    }

    /**
     * will force every cell to update its state
     */
    public void updateCells() {
        // Zellen auf Basis des Feldes aktualisieren
        Cell[][] cellsKopie = cells.clone();
        cellsKopie = new Cell[cells.length][cells[0].length];
        for (int y = 0; y < cellsKopie.length; y++) {
            for (int x = 0; x < cellsKopie[y].length; x++) {
                cellsKopie[y][x] = new Cell(cells[y][x].isAlive(), x, y);
            }
        }

        for (int curY = 0; curY < cellsKopie.length; curY++) {
            for (int curX = 0; curX < cellsKopie.length; curX++) {
                cells[curY][curX].updateState(cellsKopie);
            }
        }
    }
}
