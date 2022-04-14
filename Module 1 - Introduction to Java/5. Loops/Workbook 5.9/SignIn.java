import java.util.Scanner;

public class SignIn {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String username = "Samantha";
        String password = "Java <3";
        System.out.println("\nWelcome to Javagram! Sign in below\n");
        String enteredUsername = enterUsername();
        String enteredPassword = enterPassword();

        /* Task 1 
            1. Pick up a username and password from the user.
       */

        /* Task 2 
            1. Set up a loop that keeps running while the username OR password is incorrect. 
               When they get it wrong:
                •  println: \nIncorrect, please try again!\n
                •  get them to enter their username and password again
            2. After they enter the correct information, print: 
                   \nSign in successful. Welcome!
       */
        while (!enteredUsername.equals(username) || !enteredPassword.equals(password)){
            System.out.print("\nIncorrect, please try again!\n");
            enteredUsername = enterUsername();
            enteredPassword = enterPassword();
        }
        System.out.println("\n Sign in successful. Welcome!");

        scan.close();

        
    }

    public static String enterUsername(){
        System.out.print("• Username: ");
        return scan.nextLine();
    }
    public static String enterPassword(){
        System.out.print("• Password: ");
        return scan.nextLine();
    }
}
