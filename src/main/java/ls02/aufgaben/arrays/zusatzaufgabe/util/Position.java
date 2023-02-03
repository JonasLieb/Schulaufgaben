package ls02.aufgaben.arrays.zusatzaufgabe.util;

/**
 * a class to save a two-dimensional coordinate
 * 
 * @author Jonas Lieben
 *
 */
public class Position {
	public int x;
	public int y;

	/**
	 * constructor
	 * 
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * checks if the Object is eqal to this
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			Position p = (Position) obj;
			if (p.x == x && p.y == y)
				return true;
		}
		return false;
	}
}
