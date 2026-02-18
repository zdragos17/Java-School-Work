package utcluj.aut.lab2.exercises;

import java.util.Random;

/**
 * Class for generating and analyzing arrays of random integers.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex1ArrayAnalyzer {

    public static void main(String[] args) {

        // 1. Create an instance of ArrayAnalyzer
        Ex1ArrayAnalyzer analyzer = new Ex1ArrayAnalyzer();
        // 2. Generate a random array
        int[] array = analyzer.generateArray();
        // 3. Calculate the average of the array
        double average = analyzer.calculateAverage(array);
        // 4. Count elements above and below the average
        int[] array2 = analyzer.countAboveBelowAverage(array, average);
        // 5. Print the results
        System.out.println("Average " + average);
        System.out.println("AboveBelowAverage " + array2[0] + array2[1]);
    }

    /**
     * Generates an array of random size between 25 and 150,
     * filled with random integers between -100 and 100.
     *
     * @return an array of random integers
     */
    public int[] generateArray() {

        // 1. Generate a random size between 25 and 150
        Random random = new Random();
        int size = random.nextInt(126) + 25;
        // 2. Create an array of that size
        int[] array = new int[size];
        // 3. Fill the array with random integers between -100 and 100
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        // 4. Return the array
        return array;


    }

    /**
     * Calculates the average value of all elements in the given array.
     *
     * @param array the array to analyze
     * @return the average value of all elements
     */
    public double calculateAverage(int[] array) {
        // 3. Handle edge case of empty array
        if (array.length == 0)
            return 0.0;

        // 1. Calculate the sum of all elements in the array
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        // 2. Return the average (sum divided by length)
        double average = (double) sum / array.length;
        return average;

    }

    /**
     * Counts how many elements are above and below the given average.
     *
     * @param array   the array to analyze
     * @param average the average value to compare against
     * @return an array of 2 integers: [countAbove, countBelow]
     */
    public int[] countAboveBelowAverage(int[] array, double average) {
        // 1. Count elements above the average
        int countAbove = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > average) {
                countAbove++;
            }
        }

        // 2. Count elements below the average
        int countBelow = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) {
                countBelow++;
            }
        }
        // 3. Return both counts as an array [countAbove, countBelow]
        return new int[]{countAbove, countBelow};
    }
}
