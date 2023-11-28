import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    private static int playerScore = 0;
    private static int computerScore = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();

        String[] options = {ROCK, PAPER, SCISSORS};

        System.out.println("Welcome to Rock-Paper-Scissors game!");

        while (true) {
            System.out.print("Choose [r]ock, [p]aper, or [s]cissors: ");
            String playerChoice = getPlayerChoice();

            String computerChoice = options[random.nextInt(options.length)];

            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);

            if (result.equals("You win!")) {
                playerScore++;
            } else if (result.equals("Computer wins!")) {
                computerScore++;
            }

            displayScores();

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static String getPlayerChoice() {
        String playerMove = scanner.nextLine().toLowerCase();
        if (playerMove.equals("r") || playerMove.equals("rock")) {
            return ROCK;
        } else if (playerMove.equals("p") || playerMove.equals("paper")) {
            return PAPER;
        } else if (playerMove.equals("s") || playerMove.equals("scissors")) {
            return SCISSORS;
        } else {
            System.out.println("Invalid choice. Please enter [r]ock, [p]aper, or [s]cissors.");
            return getPlayerChoice();
        }
    }

    private static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a draw!";
        } else if (
                (playerChoice.equals(ROCK) && computerChoice.equals(SCISSORS)) ||
                        (playerChoice.equals(SCISSORS) && computerChoice.equals(PAPER)) ||
                        (playerChoice.equals(PAPER) && computerChoice.equals(ROCK))
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    private static void displayScores() {
        System.out.println("Scores: Player -> " + playerScore + ", Computer -> " + computerScore);
    }
}
