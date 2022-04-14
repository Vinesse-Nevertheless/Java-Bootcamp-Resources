import java.util.Arrays;

public class Main {
  
    public static void main(String[] args) {
    Person person1 = new Person("Rayan Slim", "Canadian", "01//01/1111",
            new String[]{"Rayan Slim", "Canadian", "01//01/1111"}, 5);

        System.out.println("Name: " + person1.name + "\n" + "Nationality: " +
                person1.nationality + "\n" + "Date of Birth: " +
                person1.dateOfBirth + "\n" +
                "Seat Number: " + person1.seatNumber + "\n");
    }
}
