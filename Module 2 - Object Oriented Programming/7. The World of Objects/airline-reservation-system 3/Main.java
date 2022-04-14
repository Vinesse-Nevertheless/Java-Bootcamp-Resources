import java.util.Arrays;

public class Main {
  
    public static void main(String[] args) {
    Person person1 = new Person("Rayan Slim", "Canadian", "01//01/1111",
            new String[]{"Rayan Slim", "Canadian", "01//01/1111"}, 5);

        System.out.println("Name: " + person1.getName() + "\n" + "Nationality: " +
                person1.getNationality() + "\n" + "Date of Birth: " +
                person1.getDateOfBirth() + "\n" +
                "Seat Number: " + person1.getSeatNumber() + "\n");


        person1.setSeatNumber(10);

        System.out.println("Name: " + person1.getName() + "\n" + "Nationality: " +
                person1.getNationality() + "\n" + "Date of Birth: " +
                person1.getDateOfBirth() + "\n" +
                "Seat Number: " + person1.getSeatNumber() + "\n");

    }
}
