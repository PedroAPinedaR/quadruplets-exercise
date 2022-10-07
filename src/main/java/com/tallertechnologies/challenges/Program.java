package com.tallertechnologies.challenges;
import java.util.*;

/**
 * @author pedro.pineda
 *
 */
public class Program implements ISolution{

	/**
	 * @param array with int
	 * @param targetSum value to check the sum of final arrays 
	 * @return
	 */
	@Override
	public List<Integer[]> fourNumberSum(Integer[] array, int targetSum) {
		List<Integer[]> result = new ArrayList<Integer[]>();
		for (int a = 0; a < array.length; a++) {
			for (int b = a + 1; b < array.length; b++) {
				for (int c = b + 1; c < array.length; c++) {
					for (int d = c + 1; d < array.length; d++) {
						if (array[a]+ array[b]+ array[c]+ array[d] == targetSum) {
							result.add(new Integer[]{array[a], array[b], array[c], array[d]});
						}
					}

				}

			}

		}
		return result;
	}

	public static void main(String[] args) {
		Integer[] fourNumber = {5, -5, -2, 2, 3, -3};
		List<Integer[]> result = new Program().fourNumberSum(fourNumber, 0);
		result.stream().forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2] + ", " + t[3]));
	}
}