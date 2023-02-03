package ls02.aufgaben.arrays.aufgabe2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

public class ArrayUtilities {
	public static void main(String[] args) {
		System.out.println("");
		int[] randomInts = getRandomIntArray(5, 50, 23);
		double[] randomDoubles = getRandomDoubleArray(5.2, 50.5, 23);

		prettyPrintArray(randomInts);
		prettyPrintArray(randomDoubles);

		System.out.println("Summe des int-Arrays: " + getSum(randomInts));
		System.out.println("Summe des double-Arrays: " + getSum(randomDoubles));
	}

	/**
	 * will generate an array of random integer values between min and max
	 * 
	 * @param min            the lower border of values
	 * @param max            the upper border of values
	 * @param numberOfValues the number of random values we estimate to be returned
	 * @return an array with numberOfValues values between min and max
	 */
	public static int[] getRandomIntArray(int min, int max, int numberOfValues) {
		int[] ret = new int[numberOfValues];

		for (int i = 0; i < ret.length; i++) {
			ret[i] = (int) (Math.random() * (max - min));
		}
		return ret;
	}

	/**
	 * will generate an array of random integer values between min and max
	 * 
	 * @param min            the lower border of values
	 * @param max            the upper border of values
	 * @param numberOfValues the number of random values we estimate to be returned
	 * @return an array with numberOfValues values between min and max
	 */
	public static double[] getRandomDoubleArray(double min, double max, int numberOfValues) {
		double[] ret = new double[numberOfValues];

		for (int i = 0; i < ret.length; i++) {
			ret[i] = Math.random() * (max - min);
		}
		return ret;
	}

	/**
	 * will print a pretty output of the array to the console
	 * 
	 * @param arr the given array
	 */
	public static void prettyPrintArray(Object[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * will print a pretty output of the array to the console
	 * 
	 * @param arr the given array
	 */
	public static void prettyPrintArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * will print a pretty output of the array to the console
	 * 
	 * @param arr the given array
	 */
	public static void prettyPrintArray(double[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * calculates the value of the array arr when all elements are added together
	 * 
	 * @param arr the given array
	 * @return the value that results when adding every element of arr together
	 */
	public static int getSum(int[] arr) {
		// alternatively one could build an double-array from arrand call
		// 'getSum(double[] arr)'
		int ret = 0;
		for (int d : arr)
			ret += d;
		return ret;
	}

	/**
	 * calculates the value of the array arr when all elements are added together
	 * 
	 * @param arr the given array
	 * @return the value that results when adding every element of arr together
	 */
	public static double getSum(double[] arr) {
		double ret = 0d;
		for (double d : arr)
			ret += d;
		return ret;
	}

	public static double getAverage(int[] arr) {
		// The explizit double-cast is necessary here to not get a rounded value
		// (because we divide int by int and than parse into double)
		return (double) getSum(arr) / arr.length;
	}

	public static double getAverage(double[] arr) {
		return getSum(arr) / arr.length;
	}

	/**
	 * determins the highest value in the array
	 * 
	 * @param arr the array we evaluate
	 * @return the arrays highest value or -1 if the array is null
	 */
	public static int getMaxValue(int[] arr) {
		if (arr == null)
			// the return of -1 is a poor return opertunity because this value could
			// potentially
			// be the highest value the array contains. I would prefer throwing an exception
			// here...
			return -1;

		int currentMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > currentMax)
				currentMax = arr[i];
		}
		return currentMax;
	}

	/**
	 * determins the highest value in the array
	 * 
	 * @param arr the array we evaluate
	 * @return the arrays highest value or -1 if the array is null
	 */
	public static int getMinValue(int[] arr) {
		if (arr == null)
			// the return of -1 is a poor return opertunity because this value could
			// potentially
			// be the highest value the array contains. I would prefer throwing an exception
			// here...
			return -1;

		int currentMin = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < currentMin)
				currentMin = arr[i];
		}
		return currentMin;
	}

	/**
	 * determins the highest value in the array
	 * 
	 * @param arr the array we evaluate
	 * @return the arrays highest value or -1 if the array is null
	 */
	public static double getMaxValue(double[] arr) {
		if (arr == null)
			// the return of -1 is a poor return opertunity because this value could
			// potentially
			// be the highest value the array contains. I would prefer throwing an exception
			// here...
			return -1;

		double currentMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > currentMax)
				currentMax = arr[i];
		}
		return currentMax;
	}

	/**
	 * determins the highest value in the array
	 * 
	 * @param arr the array we evaluate
	 * @return the arrays highest value or -1 if the array is null
	 */
	public static double getMinValue(double[] arr) {
		if (arr == null)
			// the return of -1 is a poor return opertunity because this value could
			// potentially
			// be the highest value the array contains. I would prefer throwing an exception
			// here...
			return -1;

		double currentMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < currentMax)
				currentMax = arr[i];
		}
		return currentMax;
	}

	/**
	 * determins the value that is used the most often in the array
	 * 
	 * @param arr the array we evaluate
	 * @return the arrays highest value or -1 if the array is null
	 */
	public static double getMostCommonValue(int[] arr) {
		double[] arrAsDouble = new double[arr.length];
		for (int i = 0; i < arrAsDouble.length; i++) {
			arrAsDouble[i] = (double) arr[i];
		}
		return getMostCommonValue(arrAsDouble);
	}

	/**
	 * determins the value that is used the most often in the array
	 * 
	 * @param arr the array we evaluate
	 * @return the arrays highest value or -1 if the array is null
	 */
	public static double getMostCommonValue(double[] arr) {
		if (arr == null)
			// the return of -1 is a poor return opertunity because this value could
			// potentially
			// be the highest value the array contains. I would prefer throwing an exception
			// here...
			return -1;

		List<Double> l = new ArrayList<Double>();
		for (int i = 0; i < arr.length; i++) {
			l.add(arr[i]);
		}

		return l.stream()
				.reduce(BinaryOperator.maxBy((o1, o2) -> Collections.frequency(l, o1) - Collections.frequency(l, o2)))
				.orElse(null);
	}
}
