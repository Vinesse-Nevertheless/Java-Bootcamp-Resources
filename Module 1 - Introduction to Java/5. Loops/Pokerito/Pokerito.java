import java.util.Scanner;
/*
Decide to practice the factory pattern.
 */
public class Pokerito {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {


        /*Task 2: Explain the rules

        >>Let's play Pokerito. Type anything when you're ready.
        |
        >>It's like Poker, but a lot simpler.
        >> (new line)
        >> • There are two players, you and the computer.
        >> • The dealer will give each player one card.
        >> • Then, the dealer will draw five cards (the river)
        >> • The player with the most river matches wins!
        >> • If the matches are equal, everyone's a winner!
        >> (new line)
        >> • Ready? Type anything if you are.
        |
        */
        System.out.println("Let's play Pokerito. Type anything when you're ready.");
        scan.nextLine();

       showRules();

        /*Task 3: Present the user with a card
         println 'Here's your card:'
         <show card>
         <new line>
         println 'Here's the computer's card:'
         <show computer's card>
        */
        System.out.println("Here's your card:");
        String yourCard = randomCard();
        printCard(yourCard);
        System.out.println("\nHere's the computer's card:");
        String computerCard = randomCard();
        printCard(computerCard);



        /** Task 4 - Draw five cards
         * 
         * • print:  Now, the dealer will draw five cards. Press enter to continue.
         * • The dealer will draw a card every time the user presses enter.
         * • Before you draw a card, print the order it was drawn in:
         *      Card 1 
         *      <2 new lines>
         *      <print card>
         *      Card 2
         *      <2 new lines>
         *      <print card>
         *      ...
         */

        int yourMatches = 0;
        int computerMatches =0;
        System.out.println("Now, the dealer will draw five cards. Press enter to continue.");
        for (int i = 1; i < 6; i++) {
            scan.nextLine();
            System.out.println("Card " + i);
            String currentCard = randomCard();
            printCard(currentCard);
            if (yourCard.equals(currentCard)){
                yourMatches++;
            }else if (computerCard.equals(currentCard)){
                computerMatches++;
            }
        }

        /** Task 5 - Get the winner
         * 
         * • Count your number of matches.
         * • Count the computer's number of matches.
         * • print: Your number of matches: <yourMatches>
         * • print: Computer number of matches:  <computerMatches>
         * 
         * • If you have more matches, print: You win!. 
         * • If the computer has more matches, print: The computer wins! 
         * • If the matches are equal, print: everyone wins!.
         */

        showWinner(yourMatches, computerMatches);

    }

    /** Task 1
     * 
     * Function name – randomCard
     * @return (String)
     * 
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card that matches the random number (get the String values from cards.text).   
     */

    public static void showRules(){
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

    public static String randomCard(){
        double randomNumber = Math.random() * 13;
        int randomInt = 1 + (int) randomNumber;
        CardFactory card = new Card().createCard(randomInt);
        return card.dealCard();
    }

    public static void printCard(String card){
        System.out.println(card);
    }

    public static void showWinner(int yourMatches, int computerMatches){
        System.out.println("Your number of matches: " + yourMatches);
        System.out.println("Computer number of matches: " + computerMatches);
        if (yourMatches > computerMatches){
            System.out.println("You win!");
        }else if (computerMatches > yourMatches){
            System.out.println("The computer wins!");
        }else{
            System.out.println("Everyone wins!");
        }
    }
}
