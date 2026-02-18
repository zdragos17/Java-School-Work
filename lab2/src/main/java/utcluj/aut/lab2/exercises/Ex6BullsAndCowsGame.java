package utcluj.aut.lab2.exercises;

import java.util.Random;
import java.util.Scanner;


/**
 * Class implementing the Bulls and Cows number guessing game.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex6BullsAndCowsGame {
    private String secretNumber;

    /**
     * Creates a new game with a random secret number.
     */
    public Ex6BullsAndCowsGame() {
        this.secretNumber = generateSecretNumber();
    }

    /**
     * Creates a new game with the specified secret number (for testing).
     *
     * @param secretNumber the secret number to use
     */
    public Ex6BullsAndCowsGame(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    /**
     * Generates a random 4-digit number with no repeated digits.
     *
     * @return a string representing the 4-digit number
     */
    public static String generateSecretNumber() {
        // 1. Generate 4 unique random digits (no repeats)
        Random random = new Random();
        String secretNum = "";

        while (secretNum.length() < 4) {
            int digit = random.nextInt(10);

            if (secretNum.indexOf(String.valueOf(digit)) == -1) {
                secretNum += digit;
            }
        }

        // 3. Concatenate them into a string
        // Concatenerile se fac automat in secretNum

        // 4. Return the string
        return secretNum;
    }

    public static void main(String[] args) {
        Ex6BullsAndCowsGame game = new Ex6BullsAndCowsGame();
        game.play();
    }

    /**
     * Evaluates a guess against the secret number.
     *
     * @param guess the guess to evaluate
     * @return an array with [bulls, cows]
     * @throws IllegalArgumentException if the guess is invalid
     */
    public int[] evaluateGuess(String guess) {

        if (guess.length() != 4) {
            throw new IllegalArgumentException("The guess must be exactly 4 digits.");
        }
        if (!guess.matches("[0-9]{4}")) {
            throw new IllegalArgumentException("The guess must contain only digits.");
        }


        for (int i = 0; i < guess.length(); i++) {
            for (int j = i + 1; j < guess.length(); j++) {
                if (guess.charAt(i) == guess.charAt(j)) {
                    throw new IllegalArgumentException("The guess must not contain repeated digits.");
                }
            }
        }


        if (secretNumber == null) {
            secretNumber = generateSecretNumber();
        }


        int bulls = 0;
        boolean[] secretUsed = new boolean[4];
        boolean[] guessUsed = new boolean[4];

        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                bulls++;
                secretUsed[i] = true;
                guessUsed[i] = true;
            }
        }


        int cows = 0;
        for (int i = 0; i < 4; i++) {
            if (!guessUsed[i]) {
                for (int j = 0; j < 4; j++) {
                    if (guess.charAt(i) == secretNumber.charAt(j) && !secretUsed[j] && i != j) {
                        cows++;
                        secretUsed[j] = true;
                        break;
                    }
                }
            }
        }


        return new int[]{bulls, cows};
    }

    /**
     * Plays the game with a predetermined list of guesses (for testing).
     *
     * @param guesses the list of guesses to try
     * @return the number of attempts needed to guess correctly
     */
    public int playTestGame(String[] guesses) {
        // 1. Iterate through each guess
        for (int attempt = 0; attempt < guesses.length; attempt++) {
            String guess = guesses[attempt];

            // 2. Evaluate the guess
            int[] result = evaluateGuess(guess);
            int bulls = result[0];

            // 3. If all bulls, return the number of attempts
            if (bulls == 4) {
                return attempt + 1;
            }
        }

        // 4. If no correct guess, return the number of guesses
        return guesses.length;
    }

    /**
     * Plays an interactive game with user input.
     */
    public void play() {
        // 1. Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean guessedCorrectly = false;

        // 2. Loop until the user guesses correctly
        while (!guessedCorrectly) {
            // 3. Validate and evaluate each guess
            System.out.print("Introduce-ti o incercare: ");
            String guess = scanner.nextLine();


            if (guess.length() != 4 || !guess.matches("[0-9]{4}")) {
                System.out.println("Invalid , trebuie fix 4 cifre");
                continue;
            }

            // 4. Evaluate the guess
            int[] result = evaluateGuess(guess);
            int bulls = result[0];
            int cows = result[1];

            // 5. Display the number of bulls and cows
            System.out.println("Bulls: " + bulls + ", Cows: " + cows);

            // 6. Track the number of attempts
            attempts++;

            // 7. If all bulls, user guessed correctly
            if (bulls == 4) {
                guessedCorrectly = true;
                System.out.println("Ati ghicit din: " + attempts + " incercari");
            }
        }
    }
}
