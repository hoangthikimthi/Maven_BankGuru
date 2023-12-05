package JAVA;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		BT_05_Test_if_an_array_contains_a_specific_value();
	}

	public static void BT_01_Array() {
		int[] my_array1 = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };

		Arrays.sort(my_array1);
		for (int i : my_array1) {
			System.out.println(i);
		}

		// Declare and initialize a string array.
		String[] my_array2 = { "Java", "Python", "PHP", "C#", "C Programming", "C++" };
		Arrays.sort(my_array2);
		for (String i : my_array2) {
			System.out.println(i);
		}
	}

	public static void BT_02_SumValue() {
		int[] my_array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = 0;
		for (int i : my_array1) {
			sum += i;
		}
		System.out.println(sum);
	}

	public static void BT_03_Multidimensional_Array() {
		int[][] multiA = new int[10][10];
		for (int i = 0; i < multiA.length; i++) {
			for (int j = 0; j < multiA.length; j++) {
				System.out.printf("%2d", multiA[i][j]);

			}
			// System.out.println();
		}
	}

	public static void BT_04_calculate_average_value() {
		int[] my_array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = 0;
		for (int i = 0; i < my_array1.length; i++) {
			sum = sum + my_array1[i];
		}
		double avr = sum / my_array1.length;
		System.out.println("everage of array is: " + avr);
	}

	public static void BT_05_Test_if_an_array_contains_a_specific_value() {
		int[] my_array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i : my_array1) {
			if (i == 10) {
				System.out.println("This array contain value is 10");
				break;

			}

		}
	}
}
