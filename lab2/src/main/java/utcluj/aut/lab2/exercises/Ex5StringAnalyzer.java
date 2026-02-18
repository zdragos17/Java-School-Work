package utcluj.aut.lab2.exercises;

import java.util.Scanner;

/**
 * Class for analyzing strings.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex5StringAnalyzer {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti string-urile: ");
        String input = scanner.nextLine();
        // 1. Create an instance of StringAnalyzer
        Ex5StringAnalyzer ex5StringAnalyzer = new Ex5StringAnalyzer();
        // 2. Parse the input string into an array of strings
        String[] strings = ex5StringAnalyzer.parseInput(input);
        // 3. Find and print the longest and shortest strings

        String[] longest = ex5StringAnalyzer.findLongest(strings);
        System.out.println("Cel mai lung: ");
        String[] longestStrings = ex5StringAnalyzer.findLongest(strings);
        for (int i = 0; i < longest.length; i++) {
            System.out.println(longest[i]);
        }
        System.out.println("Cel mai scurt: ");
        String[] shortest = ex5StringAnalyzer.findShortest(strings);
        for (int i = 0; i < shortest.length; i++) {
            System.out.println(shortest[i]);
        }

        //  4. Count and print the number of vowels and consonants in each string
        int[] vowel = ex5StringAnalyzer.countVowels(strings);
        int[] consonant = ex5StringAnalyzer.countConsonants(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i] + " Vocale: " + vowel[i] + " Consoane: " + consonant[i]);
        }
        // 5. Find and print the strings with the most vowels and consonants
        String[] mostVowels = ex5StringAnalyzer.findMostVowels(strings);
        System.out.println("Cele mai multe vocale: ");
        for (int i = 0; i < mostVowels.length; i++) {
            System.out.println(mostVowels[i]);
        }
        String[] mostConsonants = ex5StringAnalyzer.findMostConsonants(strings);
        System.out.println("Cele mai multe consoane: ");
        for (int i = 0; i < mostConsonants.length; i++) {
            System.out.println(mostConsonants[i]);
        }
    }

    /**
     * Parses the input string into an array of strings, splitting by semicolons.
     *
     * @param input the input string to parse
     * @return an array of strings
     */
    public String[] parseInput(String input) {
        // 1. Split the input by semicolons
        String[] result = input.split(",");
        // 2. Return the resulting array of strings
        return result;

    }

    /**
     * Finds the longest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the longest strings
     */
    public String[] findLongest(String[] strings) {

        // 1. Find the maximum string length in the array
        int longest = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > longest) {
                longest = strings[i].length();
            }
        }
        // 2. Collect all strings with that length
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == longest) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == longest) {
                result[index++] = strings[i];
            }
        }
        // 3. Return the array of longest strings
        return result;
    }

    /**
     * Finds the shortest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the shortest strings
     */
    public String[] findShortest(String[] strings) {
        // 1. Find the minimum string length in the array
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() < shortest) {
                shortest = strings[i].length();
            }
        }

        // 2. Collect all strings with that length
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == shortest) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < strings.length; i++) {


            if (strings[i].length() == shortest) {
                result[index++] = strings[i];
            }
        }
        // 3. Return the array of shortest strings
        return result;

    }

    /**
     * Counts the number of vowels in each string.
     *
     * @param strings the array of strings to analyze
     * @return a map from string to vowel count
     */
    public int[] countVowels(String[] strings) {
        // 1. Create a map to store the counts
        int[] vowels = new int[strings.length];

        // 2. For each string, count the vowels (a, e, i, o, u)
        String vocale = "aeiouyAEIOUY";
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (int j = 0; j < strings[i].length(); j++) {
                if (vocale.indexOf(strings[i].charAt(j)) != -1) {
                    count++;
                }
            }

            // 3. Store the counts in the map
            vowels[i] = count;
        }
        // 4. Return the map
        return vowels;
    }
// nu am vazut metoda dvs decat dupa ce am implementat deja asta dar am inteles si implementarea dvs de aceea nu am mai modificat

    /**
     * Counts the number of consonants in each string.
     *
     * @param strings the array of strings to analyze
     * @return an array of integers representing the consonant count for each string
     */
    public int[] countConsonants(String[] strings) {
        // TODO: Implement this method
        // 1. Create an array to store the counts
        int[] consonantCounts = new int[strings.length];
        // 2. For each string, count the consonants (non-vowels that are letters)
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char c : strings[i].toCharArray()) {
                if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1) {
                    count++;
                }
            }
            consonantCounts[i] = count;
        }
        // 3. Return the array
        return consonantCounts;
    }

    /**
     * Finds the string(s) with the most vowels.
     * If multiple strings have the same number of vowels, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most vowels
     */
    public String[] findMostVowels(String[] strings) {
        // 1. Count vowels in each string
        int[] vowelCount = countVowels(strings);


        // 2. Find the maximum vowel count
        int mostVowel = 0;
        for (int i = 0; i < vowelCount.length; i++) {
            if (vowelCount[i] > mostVowel) {
                mostVowel = vowelCount[i];
            }
        }
        // 3. Collect all strings with that count
        int count = 0;
        for (int i = 0; i < vowelCount.length; i++) {
            if (vowelCount[i] == mostVowel) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < vowelCount.length; i++) {
            if (vowelCount[i] == mostVowel) {
                result[index++] = strings[i];
            }
        }
        // 4. Return the array
        return result;
    }

    /**
     * Finds the string(s) with the most consonants.
     * If multiple strings have the same number of consonants, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most consonants
     */
    public String[] findMostConsonants(String[] strings) {

        // 1. Count consonants in each string
        int[] consonantCount = countConsonants(strings);
        // 2. Find the maximum consonant count
        int mostConsonant = 0;
        for (int i = 0; i < consonantCount.length; i++) {
            if (consonantCount[i] > mostConsonant) {
                mostConsonant = consonantCount[i];
            }
        }
        // 3. Collect all strings with that count
        int count = 0;
        for (int i = 0; i < consonantCount.length; i++) {
            if (consonantCount[i] == mostConsonant) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < consonantCount.length; i++) {
            if (consonantCount[i] == mostConsonant) {
                result[index++] = strings[i];

            }
        }
        // 4. Return the array
        return result;
    }
}