import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");
        //Task 1 – Ask the user: how many historical figures will you register?
        //       – Store the value.
        int figuresCount = scan.nextInt();
        scan.nextLine();
        //Task 2 – Create a 2D array with a variable number of rows, and 3 values per row.         
        String[][] array = new String[figuresCount][3];
        //Watch out for the nextLine() pitfall. 
        /* Task 3 
        for (____) {

            System.out.println("\n\tFigure " + (i+1)); 

            System.out.print("\t - Name: ");
            pick up and store figure's name.   

            System.out.print("\t - Date of birth: ");
            pick up and store figure's birthday.

            System.out.print("\t - Occupation: ");
            pick up and store figure's occupation. 

            System.out.print("\n");

        }
        */
        for (int i = 0; i < array.length; i++) {
            System.out.println("\n\tFigure " + (i + 1));
            System.out.print("\t - Name: ");
            array[i][0] = scan.nextLine();

            System.out.print("\t - Date of birth: ");
            array[i][1] = scan.nextLine();

            System.out.print("\t - Occupation: ");
            array[i][2] = scan.nextLine();
        }


        System.out.println("\nThese are the values you stored:");
        //Task 4: call print2DArray.
        print2DArray(array);
        System.out.print("\nWho do you want information on? ");
        
        /*Task 5: Let the user search the database by name. 
            If there's a match:
              print(    tab of space    Name: <name>)
              print(    tab of space    Date of birth: <date of birth>)
              print(    tab of space    Occupation: <occupation>)

        */
        String name = scan.nextLine();
        for (int row = 0; row < array.length; row++) {
            if (name.equalsIgnoreCase(array[row][0])) {
                System.out.println("\n\t Name: " + array[row][0]);
                System.out.println("\t Date of birth: " + array[row][1]);
                System.out.println("\t Occupation: " + array[row][2]);
            }else{
                System.out.println("No such person exists in database.");
            }
        }

        scan.close();
    }

    /**
     * Function name: print2DArray
     *
     * @param array (String[][])
     *              <p>
     *              Inside the function
     *              1. print the database
     *              • a tab of space precedes each row.
     *              • each value in database has one space from the other value.
     *              • print a new line.
     */
    public static void print2DArray(String[][] array) {
        for (int row = 0; row < array.length; row++) {
            System.out.print("\t");
            for (int column = 0; column < array[row].length; column++) {
                System.out.print(array[row][column] + " ");
            }
            System.out.println();
        }
    }

}
