import java.util.Arrays;

public class LotteryTickets {
    public static void main(String[] args) {
        int[] ticket = {34, 43, 45, 65, 21, 54};
        //Task 1 - Copy the elements of ticket into ticket2, but change the third value to 54. 
        int[] ticket2 = Arrays.copyOf(ticket,ticket.length);
        ticket2[2] = 54;
        System.out.print("Ticket 1 numbers: ");
        printTicketNumbers(ticket);
        //Task 3 - Call printTicketNumbers for int[] ticket.   

        System.out.print("Ticket 2 numbers: ");
        printTicketNumbers(ticket2);
        //Task 3 - Call printTicketNumbers for int[] ticket2.   
    }
    
    /** Task 2
     * Function name – printTicketNumbers
     * @param ticket ( int[] )
     * 
     * Inside the function:
     *   1.   print the numbers in one line. 
     *        i.e  1 4 6 3 2 6 
     *   2.   print a new line   
     */
    public static void printTicketNumbers(int[] ticket){
        for (int i = 0; i < ticket.length; i++) {
            System.out.print(ticket[i] + " ");
        }
        System.out.println();
    }
    
}

