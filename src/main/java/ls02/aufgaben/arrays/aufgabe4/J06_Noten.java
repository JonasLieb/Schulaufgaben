package ls02.aufgaben.arrays.aufgabe4;

import ls02.aufgaben.arrays.aufgabe2.ArrayUtilities;

import java.util.Arrays;


public class J06_Noten {

	public static void main(String[] args) {

		// initialising values
		int[] noten = getGrades(5);
		double average = ArrayUtilities.getAverage(noten);

		// 1st output
		System.out.println(Arrays.toString(noten));
		System.out.println("Durchschnitt: " + average);

		// changing values
		changeGrade(noten, 3, 6);
		average = ArrayUtilities.getAverage(noten);

		// 2nd output
		System.out.println(Arrays.toString(noten));
		System.out.println("Durchschnitt: " + average);

	}

	/**
	 * initialises an array of numberOfGrades grades (German grades -> 1-6)
	 * 
	 * @param numberOfGrades the number of grades we want to get
	 * @return an array containing numberOfGrades random grades
	 */
	private static int[] getGrades(int numberOfGrades) {
		// Ist das dieses Notenw�rfeln? Fragw�rdiges Vorgehen...
		return ArrayUtilities.getRandomIntArray(1, 6, numberOfGrades);
	}

	/**
	 * changes the grade with index indexToChange from grades to the newGrade
	 * 
	 * @param grades        the given array of grades
	 * @param indexToChange the index of the grade we want to change
	 * @param newGrade      the value the grade should contain after executing this
	 *                      code
	 * @return the changed array
	 */
	private static int[] changeGrade(int[] grades, int indexToChange, int newGrade) {
		if (newGrade < 1 || newGrade > 6) {
			System.out.println("Ung�ltige Note \"" + newGrade + "\", Note wird nicht ver�ndert."); // -> Alternative 2
			return grades;
		}
		grades[indexToChange] = newGrade;
		return grades;
	}
}
