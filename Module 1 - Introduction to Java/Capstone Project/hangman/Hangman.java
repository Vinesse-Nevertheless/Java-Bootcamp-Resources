import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    private static Scanner scan = new Scanner(System.in);
    private static String[] flippingLetters;
    private static String hiddenWord;
    private static String[] hiddenLetters;
    private static String missedGuess;


    private static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    private static String[] gallows = {"+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"};

    public static void main(String[] args) {
        hiddenWord = chooseWord();
      //  System.out.println(hiddenWord);
        hiddenLetters = hiddenWord.split("");
        int missedCount = 0;
        missedGuess = "";
        flippingLetters = new String[hiddenLetters.length];
        Arrays.fill(flippingLetters, "_");

        while (true) {
            showGallows(missedCount);
            printPlaceholders();
            printMissedGuesses(missedGuess);

            String guess = showGuesses();
            boolean isCorrectGuess = true;
            try{
                isCorrectGuess = checkGuess(guess);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }

            if(isCorrectGuess){
                updatePlaceholders(guess);
            }else{
                missedGuess += guess;
                printMissedGuesses(missedGuess);
                missedCount ++;
            }

            if (missedGuess.length() == gallows.length - 1){
                showHung(missedCount);
                break;
            }else if (Arrays.equals(flippingLetters, hiddenLetters)){
                showWon(missedCount);
                break;
            }
        }
        scan.close();
    }

    public static String chooseWord() {
        double randomInt = Math.random() * words.length;
        return words[(int) randomInt];
    }

    public static void showGallows(int misses) {
        System.out.print("\n" + gallows[misses]);
    }

    public static boolean checkGuess(String guess) {
        if(Character.isDigit(guess.charAt(0)) || missedGuess.contains(guess)){
            throw new IllegalArgumentException("Invalid guess. Please try again.");
        }
        for (int i = 0; i < hiddenLetters.length; i++) {
            if (guess.equalsIgnoreCase(hiddenLetters[i])) {
                return true;
            }
        }
        return false;
    }

    //placeholders are the underscores
    public static void updatePlaceholders(String guess) {
        for (int i = 0; i < hiddenLetters.length; i++) {
            if (hiddenLetters[i].equalsIgnoreCase(guess)){
                flippingLetters[i] = guess;
            }
        }
    }

    public static void printPlaceholders(){
        System.out.print("Word: \t");
        for (int i = 0; i < flippingLetters.length; i++) {
            System.out.print(flippingLetters[i].concat(" "));
        }
    }

    public static void printMissedGuesses(String missedGuess){
        System.out.print("\n\nMisses: ");
        System.out.print(missedGuess);
    }

    public static String showGuesses() {
        System.out.print("\n\nGuess: ");
        return scan.nextLine();
    }

    public static void showHung(int missedCount){
        showGallows(missedCount);
        System.out.println("RIP!");
        System.out.println("\nThe answer was " + "'" + hiddenWord + "'.");
    }

    public static void showWon(int missedCount){
        showGallows(missedCount);
        System.out.println();
        printPlaceholders();
        System.out.println("\n\nGOOD WORK!");
    }
}

