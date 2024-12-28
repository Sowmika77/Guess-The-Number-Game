import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("Rules: The system will generate a number between 1 and 100.");
        System.out.println("You need to guess it within the allowed attempts. Points will be awarded based on your performance.");

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10; // Limit the number of attempts
            int score = 100; // Starting score
            boolean guessedCorrectly = false;

            System.out.println("\nA new round has started! Guess the number between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                score -= 10; // Deduct 10 points for each attempt

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                System.out.println("Your score for this round: " + score);
            } else {
                System.out.println("Sorry! You've used all attempts. The correct number was " + randomNumber + ".");
                score = 0;
                System.out.println("Your score for this round: " + score);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing Guess the Number! Goodbye!");
    }
}
