package ls02.aufgaben.methoden.aufgabe5;

public class MathUtilities {

	public static void main(String[] args) {
		System.out.println(round(123.456, 2));
	}

	/**
	 * 
	 * @param numToRound the value we want to round
	 * @param accuracy   the number of decimal positions
	 * @return the rounded value with accuracy decimal positions
	 */
	public static double round(double numToRound, int accuracy) {
		double offset = Math.pow(10, accuracy);
		numToRound *= offset; // numToRound = numToRound * offset
		return Math.round(numToRound) / offset;
	}
}
