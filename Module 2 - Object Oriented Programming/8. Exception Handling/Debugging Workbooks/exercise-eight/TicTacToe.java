public class TicTacToe {
    public static void main(String[] args) {
        char[][] array = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
        };
        
/*        for (int row = 0; row < array.length; row++) {
            int start = row % 2 == 0 ? 0 : 1;
            for (int column = start; column < array[row].length; column+=2) {
                if (row == column) {
                    array[row][column] = 'X';
                }else{
                    array[row][column] = 'O';
                }
            }
        }*/
        for (int row = 0; row < array.length; row++) {
            array[2-row][2-row] = 'X';
            array[row][2-row] = 'O';

        }
        printArray(array);
        System.out.println("\nO WINS!\n");
   }
   
   public static void printArray(char[][] array) {
       System.out.println();
       for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array[i].length; j++) {
               System.out.print( array[i][j] + "  ");
           }
           System.out.println();
       }
   }
}
