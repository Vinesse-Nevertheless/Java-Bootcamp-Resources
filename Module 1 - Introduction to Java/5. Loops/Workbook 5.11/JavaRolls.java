import java.util.Scanner;

public class JavaRolls {
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      
        /* Task 1: 
              1. print: Let's play Rolling Java. Type anything to start.
              2. Get the user to enter any value
        */
        System.out.println("Let's play Rolling Java. Type anything to start.");
        scan.nextLine();

        /* Task 2: 
              1. Once the user is ready, print: 
                    Great, here are the rules:\n
                     - If you roll a 6 the game stops.
                     - If you roll a 4 nothing happens.
                     - Otherwise, you get 1 point.\n
                    You must collect at least 3 points to win. Enter anything to roll:
              2. Get the user to enter any value
        */
        System.out.println("Great, here are the rules:\n" +
                "\t - If you roll a 6 the game stops.\n" +
                "\t - If you roll a 4 nothing happens.\n" +
                "\t - Otherwise, you get 1 point.\n" +
                "You must collect at least 3 points to win. Enter anything to roll:");

        scan.nextLine();

       /* 
         Task 3
          1. Make a while loop that runs forever
          2. During each run, get them to enter a random value

          
          Task 5
           1. During each run, call the rollDice() function.
           2. Print each dice roll like so: You rolled a <diceRoll>.           
           
          
          Task 6
            If the user rolls a 6:
              1. print: End of game.
              2. stop the game. 

            If the user rolls a 4:
              1. print: Zero points. Keep rolling. 

            If the user rolls anything else:
              1. update the points variable by 1
              2. print: One point. Keep rolling. 

       */

        //Tried clean coding practice of using enums to avoid
        //magic numbers.
        while (true) {
            int currentRoll = rollDice();
            System.out.println("You rolled a " + currentRoll + ".");
            if (currentRoll == MagicNumbers.GAMEOVER.getValue()) {
                System.out.println("End of game.");
                break;
            } else if (currentRoll == MagicNumbers.ZEROPOINTS.getValue()) {
                System.out.println("Zero points. Keep rolling.");
            } else {
                score += 1;
                System.out.println("One point. Keep rolling");
            }
        }
        printResults();
    }


    /**
     * Task 4
     * Function name: rollDice – rolls a dice between 1 and 6
     *
     * @return randomNumber (int)
     */
    public static int rollDice() {
        double randomNumber = Math.random() * 6;
        randomNumber += 1;
        return (int) randomNumber;
    }

    public static void printResults() {
          /*  1.  After the game ends, check the user's points.

            System.out.println("\nYour score is: " + score);

            2. If the score is greater than or equal to 3, print:
            Wow, that's lucky. You win!
            Otherwise, print:
            Tough luck, you lose :(
                    */
        System.out.println("\nYour score is: " + score);
        if (score >= 3) {
            System.out.println("Wow, that's lucky. You win!");
        } else {
            System.out.println("Tough luck, you lose :( ");
        }
    }
}
