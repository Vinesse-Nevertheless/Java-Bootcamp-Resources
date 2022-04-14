package src.main;

import src.main.models.Game;
import src.main.models.Team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static Game game;
    static final String TEAMS_FILE = "src/main/teams.txt";
    static final String PLAYS_FILE = "src/main/plays.txt";

    public static void main(String[] args) {
        String[][] data = null;
        try {
            data = getData();

           game = new Game(
                    new Team(data[0][0], data[0][1], data[0][2], new String[] {data[0][3], data[0][4], data[0][5]}),
                    new Team(data[1][0], data[1][1], data[1][2], new String[] {data[1][3], data[1][4], data[1][5]})
            );

            startGame();
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        }
    }


    /**
     * Function name: getData
     *
     * @return (String[][])
     * @throws FileNotFoundException Inside the function:
     *                               1. Returns data from TEAMS_FILE as a String[][] array
     */
    public static String[][] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TEAMS_FILE);
        Scanner scanner = new Scanner(fis);
        String[][] teamMembers = new String[2][6];
        for (int row = 0; scanner.hasNextLine(); row++) {
            String[] members = scanner.nextLine().split(",");
            for (int column = 0; column < members.length; column++) {
                teamMembers[row][column] = members[column];
            }
        }
        scanner.close();
        return teamMembers;
    }

    /** Function name: startGame
     *
     * Inside the function:
     *    1. Grabs each play from plays.txt and calls game.simulate(play);
     *    2. Prints the return from game.simulate(play)
     *        - println("\n" + <return> + "\n");
     */
    public static void startGame() throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(PLAYS_FILE);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            String simulate = game.simulate(scanner.nextLine());
            try {
                wait(3);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println(simulate);
            System.out.println();
        }
        scanner.close();
        printResult();
    }

    /** Function name: printResult()
     *
     * Inside the function:
     *    1. Prints the final score: println("\nGRYFFINDOR: " + <gryffindor score> + " SLYTHERIN: " + <slytherin score>);
     *    2. Prints the winner: println("\n" + <winner team name> + " WINS!");
     *
     */
    public static void printResult(){
        System.out.println("\nGRYFFINDOR: " + game.getScore(game.getTeam("Gryffindor"))
                + " SLYTHERIN: " + game.getScore(game.getTeam("Slytherin")));
        System.out.println();

        Team Gryffindor = game.getTeam("Gryffindor");
        Team Slytherin = game.getTeam("Slytherin");

        if (game.getScore(Gryffindor) > game.getScore(Slytherin)){
            System.out.println(Gryffindor.getHouse() + " WINS!");
        }else if (game.getScore(Gryffindor) < game.getScore(Slytherin)) {
            System.out.println(Slytherin.getHouse() + " WINS!");
        }else{
            System.out.println("It's a tie");
        }
    }
    /**
     * Function name: wait
     * @param sec
     *
     * Inside the function:
     *  1. Make the code sleep for X seconds.
     */
    public static void wait(int sec) throws InterruptedException {
        TimeUnit.SECONDS.sleep(sec);
    }

}
