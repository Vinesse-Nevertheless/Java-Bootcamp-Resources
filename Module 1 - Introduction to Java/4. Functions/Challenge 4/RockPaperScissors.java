import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");

        //Task 1: See if the user wants to play.
        String agreement = scan.nextLine();
    /*Task 2: Set up the game

       • if the answer is yes: 
             – print: Great!
             – print: rock – paper – scissors, shoot!
             – pick up user's choice.
             – get the computer choice (can only be done after task 3).
             – get the result (can only be done after task 4)
             – print everything (can only be done after task 5).

       • else:
             – print: Darn, some other time...!        
    */
        if (agreement.equals("yes")) {
            System.out.println("Great!");
            System.out.println("rock – paper – scissors, shoot!");
            String yourChoice = scan.nextLine();
            String computerChoice = computerChoice();
            String result = result(yourChoice, computerChoice);
            printResult(yourChoice, computerChoice, result);
        }else{
            System.out.println("Some other time then.");
        }

        scan.close();
    }

    //Task 3  – Write a function where the computer picks a random choice.

    /**
     * Function name: computerChoice - picks randomly between rock paper and scissors
     *
     * @return a choice (String).
     * <p>
     * Inside the function:
     * 1. Picks a random number between 0 and 2.
     * 2. if 0: returns the choice 'rock'
     * if 1: returns the choice 'paper'
     * if 2: returns the choice 'scissors'
     */
    public static String computerChoice() {
        int range = 2; //range needed to ensure choices are only 0,1,2
        double random = (Math.random() * range);
        int randomInt = (int) Math.rint(random); //rint produces a double that must be cast

        String choice = "";
       switch (randomInt) {
            case 0:
                choice = "rock";
            break;
            case 1:
                choice = "paper";
            break;
            case 2:
                choice = "scissors";
           default:
               throw new IllegalArgumentException("Not valid option");
        }
        return choice;
    }

    //Task 4  – Write a function that compares the choices and returns the result.

    /**
     * Function name: result - It returns the result of the game.
     *
     * @param yourChoice     (String)
     * @param computerChoice (String)
     * @return result (String)
     * <p>
     * Inside the function:
     * 1. result is "You win" if:
     * <p>
     * You: "rock"      Computer: "scissors"
     * You: "paper"     Computer: "rock"
     * You: "scissors"  Computer: "paper"
     * <p>
     * 2. result is "You lose" if:
     * <p>
     * Computer: "rock"      You: "scissors"
     * Computer: "paper"     You: "rock"
     * Computer: "scissors"  You: "paper"
     * <p>
     * 3. result is "It's a tie" if:
     * <p>
     * your choice equals computer choice.
     */

    public static String result (String yourChoice, String computerChoice) {

        Map <String, String> winner = new HashMap<>();
        winner.put("rock", "scissors");
        winner.put("paper", "rock");
        winner.put("scissors", "paper");

        String result = "It's a tie";
        //There's no need to loop looking for matches if the choices are the same.
        if(yourChoice.equals(computerChoice)){
            return result;
        }
        /*
        Even the course hasn't taught collection yet, I used maps to create a key/value
        of the winning combos. key = winner & value = loser.
        If key matches player choice & value matches computer choice,
        player wins.  If key matches computer choice & value matches player choice, the
        computer wins.
         */
        for(String key: winner.keySet()) {
            if (key.equals(yourChoice) && winner.get(yourChoice).equals(computerChoice)){
                result = "You win";
            }else if (key.equals(computerChoice) && winner.get(computerChoice).equals(yourChoice)){
                result = "You lose";
            }
        }
        return result;
    }

    //Task 5  – Write a function that prints your choice, the computer's, and the result.

    /**
     * Name: printResult - It prints everything (your choice, computer choice, result)
     * @param yourChoice (String)
     * @param computerChoice (String)
     * @param result (String)
     *
     * Inside the function:
     *
     *  1. prints everything:
     *      – prints: You chose:          <your choice>
     *      – prints: The computer chose: <computer choice>
     *      – prints: <result>
     */
    public static void printResult(String yourChoice, String computerChoice, String result){
        System.out.println("You chose: " + yourChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result);
    }

}
