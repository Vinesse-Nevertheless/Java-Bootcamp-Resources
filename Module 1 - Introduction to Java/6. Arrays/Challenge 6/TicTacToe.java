import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nLet's play tic tac toe");

        //Task 1: Create an array with three rows of '_' characters.
        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };

        //Task 2: Call the function printBoard();
        printBoard(board);

        for (int turn = 0; turn < 9; turn++) {
            int[] position = {};
            if (turn % 2 == 0) {
                System.out.println("Turn X: ");
                position = askUser(board);
                board[position[0]][position[1]] = 'X';
            } else {
                System.out.println("Turn O: ");
                position = askUser(board);
                board[position[0]][position[1]] = 'O';
            }
            printBoard(board);
            if (checkWin(board) == 3) {
                System.out.println("X wins!");
                break;
            } else if (checkWin(board) == -3) {
                System.out.println("O wins!");
                break;
            }else if (!Arrays.deepToString(board).contains("_")){
                System.out.println("Nobody wins.");
                break;
            }
        }



              /*
              {  Task 3: Loop through turns.

                  if (X) turn {
                     Task 4: call askUser().
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser().
                      Task 5: populate the board using askUser's return value. Then, print it.

                  }

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              }
              */

        scan.close();
    }


    /**
     * Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     *
     * @param board (char[][])
     *              <p>
     *              Inside the function:
     *              1. print a new line.
     *              2. print the board.
     *              • separate each row by two lines.
     *              • each row precedes a tab of space
     *              • each character in the grid has one space from the other character
     */

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.print("\t");
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     *
     * @param board (char[][] board)
     * @return spot (int[])
     * <p>
     * Inside the function
     * 1. Asks the user: - pick a row and column number:
     * 2. Check if the spot is taken. If so, let the user choose again.
     * 3. Return the row and column in an int[] array.
     */
    public static int[] askUser(char[][] board) {
        int[] spot = new int[2];
        System.out.print("Pick a row and column number: ");
        while (true) {
            spot[0] = scan.nextInt();
            spot[1] = scan.nextInt();
            if (board[spot[0]][spot[1]] == '_') {
                return spot;
            }
            System.out.print("Spot taken. Try again: ");
        }
    }

    /**
     * Task 6 - Write a function that determines the winner
     * Function name - checkWin
     *
     * @param board (char[][])
     * @return count (int)
     * <p>
     * Inside the function:
     * 1. Make a count variable that starts at 0.
     * 2. Check every row for a straight X or straight O (Task 7).
     * 3. Check every column for a straight X or straight O (Task 8).
     * 4. Check the left diagonal for a straight X or straight O (Task 9).
     * 5. Check the right diagonal for a straight X or straight O (Task 10).
     */
    public static int checkWin(char[][] board) {
        int count = 0;

        if (checkRow(board, count) == 3 || checkRow(board, count) == -3) {
            return checkRow(board, count);
        }
        if (checkColumn(board, count) == 3 || checkRow(board, count) == -3) {
            return checkColumn(board, count);
        }
        if (checkLeftDiagonal(board, count) == 3 || checkLeftDiagonal(board, count) == -3) {
            return checkLeftDiagonal(board, count);
        }
        if (checkRightDiagonal(board, count) == 3 || checkRightDiagonal(board, count) == -3) {
            return checkRightDiagonal(board, count);
        }
        return count;
    }

    public static int checkRow(char[][] board, int count){
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 'X') {
                    count++;
                }
                if (board[row][column] == 'O') {
                    count--;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }
        return count;
    }

    public static int checkColumn(char[][] board, int count){
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[column][row] == 'X') {
                    count++;
                }
                if (board[column][row] == 'O') {
                    count--;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }
        return count;
    }

    public static int checkLeftDiagonal(char[][] board, int count) {
        for (int row = 0; row < board.length; row++) {
            int column = row;
            if (board[row][column] == 'X') {
                count++;
            }
            if (board[row][column] == 'O') {
                count--;
            }
        }
        return count;
    }

    public static int checkRightDiagonal(char[][] board, int count) {
        for (int row = 0; row < board.length; row++) {
            int column = (board[row].length - 1) - row;
            if (board[row][column] == 'X') {
                count++;
            }
            if (board[row][column] == 'O'){
                count--;
            }
        }
        return count;
    }
}
