package ls01.aufgaben.schleifen.aufgabe8;


import ls01.util.Utilities;

public class LS01_Quadrat {

	public static void main(String[] args) {
		printQuadrat();
	}

	public static void printQuadrat() {
		int num = Utilities.getInt("Geben Sie eine Seitenl�nge f�r das Quadrat an",
				"Eingegebener Wert war ung�ltig. versuchen Sie es erneut.", 0, Integer.MAX_VALUE);
		printQuadrat(num, num, false);
	}

	public static void printQuadrat(int width, int height, boolean isFilled) {
		for (int row = 0; row < height; row++) {
			System.out.println();
			for (int col = 0; col < width; col++) {
				if (isFilled || row == 0 || col == 0 || row == height - 1 || col == width - 1)
					System.out.print(" *");
				else
					System.out.print("  ");

			}
		}
	}
}
