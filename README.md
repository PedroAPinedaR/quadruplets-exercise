# Quadruplets Exercise
Java Challenge
Initial problem:
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. The function should find all quadruplets in
  the array that sum up to the target sum and return a two-dimensional array of
  all these quadruplets in no particular order.
  
  If no four numbers sum up to the target sum, the function should return an
  empty array.
  
### Sample Input
```
  array: [7 , 6,  4, -1, 1 ,2]
  targetSum = 16
```
  
### Sample Output

```
  [[7, 6, 4, -1], [7, 6, 1, 2]]  // the quadruplets could be ordered differently
```

### Another Test Cases(Currently tested on ProgramTest.java)
https://github.com/ldiazssj3/Java-Challenge/blob/main/README.md

### Main Class
src/main/java/com/tallertechnologies/challenges/Program.java (include static void main)

###JUnit TC foor all Test cases:
src/test/com/tallertechnologies/challenges/ProgramTest.java (Execute as normal JunitTest)

###Solution for the exercise using recurrency obtained from https://leetcode.com/problems/4sum/solution/   and modified to implement my interface.
src/main/java/com/tallertechnologies/challenges/externalsolution/ExternalRecursiveSolution.java

###Performance Comparator for my solution and external solution (include static void main)
src/main/java/com/tallertechnologies/challenges/perfomance/PerformanceComparator.java

This performance comparator generates n test, each one with 10^n randoms of integers as input array for each solution(Program.java  and ExternalRecursiveSolution.java).

Finally, prints the milliseconds taken by each solution and how many quadruplets were found.

Modify POWTOGENERATENUMBER = 3 to increase the ramdon numbers in the array

This PerformanceComparator with this configuration generates the next output
```
Comparing for 10 number of nums, with targetSum: 0
Executing for: ExternalRecursiveSolution
Took : 12 ms with 9 quadruplets
Executing for: Program
Took : 0 ms with 9 quadruplets

Comparing for 100 number of nums, with targetSum: 2
Executing for: ExternalRecursiveSolution
Took : 45 ms with 13711 quadruplets
Executing for: Program
Took : 38 ms with 13711 quadruplets

Comparing for 1000 number of nums, with targetSum: 192
Executing for: ExternalRecursiveSolution
Took : 20940 ms with 13582037 quadruplets
Executing for: Program
Took : 181746 ms with 13582037 quadruplets

```
#### Conclusion
For numberofnums <100 took less time my program, for the other cases is better the ExternalRecursiveSolution

#### Things to improve
Could my solution include sort the array at the beginning and add some validations to avoid continue iterating where the targetSum < that current Sum
