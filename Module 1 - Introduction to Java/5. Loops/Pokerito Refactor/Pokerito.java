import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/*
Decide to practice the factory pattern.
 */
public class Pokerito {
    private static int yourMatches;
    private static int computerMatches;
    private static String yourCard;
    private static String computerCard;
    private static List<String> currentCards;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        showRules();

        drawStartCards();

        drawFiveCards();

        calculateMatches();

        showWinner();

    }

    public static void showRules() {
        System.out.println("Let's play Pokerito. Type anything when you're ready.");
        scan.nextLine();
        System.out.println("It's like Poker, but a lot simpler.\n" +
                "\n" +
                "\t• There are two players, you and the computer.\n" +
                "\t• The dealer will give each player one card.\n" +
                "\t• Then, the dealer will draw five cards (the river)\n" +
                "\t• The player with the most river matches wins!\n" +
                "\t• If the matches are equal, everyone's a winner!\n" +
                "\n" +
                "\t• Ready? Type anything if you are.");
        scan.nextLine();
    }

    public static void drawStartCards() {
        System.out.println("Here's your card:");
        yourCard = getRandomCard();
        printCard(yourCard);

        System.out.println("\nHere's the computer's card:");
        computerCard = getRandomCard();
        printCard(computerCard);
    }

    public static void drawFiveCards() {
        System.out.println("Now, the dealer will draw five cards. Press enter to continue.");
        currentCards = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            scan.nextLine();
            System.out.println("Card " + i);
            String currentCard = getRandomCard();
            printCard(currentCard);
            currentCards.add(currentCard);
        }
    }

    public static String getRandomCard() {
        double randomNumber = Math.random() * 13;
        int randomInt = 1 + (int) randomNumber;
        CardFactory card = new Card().createCard(randomInt);
        return card.dealCard();
    }

    public static void calculateMatches() {
        for (String currentCard : currentCards) {
            if (yourCard.equals(currentCard)) {
                yourMatches++;
            } else if (computerCard.equals(currentCard)) {
                computerMatches++;
            }
        }
    }

    public static void printCard(String card) {
        System.out.println(card);
    }

    public static void showWinner() {
        System.out.println("Your number of matches: " + yourMatches);
        System.out.println("Computer number of matches: " + computerMatches);
        if (yourMatches > computerMatches) {
            System.out.println("You win!");
        } else if (computerMatches > yourMatches) {
            System.out.println("The computer wins!");
        } else {
            System.out.println("Everyone wins!");
        }
    }
}
