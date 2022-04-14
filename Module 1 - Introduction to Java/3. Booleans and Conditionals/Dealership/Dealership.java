import java.util.Scanner;

public class Dealership {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to the Java Dealership.");

            System.out.println("\u2022 Select option 'a' to buy a car.");
            System.out.println("\u2022 Select option 'b' to sell a car.");

            String option = scan.nextLine();

            switch (option){
                case "a":
                case "b":
                    System.out.println("You chose option " + option);
                    break;
                default:
                    System.out.println("Invalid option");
            }

            scan.close();
        }
    }

