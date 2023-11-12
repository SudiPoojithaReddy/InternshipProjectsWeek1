import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerbound = 1;
        int upperbound = 100;
        int randomNumber = random.nextInt(upperbound - lowerbound + 1) + lowerbound;
        int attempts = 0;

        System.out.println("Welcome to Number Guessing Game!!!");
        System.out.println("I have selected a random number between " + lowerbound + " and " + upperbound+ ". Try to guess it!");
        
        while (true) {
            System.out.println("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            
            if (userGuess < lowerbound || userGuess > upperbound) {
                System.out.println("Please enter a number within the bounds.");
            } else if (userGuess < randomNumber) {
                System.out.println("The number is higher. Try again.");
            } else if (userGuess > randomNumber){
                System.out.println("The number is lower. Try again.");
            } else {
                System.out.println("Congratulations!!! You have guessed the number in " + attempts + " attempts.");
                break;
            }
        }

        scanner.close();
    }
}