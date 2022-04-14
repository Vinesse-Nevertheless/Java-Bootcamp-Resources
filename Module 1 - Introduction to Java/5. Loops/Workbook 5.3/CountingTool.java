import java.util.Scanner;

public class CountingTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Hi Timmy! Choose a number to count to: ");
        int number = scan.nextInt();
        System.out.println("Great!  Here's how it's done.");
        for (int i = 0; i <= number; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        /*Task 1 – Choose a number

            Ask: Hi Timmy! Choose a number to count to: 

            Make sure Timmy can enter the value BESIDE the question. 
        */

        /* Task 2 – Count from 0 to that number

             Let's say Timmy entered 5, you would display: 0 1 2 3 4 5 

        */

        scan.close();
    }
}
