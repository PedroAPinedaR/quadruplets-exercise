package com.tallertechnologies.challenges.perfomance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tallertechnologies.challenges.ISolution;
import com.tallertechnologies.challenges.Program;
import com.tallertechnologies.challenges.externalsolution.ExternalRecursiveSolution;

public class PerformanceComparator {

	List<ISolution> solutionsToCompare;

	public PerformanceComparator() {

		solutionsToCompare = new ArrayList<ISolution>();
		solutionsToCompare.add(new ExternalRecursiveSolution());
		solutionsToCompare.add(new Program());

	}

	private void compareTimes() {

		for (int i = 1; i <= 3; i++) {
			int numberOfNums = (int) Math.pow(10, i);
			int targetSum = (int) (Math.random() * (numberOfNums / 2));

			System.out.println("Comparing for " + numberOfNums + " number of nums, with targetSum: " + targetSum);

			Integer[] numsToCompare = generateArrayWithDifferentRandonNumbersWithSize(numberOfNums);
			
//			for (int j = 0; j < numsToCompare.length; j++) {
//				System.out.println(numsToCompare[j]);
//
//			}

			for (ISolution iSolution : solutionsToCompare) {
				System.out.println("Executing for: " + iSolution.getClass().getSimpleName());
				long initialTime = System.nanoTime();
				List<Integer[]> result = iSolution.fourNumberSum(numsToCompare, targetSum);
				// Uncomment to print the result

//				result.stream().forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2] + ", " + t[3]));
				long finalTime = System.nanoTime();
				System.out.println("Took : " + ((finalTime - initialTime) / 1000000) + " ms with " + result.size()
						+ " quadruplets");

			}
			System.out.println();

		}

	}

	private Integer[] generateArrayWithDifferentRandonNumbersWithSize(int numberOfNums) {
		Random random = new Random();

		List<Integer> randomNumbers = new ArrayList<Integer>(numberOfNums);
		for (int i = 0; i < numberOfNums; i++) {
			int numgerGenerated = 0;
			do {
				// Generating and random number between -numberOfNums and numberOfNums
				numgerGenerated = random.nextInt((2 * numberOfNums)) - numberOfNums;
			} while (randomNumbers.contains(numgerGenerated));
			randomNumbers.add(numgerGenerated);

		}

		return randomNumbers.stream().toArray(Integer[]::new);

	}

	public static void main(String[] args) {
		new PerformanceComparator().compareTimes();
	}

}
