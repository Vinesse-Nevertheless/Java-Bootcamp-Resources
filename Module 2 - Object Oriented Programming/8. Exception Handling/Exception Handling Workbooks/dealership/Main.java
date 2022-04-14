import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import models.Car;
import models.Dealership;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Car[] cars = new Car[]{
                new Car("Honda", 5000),
                new Car("Mercedes", 12000),
        };
        cars[1].setMake("BMW");
        cars[1].setPrice(8500);

        Dealership dealership = new Dealership(cars);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while (true) {
            System.out.println(dealership);

            if (dealership.isEmpty()) {
                System.out.println("We're all sold out!");
                break;
            }

            System.out.print("Enter the spot number of the car you want to buy: ");

            if (!scan.hasNextInt()) {
                scan.nextLine();
                System.out.println("INVALID INPUT.");

                continue;
            }

            int spot = scan.nextInt();

            if (spot < 0 || spot > dealership.getLength() - 1) {
                System.out.println("Please choose a valid parking spot.");
                scan.nextLine();
                continue;
            }

            if (dealership.getCar(spot) != null) {
                dealership.sell(spot);
              /*  if (dealership.isEmpty()) {    Originally I place the code here to show as soon as the last car was sold, but instructor wanted to ask to continue shopping first.
                    System.out.print(dealership);
                    System.out.println("We're all sold out!");
                    break;
                }*/
                System.out.print("Type yes to continue shopping: ");
                scan.nextLine();
                String wantToBuyMore = scan.nextLine();
                if (!wantToBuyMore.equalsIgnoreCase("yes")) {
                    break;
                }
            } else {
                System.out.println("Spot " + spot + " is empty.");
            }
        }
        scan.close();
    }
}
