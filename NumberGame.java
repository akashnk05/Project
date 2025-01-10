package p1;
import java.util.Random;
import java.util.Scanner;
public class NumberGame_01 {

	    // Game settings
	    private static final int MIN_NUMBER = 1;
	    private static final int MAX_NUMBER = 100;
	    private static final int MAX_ATTEMPTS = 10;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean playAgain = true;

	        System.out.println("Welcome to the Number Guessing Game!");
	        System.out.println("Try to guess the number I'm thinking of, between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");

	        while (playAgain) {
	            playRound(scanner); // Play one round of the game
	            playAgain = askToPlayAgain(scanner); // Check if the user wants to play again
	        }

	        System.out.println("Thank you for playing! Goodbye!");
            scanner.close();
	    }
	    

	    // Method to play a single round of the game
	    private static void playRound(Scanner scanner) {
	        Random random = new Random();
	        int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER; // Generate random number
	        int attempts = 0;

	        System.out.println("\nA new number has been generated. You have " + MAX_ATTEMPTS + " attempts to guess it!");

	        while (attempts < MAX_ATTEMPTS) {
	            int userGuess = getUserGuess(scanner, attempts + 1); // Get the user's guess
	            attempts++;

	            if (userGuess == randomNumber) {
	                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
	                return; // End the round if guessed correctly
	            } else if (userGuess > randomNumber) {
	                System.out.println("Too high! Try again.");
	            } else {
	                System.out.println("Too low! Try again.");
	            }
	        }

	        // If the user runs out of attempts
	        System.out.println("You've used all your attempts! The correct number was " + randomNumber + ".");
	    }

	    // Method to get a valid user guess
	    private static int getUserGuess(Scanner scanner, int attempt) {
	        System.out.print("Attempt " + attempt + " - Enter your guess: ");
	        while (!scanner.hasNextInt()) { // Validate input
	            System.out.println("Invalid input! Please enter a valid number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
	            scanner.next(); // Clear invalid input
	            System.out.print("Enter your guess: ");
	        }
	        return scanner.nextInt();
	    }

//	    // Method to ask the user if they want to play again
	    private static boolean askToPlayAgain(Scanner scanner) {
	        System.out.print("Do you want to play again? (yes/no): ");
	        String response = scanner.next().trim().toLowerCase();
	        while (!response.equals("yes") && !response.equals("no")) {
	            System.out.print("Invalid input! Please type 'yes' or 'no': ");
	            response = scanner.next().trim().toLowerCase();
	        }
	        return response.equals("yes");
	        }
	}


