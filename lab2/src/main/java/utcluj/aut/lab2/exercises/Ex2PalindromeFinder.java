package utcluj.aut.lab2.exercises;

import java.util.Scanner;

/**
 * Class for finding palindromic numbers in a given range.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex2PalindromeFinder {

    public static void main(String[] args) {

        // 1. Create an instance of PalindromeFinder
        Ex2PalindromeFinder palindr = new Ex2PalindromeFinder();
        // 2. Define a range of numbers to check for palindromes
        int[] readInterval = palindr.readInterval();
        // 3. Find palindromes in the defined range
        int[] palindrome = palindr.findPalindromes(readInterval[0], readInterval[1]);
        // 4. Print the array of palindromes
        for (int i = 0; i < palindrome.length; i++) {
            System.out.println(palindrome[i]);
        }
    }

    /**
     * Checks if a number is palindromic (reads the same backward as forward).
     *
     * @param number the number to check
     * @return true if the number is palindromic, false otherwise
     */
    public boolean isPalindromic(int number) {
        // TODO: Implement this method
        // 1. Convert the number to a string
        // 2. Check if the string reads the same forward and backward
        // 3. Return the result
        String string = number + "";
        String reverseString = new StringBuilder(string).reverse().toString();
        return string.equals(reverseString);
        // return false;
    }

    /**
     * Finds all palindromic numbers in the given range [a, b], inclusive.
     *
     * @param a the lower bound of the range
     * @param b the upper bound of the range
     * @return an array of all palindromic numbers in the range
     * @throws IllegalArgumentException if a > b
     */
    private int[] readInterval() {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        boolean isALessThenB = false;
        do {


            System.out.println("enter a:");
            a = scanner.nextInt();
            System.out.println("enter b:");
            b = scanner.nextInt();
            scanner.nextLine();
            if (a < b)
                isALessThenB = true;
            else System.out.println("a must be less then b");

        } while (!isALessThenB);
        return new int[]{a, b};
    }

    public int[] findPalindromes(int a, int b) {
        int[] tempArray = new int[b - a + 1];
        int count = 0;

        for (int i = a; i <= b; i++) {
            if (isPalindromic(i)) {
                tempArray[count++] = i;
            }
        }

        int[] palindromes = new int[count];
        System.arraycopy(tempArray, 0, palindromes, 0, count);
        return palindromes;
    }
}
