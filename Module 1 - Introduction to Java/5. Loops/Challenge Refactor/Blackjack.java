import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);
    public static int yourCard1Value;
    public static int yourCard2Value;
    public static int dealerCard1Value;
    public static int dealerCard2Value;

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        //Initial display
        boolean isCardFaceDown = true;
        showPlayerHand();
        showDealerHand(isCardFaceDown);

        //player plays
        int yourSum = yourCard1Value + yourCard2Value;
        yourSum = dealPlayerHand(yourSum);

        //dealer plays
        System.out.println("Dealer's turn");
        showDealerHand(!isCardFaceDown);
        int dealerSum = dealerCard1Value + dealerCard2Value;
        dealerSum = dealDealerHand(dealerSum);

        //determine winner
        determineWinner(yourSum, dealerSum);

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
    public static int getRandomCardNumber() {
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
    public static String getCardDrawing(int cardNumber) {
        CardFactory card = new Card().createCard(cardNumber);
        return card.drawCard();
    }

    public static void showPlayerHand() {
        yourCard1Value = getRandomCardNumber();
        yourCard2Value = getRandomCardNumber();

        System.out.println("You get a \n" + getCardDrawing(yourCard1Value)
                + "\n and a \n" + getCardDrawing(yourCard2Value));
    }

    public static void showDealerHand(boolean faceDown) {
        dealerCard1Value = getRandomCardNumber();
        dealerCard2Value = getRandomCardNumber();

        if (faceDown) {
            System.out.println("The dealer shows \n" + getCardDrawing(dealerCard1Value) +
                    "\n and has a card facing down \n" + faceDown());
        } else {
            System.out.println(" The dealer's cards are \n" + getCardDrawing(dealerCard1Value)
                    + "\n and a \n" + getCardDrawing(dealerCard2Value));
        }
    }

    public static int dealPlayerHand(int yourSum) {
        while (true) {
            determineBust(yourSum, "Player");
            String answer = hitOrStay();
            if (answer.equals("stay")) {
                break;
            } else if (answer.equals("hit")) {
                int randomCard = getRandomCardNumber();
                yourSum += randomCard;
                System.out.println("You get a \n" + getCardDrawing(randomCard));
                System.out.println("Your new total is " + yourSum);
            }
        }
        return yourSum;
    }

    public static int dealDealerHand(int dealerSum) {
        while (dealerSum < 17) {
            int randomCard = getRandomCardNumber();
            dealerSum += randomCard;
            System.out.println("Dealer gets a \n" + getCardDrawing(randomCard));
            System.out.println("Dealer's total is " + dealerSum);
        }
        determineBust(dealerSum, "Dealer");
        return dealerSum;
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

    public static void determineBust(int sum, String player) {
        if (sum > 21) {
            System.out.println("Bust! " + player + " loses.");
            System.exit(0);
        }
    }

    public static void determineWinner(int yourSum, int dealerSum) {
        if (yourSum > dealerSum) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
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
        while (true) {
            System.out.println("Do you want to take a hit or stay?");
            String answer = scan.nextLine();
            if (answer.equals("stay")) {
                return "stay";
            } else if (answer.equals("hit")) {
                return "hit";
            } else {
                System.out.println("Please write 'hit' or 'stay'.");
            }
        }
    }
}

