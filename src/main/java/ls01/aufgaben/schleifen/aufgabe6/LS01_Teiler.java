package ls01.aufgaben.schleifen.aufgabe6;

import java.util.ArrayList;
import java.util.List;

public class LS01_Teiler {

	public static void main(String[] args) {
		printTeiler(9);
	}

	public static void printTeiler(int num) {
		System.out.println("Teiler der Zahl " + num);
		int[] teiler = getTeiler(num);
		if (teiler == null) {
			System.out.println("Die Zahl 0 hat keine Teiler.");
			return;
		}
		// output
		System.out.print(teiler[0]);
		for (int i = 1; i < teiler.length; i++) {
			System.out.print(", " + teiler[i]);
		}
	}

	public static int[] getTeiler(int num) {
		if (num == 0)
			return null;

		// init
		List<Integer> teiler = new ArrayList<Integer>();

		// calculation
		if (num > 0)
			for (int i = 1; i <= num; i++) {
				if (num % i == 0)
					teiler.add(i);
			}
		else
			for (int i = -1; i >= num; i--) {
				if (num % i == 0)
					teiler.add(i);
			}

		// build return
		int[] ret = new int[teiler.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = teiler.get(i);
		}
		// return
		return ret;
	}
}
