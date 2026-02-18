package utcluj.aut.lab2.exercises;

import java.util.Scanner;

/**
 * Class for calculating factorials using recursive and non-recursive approaches.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex3FactorialCalculator {

    public static void main(String[] args) {

        // 1. Create an instance of FactorialCalculator
        Ex3FactorialCalculator fact = new Ex3FactorialCalculator();
        // 2. Read an integer input from the user
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 3. Calculate the factorial using both recursive and non-recursive methods
        long factorial1 = fact.recursiveFactorial(n);
        long factorial2 = fact.nonRecursiveFactorial(n);
        // 4. Compare the execution times of both methods
        long[] executionTime = fact.compareExecutionTime(n);
        // 5. Print the results (factorials and execution times)
        System.out.println("Factorial Recursive : " + factorial1);
        System.out.println("Timpul de executie rec :" + executionTime[0]);
        System.out.println("Factorial Non Recursive : " + factorial2);
        System.out.println("Timpul de executie nonrec : " + executionTime[1]);
    }

    /**
     * Calculates the factorial of n using recursion.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long recursiveFactorial(int n) {
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        if (n < 0) {
            throw new IllegalArgumentException("n nu poate fi negativ");
        }

        // 3. Remember the base case (0! = 1)
        if (n == 0)
            return 1;
// 2. Implement the recursive algorithm for factorial
        return n * recursiveFactorial(n - 1);


    }

    /**
     * Calculates the factorial of n using a non-recursive approach.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long nonRecursiveFactorial(int n) {

        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        if (n < 0) {
            throw new IllegalArgumentException("n nu poate fi negativ");
        }
        // 2. Implement a loop-based algorithm for factorial
        if (n == 0)
            return 1;
        long p = 1;
        for (int i = 1; i <= n; i++) {
            p = p * i;
        }
        return p;
        // 3. Remember the base case (0! = 1)

    }

    /**
     * Compares the execution time of both factorial methods.
     *
     * @param n the number to calculate factorial for
     * @return an array with [recursiveTime, nonRecursiveTime] in nanoseconds
     */
    public long[] compareExecutionTime(int n) {

        // 1. Measure the execution time of recursiveFactorial
        long startTime1 = System.nanoTime();
        recursiveFactorial(n);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        // 2. Measure the execution time of nonRecursiveFactorial
        long startTime2 = System.nanoTime();
        nonRecursiveFactorial(n);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        // 3. Return both times in an array
        return new long[]{duration1, duration2};
    }
}
