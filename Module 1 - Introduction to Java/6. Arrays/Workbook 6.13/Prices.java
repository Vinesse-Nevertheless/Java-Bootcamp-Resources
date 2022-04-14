import java.util.Arrays;

public class Prices {
    public static void main(String[] args) {
        //Task 1 - Create a 2D array that can store 3 rows and 5 columns of double values.
        double[][] array = new double[3][5];

        // Task 2 - Populate your 2D array with values from the table (see article)
        array[0][0] = 12.99;
        array[0][1] = 8.99;
        array[0][2] = 9.99;
        array[0][3] = 10.49;
        array[0][4] = 11.99;
        array[1][0] = 0.99;
        array[1][1] = 1.99;
        array[1][2] = 2.49;
        array[1][3] = 1.49;
        array[1][4] = 2.99;
        array[2][0] = 8.99;
        array[2][1] = 7.99;
        array[2][2] = 9.49;
        array[2][3] = 9.99;
        array[2][4] = 10.99;

        // Task 3 - Print the prices for each department. See the article for the expected output.  

        for (int row = 0; row < array.length; row++) {
             switch (row){
                 case 0 :
                     System.out.print("Baking: ");
                     break;
                 case 1 :
                     System.out.print("Beverage: ");
                     break;
                 case 2 :
                     System.out.print("Cereals: ");
                     break;
             }

                for (int column = 0; column < array[row].length; column++) {
                    System.out.print(array[row][column] + " ");
            }
            System.out.println();
        }
    }
}