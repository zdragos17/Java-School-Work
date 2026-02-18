package utcluj.aut.lab2.exercises;

import javax.swing.plaf.synth.SynthTreeUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Application that manages student records using only Strings and arrays.
 * The program allows users to input student records, filter them by grade,
 * and sort them by different criteria.
 * Students should implement all methods to complete the exercise.
 */
public class Ex4StudentRecordManager {

    /**
     * Parses a student record from a string in the format "name,age,grade".
     *
     * @param record the record string to parse
     * @return a string array with [name, age, grade] or null if invalid format
     */
    public static String[] parseStudentRecord(String record) {
        // 1. Split the record by commas
        String[] parts = record.split(",");
        // 2. Validate that there are exactly 3 parts
        // 4. Return null or handle invalid formats appropriately
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid record format. Expected format: name, age, grade");
        }
        // 3. Return a string array with [name, age, grade]
        return parts;
    }

    /**
     * Filters student records by a minimum grade threshold.
     *
     * @param records  array of student records, each record is [name, age, grade]
     * @param minGrade the minimum grade threshold as a string
     * @return array of filtered student records
     */
    public static String[][] filterByGrade(String[][] records, String minGrade) {
        // 1. Convert the minimum grade threshold to an integer
        int minGradeInt = Integer.parseInt(minGrade.trim());

        // 2. Count how many records meet the criteria
        int countGrade = 0;
        for (int i = 0; i < records.length; i++) {
            int gradeValue = Integer.parseInt(records[i][2].trim());
            if (gradeValue >= minGradeInt) {
                countGrade++;
            }
        }

        // 3. Create a new array of arrays to hold the filtered records
        String[][] filteredRecords = new String[countGrade][3];

        // 4. Add records with grade >= minGrade to the new array
        int index = 0;
        for (int i = 0; i < records.length; i++) {
            int gradeValue = Integer.parseInt(records[i][2].trim());
            if (gradeValue >= minGradeInt) {
                filteredRecords[index] = records[i];
                index++;
            }
        }

        // 5. Return the filtered records
        return filteredRecords;
    }


    /**
     * Sorts student records by the given criteria.
     *
     * @param records   array of student records, each record is [name, age, grade]
     * @param sortBy    the sorting criteria ("name", "age", or "grade")
     * @param ascending true for ascending order, false for descending
     * @return a new array with sorted student records
     */
    public static String[][] sortRecords(String[][] records, String sortBy, boolean ascending) {
        // 1. Create a copy of the records array to avoid modifying the original
        String[][] copyRecords = new String[records.length][];
        for (int i = 0; i < records.length; i++) {
            copyRecords[i] = records[i];
        }

        // 2. Determine which index to sort by based on sortBy (0 for name, 1 for age, 2 for grade)
        int index = -1;
        if (sortBy.equals("name")) {
            index = 0;
        }
        if (sortBy.equals("age")) {
            index = 1;
        }
        if (sortBy.equals("grade")) {
            index = 2;
        }

        // 3. Implement a sorting algorithm (e.g., bubble sort) to sort the records
        for (int i = 0; i < copyRecords.length - 1; i++) {
            for (int j = i + 1; j < copyRecords.length; j++) {
                String[] record1 = copyRecords[i];
                String[] record2 = copyRecords[j];

                int comparisonResult = 0;
                if (index == 0) {
                    comparisonResult = record1[0].compareTo(record2[0]);
                } else if (index == 1) {
                    int age1 = Integer.parseInt(record1[1]);
                    int age2 = Integer.parseInt(record2[1]);
                    comparisonResult = Integer.compare(age1, age2);
                } else if (index == 2) {
                    int grade1 = Integer.parseInt(record1[2]);
                    int grade2 = Integer.parseInt(record2[2]);
                    comparisonResult = Integer.compare(grade1, grade2);
                }

                if (ascending ? comparisonResult > 0 : comparisonResult < 0) {
                    String[] temp = copyRecords[i];
                    copyRecords[i] = copyRecords[j];
                    copyRecords[j] = temp;
                }
            }
        }

        // 4. Return the sorted array
        return copyRecords;
    }


    /**
     * Displays student records in a formatted way.
     *
     * @param records array of student records to display
     */
    public static void displayRecords(String[][] records) {
        // 1. Check if there are any records to display
        if (records.length == 0 || records == null) {
            return;
        }

        // 2. Display a header for the output
        System.out.println("Name\tAge\tGrade");
        System.out.println("------------------------");
        // 3. Iterate through each record and format it for display
        for (int i = 0; i < records.length; i++) {
            // 4. Display each record on a separate line
            String[] record = records[i];
            if (record.length == 3) {
                System.out.println(record[0] + "\t" + record[1] + "\t" + record[2]);
            }
        }
    }

    /**
     * Prompts for and reads user input for filtering and sorting options.
     *
     * @return a string array with [minGrade, sortBy, ascending]
     */
    public static String[] getFilterAndSortOptions() {
        // 1. Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // 2. Prompt the user for minimum grade threshold
        System.out.print("introduceti pragul minim pentru nota: ");
        String minGrade = scanner.nextLine();
        // 3. Prompt the user for sorting criteria (name, age, or grade)
        System.out.print("introduceti criteriul de sortare : ");
        String sortCriteria = scanner.nextLine().toLowerCase();
        // 4. Prompt the user for sorting order (ascending or descending)
        System.out.print("introduceti ordinea de sortare: ");
        String sortOrder = scanner.nextLine().toLowerCase();
        // 5. Return the options as a string array
        return new String[]{minGrade, sortCriteria, sortOrder};
    }

    /**
     * Checks if a string can be parsed as an integer.
     *
     * @param str the string to check
     * @return true if the string is a valid integer, false otherwise
     */
    public static boolean isInteger(String str) {
        // 1. Try to parse the string as an integer
        // 2. Return true if successful, false if it causes an exception
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Main method that runs the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // 1. Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // 2. Prompt the user to enter student records (name,age,grade) on separate line
        System.out.println("introduceti datele studentilor (name, age, grade) sau 'done' pentru a termina:");

        List<String[]> recordsList = new ArrayList<>();
        // 3. Read and store the records until the user indicates they're done
        while (true) {
            System.out.print("int (name, age, grade): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            String[] studentRecord = parseStudentRecord(input);
            if (studentRecord != null) {
                recordsList.add(studentRecord);
            } else {
                System.out.println("invalid.");
            }
        }

        String[][] records = recordsList.toArray(new String[0][]);

        // 4. Allow the user to filter records by minimum grade
        String[] options = getFilterAndSortOptions();
        String minGrade = options[0];
        String sortCriteria = options[1];
        boolean ascending = options[2].equals("ascending");

        // 5. Allow the user to sort the filtered records
        String[][] filteredRecords = filterByGrade(records, minGrade);
        String[][] sortedRecords = sortRecords(filteredRecords, sortCriteria, ascending);
        // 6. Display the filtered and sorted records
        System.out.println("\nRezultate filtrate și sortate:");
        displayRecords(sortedRecords);

        scanner.close();
    }
}
