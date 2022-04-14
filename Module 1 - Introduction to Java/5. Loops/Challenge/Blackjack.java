import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        //Task 3 – Wait for the user to press enter.
        scan.nextLine();
        //Task 4 – Get two random cards.
        //       – Print them: \n You get a \n" + <randomCard> + "\n and a \n" + <randomCard>

        int yourFirstCard = drawRandomCard();
        int yourSecondCard = drawRandomCard();

        System.out.println("You get a \n" + cardNumber(yourFirstCard)
                + "\n and a \n" + cardNumber(yourSecondCard));

        //Task 5 – Print the sum of your hand value.
        //       – print: your total is: <hand value>
        yourFirstCard = Math.min(10, yourFirstCard);
        yourSecondCard = Math.min(10, yourSecondCard);
        int yourSum = yourFirstCard + yourSecondCard;

        System.out.println("Your total is " + yourSum);
        //Task 6 – Get two random cards for the dealer.
        //       – Print: The dealer shows \n" + <first card> + "\nand has a card facing down \n" + <facedown card>
        //       – Print: \nThe dealer's total is hidden

        int dealerFirstCard = drawRandomCard();
        int dealerSecondCard = drawRandomCard();

        dealerFirstCard = Math.min(10, yourFirstCard);
        dealerSecondCard = Math.min(10, yourSecondCard);
        System.out.println("The dealer shows \n" + cardNumber(dealerFirstCard) +
                "\n and has a card facing down \n" + faceDown());

        //Task 8 – Keep asking the player to hit or stay (while loop).
        //       1. Every time the player hits
        //             – draw a new card.
        //             – calculate their new total.
        //             – print: (new line) You get a (new line) <show new card>.
        //             - print: your new total is <total>

        //       2. Once the player stays, break the loop.
        while (true) {
            String answer = hitOrStay();
            if (answer.equalsIgnoreCase("stay")) {
                break;
            } else if (answer.equalsIgnoreCase("hit")) {
                int randomCard = drawRandomCard();
                yourSum += randomCard;
                System.out.println("You get a \n" + cardNumber(randomCard));
                System.out.println("Your new total is " + yourSum);
            }
            if (yourSum > 21) {
                System.out.println("Bust! Player loses.");
                System.exit(0);
            }
        }

        int dealerSum = dealerFirstCard + dealerSecondCard;
        System.out.println("Dealer's turn");
        System.out.println(" The dealer's cards are \n" + cardNumber(dealerFirstCard)
                + "\n and a \n" + cardNumber(dealerSecondCard));
        System.out.println("Dealer's total is " + dealerSum);

        while (dealerSum < 17) {
            int randomCard = drawRandomCard();
            dealerSum += randomCard;
            System.out.println("Dealer gets a \n" + cardNumber(randomCard));
            System.out.println("Dealer's total is " + dealerSum);
        }

        if (dealerSum > 21) {
            System.out.println("Bust! Dealer loses.");
            System.exit(0);
        }

        if (yourSum > dealerSum) {
            System.out.println("Player wins!");
        } else if (dealerSum > yourSum) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie");
        }
        //For tasks 9 to 13, see the article: Blackjack Part II. 
        scan.close();

    }

    /**
     * Task 1 – make a function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     *
     * @return (int)
     * <p>
     * Inside the function:
     * 1. Gets a random number between 1 and 13.
     * 2. Returns a card.
     */
    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13;
        int randomInt = 1 + (int) randomNumber;
        return randomInt;
    }

    /**
     * Task 2 – make a function that returns a String drawing of the card.
     * Function name – cardString
     *
     * @param cardNumber (int)
     * @return (String)
     * <p>
     * Inside the function:
     * 1. Returns a String drawing of the card.
     */
    public static String cardNumber(int cardNumber) {
        CardFactory card = new Card().createCard(cardNumber);
        return card.drawCard();
    }

    public static String faceDown() {
        return
                "   _____\n" +
                        "  |     |\n" +
                        "  |  J  |\n" +
                        "  | JJJ |\n" +
                        "  |  J  |\n" +
                        "  |_____|\n";
    }

    /**
     * Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     *
     * @return (String)
     * <p>
     * Inside the function:
     * 1. Asks the user to hit or stay.
     * 2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     * Please write 'hit' or 'stay'
     * 3. Returns the user's option
     */

    public static String hitOrStay() {
        System.out.println("Do you want to take a hit or stay?");
        String answer = scan.nextLine();
        while (!(answer.equalsIgnoreCase("stay") || answer.equalsIgnoreCase("hit"))) {
            System.out.println("Please write 'hit' or 'stay'.");
            answer = scan.nextLine();
        }
        return answer;
    }
}

