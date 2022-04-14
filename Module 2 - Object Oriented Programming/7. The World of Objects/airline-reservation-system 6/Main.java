import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Rayan Slim", "Canadian",
                "01/01/1111", 5);
        if (person.applyPassport()) {
            person.setPassport(new String[]{"Rayan Slim", "Canadian", "01/01/1111"});
        }

        System.out.println("Name: " + person.getName() + "\n" +
                "Nationality: " + person.getNationality() + "\n" +
                "Date of Birth: " + person.getDateOfBirth() + "\n" +
                "Seat Number: " + person.getSeatNumber() + "\n" + "Passport: " +
                Arrays.toString(person.getPassport()) + "\n");
    }
}
