import models.Contact;
import models.ContactManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    private static ContactManager contactManager = new ContactManager();

    public static void main(String[] args) {
        Contact contact = null;
        try {
            loadContacts("contacts.txt");
            manageContacts();

        } catch (ParseException | FileNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            System.out.println("\n\nUPDATED CONTACTS");
            System.out.println(contactManager);

        }
    }

    /**
     * Name: manageContacts
     * <p>
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     * •        case a: ask for the name, phone number and birthDate.
     * •        case b: ask who they'd like to remove.
     * •        case c: break the loop.
     * • 3. close Scanner.
     */
    public static Scanner manageContacts() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to add \na) contact \nb) remove a contact " +
                    "\nc) exit \n");
            String option = scanner.nextLine();
            switch (option.toLowerCase()) {
                case "a":
                    System.out.println("Enter name, phone number, and birthDate.");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Birth Date: ");
                    String birthdate = scanner.nextLine();
                    if (!isFieldValid(name, phoneNumber)) {
                        continue;
                    }
                    contactManager.addContact(new Contact(name, phoneNumber, birthdate));
                    return scanner;
                case "b":
                    System.out.println("Enter name of person to remove.");
                    contactManager.removeContact(scanner.next());
                    return scanner;
                case "c":
                    return scanner;
                default:
                    System.out.println("Please enter a, b, or c.");
                    scanner.close();
            }
        }
    }

    public static boolean isFieldValid(String name, String phoneNumber) {
        if ((name == null || name.isBlank()) || (phoneNumber == null || phoneNumber.isBlank())) {
            System.out.println("The input you provided is not valid.  Registration failed.");
            return false;
        }
        if (phoneNumber.length() < 5) {
            System.out.println("The phone number cannot be shorter than 5 digits.");
            return false;
        }
        return true;
    }

    /**
     * Name: loadContacts
     *
     * @param fileName (String)
     * @throws FileNotFoundException Inside the function:
     *                               • 1. loads contacts from <fileName>;
     *                               • 2. From the manager object, it adds all contacts to the contacts list.
     *                               Hint: use scan.next to grab the next String separated by white space.
     */
    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            try {
                contactManager.addContact(new Contact(scanner.next(), scanner.next(), scanner.next()));
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
