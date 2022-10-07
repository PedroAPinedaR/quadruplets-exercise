package com.tallertechnologies.challenges;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;


/**
 * @author pedro.pineda
 *
 */
public class ProgramTest {

	private Program program;

	public ProgramTest() {
		program= new Program();
	}

	@Test
	public void testTestCase1() {

		Integer[] fourNumber = { 7, 6, 4, -1, 1, 2 };
		Integer targetSum = 16;
		Integer[][] expectedAnswer = { { 7, 6, 4, -1 }, { 7, 6, 1, 2 } };

		List<Integer[]> fourNumberSum = program.fourNumberSum(fourNumber, targetSum);
		assertListEqualsWithNoInterenalOrder(fourNumberSum, Arrays.asList(expectedAnswer));

	}

	@Test
	public void testTestCase2() {

		Integer[] fourNumber = { 1, 2, 3, 4, 5, 6, 7 };
		Integer targetSum = 10;
		Integer[][] expectedAnswer = { { 1, 2, 3, 4 } };

		List<Integer[]> fourNumberSum = program.fourNumberSum(fourNumber, targetSum);
		assertListEqualsWithNoInterenalOrder(fourNumberSum, Arrays.asList(expectedAnswer));

	}

	@Test
	public void testTestCase3() {

		Integer[] fourNumber = { 5, -5, -2, 2, 3, -3 };
		Integer targetSum = 0;
		Integer[][] expectedAnswer = { { 5, -5, -2, 2 }, { 5, -5, 3, -3 }, { -2, 2, 3, -3 } };

		List<Integer[]> fourNumberSum = program.fourNumberSum(fourNumber, targetSum);
		assertListEqualsWithNoInterenalOrder(fourNumberSum, Arrays.asList(expectedAnswer));

	}

	@Test
	public void testTestCase4() {

		Integer[] fourNumber = { -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer targetSum = 4;
		Integer[][] expectedAnswer = { { -2, -1, 1, 6 }, { -2, 1, 2, 3 }, { -2, -1, 2, 5 }, { -2, -1, 3, 4 } };

		List<Integer[]> fourNumberSum = program.fourNumberSum(fourNumber, targetSum);
		assertListEqualsWithNoInterenalOrder(fourNumberSum, Arrays.asList(expectedAnswer));

	}

	@Test
	public void testTestCase5() {

		Integer[] fourNumber = { -1, 22, 18, 4, 7, 11, 2, -5, -3 };
		Integer targetSum = 30;
		Integer[][] expectedAnswer = { { -1, 22, 7, 2 }, { 22, 4, 7, -3 }, { -1, 18, 11, 2 }, { 18, 4, 11, -3 },
				{ 22, 11, 2, -5 } };

		List<Integer[]> fourNumberSum = program.fourNumberSum(fourNumber, targetSum);
		assertListEqualsWithNoInterenalOrder(fourNumberSum, Arrays.asList(expectedAnswer));

	}

	@Test
	public void testTestCase6() {

		Integer[] fourNumber = { -10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5 };
		Integer targetSum = 20;
		Integer[][] expectedAnswer = { { -5, 2, 15, 8 }, { -3, 2, -7, 28 }, { -10, -3, 28, 5 }, { -10, 28, -6, 8 },
				{ -7, 28, -6, 5 }, { -5, 2, 12, 11 }, { -5, 12, 8, 5 } };

		List<Integer[]> fourNumberSum = program.fourNumberSum(fourNumber, targetSum);
		assertListEqualsWithNoInterenalOrder(fourNumberSum, Arrays.asList(expectedAnswer));

	}

	@Test
	public void testTestCase7() {

		Integer[] fourNumber = { 1, 2, 3, 4, 5 };
		Integer targetSum = 100;
		Integer[][] expectedAnswer = {};

		List<Integer[]> fourNumberSum = program.fourNumberSum(fourNumber, targetSum);
		assertListEqualsWithNoInterenalOrder(fourNumberSum, Arrays.asList(expectedAnswer));

	}

	@Test
	public void testTestCase8() {

		Integer[] fourNumber = { 1, 2, 3, 4, 5, -5, 6, -6 };
		Integer targetSum = 5;
		Integer[][] expectedAnswer = { { 2, 3, 5, -5 }, { 1, 4, 5, -5 }, { 2, 4, 5, -6 }, { 1, 3, -5, 6 }, { 2, 3, 6, -6 },
				{ 1, 4, 6, -6 } };

		List<Integer[]> fourNumberSum = program.fourNumberSum(fourNumber, targetSum);
		assertListEqualsWithNoInterenalOrder(fourNumberSum, Arrays.asList(expectedAnswer));

	}

	public Integer[][] sortArrays(Integer[][] expectedAnswer) {
		Arrays.sort(expectedAnswer, (a1, a2) -> {
			if (a1[0] - a2[0] != 0) {
				return a1[0] - a2[0];
			}
			if (a1[1] - a2[1] != 0) {
				return a1[1] - a2[1];
			}

			if (a1[2] - a2[2] != 0) {
				return a1[2] - a2[2];
			}

			if (a1[3] - a2[3] != 0) {
				return a1[3] - a2[3];
			}
			return 0;
		});

		return expectedAnswer;

	}

	private static void assertListEqualsWithNoInterenalOrder(List<Integer[]> a, List<Integer[]> b)
			throws ArrayComparisonFailure {
		
		
		if (a.size() != b.size()) {
			throw new ArrayComparisonFailure("Lists doesn't have the same size: " + a.size() + " - " + b.size(),
					new AssertionError("Error"), 0);
		}
		
		// ordering quadruplets 
				a.stream().forEach(t -> Arrays.sort(t));
				b.stream().forEach(t -> Arrays.sort(t));
			
		for (int i = 0; i < a.size(); i++) {
			Integer[] quadruplet = a.get(i);
			if (!b.stream().anyMatch(t -> Arrays.equals(t,quadruplet ))) {
				throw new ArrayComparisonFailure("Object at index " + i + " doesn't exits in second array ",
						new AssertionError("Error"), i);
			}
		}

		for (int i = 0; i < b.size(); i++) {
			Integer[] quadruplet = b.get(i);

			if (!a.stream().anyMatch(t -> Arrays.equals(t,quadruplet ))) {
				throw new ArrayComparisonFailure("Object at index " + i + " doesn't exits in first array ",
						new AssertionError("Error"), i);
			}
		}

	}

}