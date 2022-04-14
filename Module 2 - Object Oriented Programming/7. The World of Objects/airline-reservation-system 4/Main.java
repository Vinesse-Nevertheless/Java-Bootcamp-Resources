import java.util.Arrays;

public class Main {
  
    public static void main(String[] args) {
    Person person1 = new Person("Rayan Slim", "Canadian", "01//01/1111",
            new String[]{"Rayan Slim", "Canadian", "01//01/1111"}, 5);

        System.out.println("Name: " + person1.getName() + "\n" + "Nationality: " +
                person1.getNationality() + "\n" + "Date of Birth: " +
                person1.getDateOfBirth() + "\n" + "Passport: " + Arrays.toString(person1.getPassport()) + "\n" +
                "Seat Number: " + person1.getSeatNumber() + "\n");

    Person person2 = new Person(person1);

    person2.setName("Jad Slim");
    person2.setSeatNumber(3);

        System.out.println("Name: " + person2.getName() + "\n" + "Nationality: " +
                person2.getNationality() + "\n" + "Date of Birth: " +
                person2.getDateOfBirth() + "\n" + "Passport: " + Arrays.toString(person2.getPassport()) + "\n" +
                "Seat Number: " + person2.getSeatNumber() + "\n");

    }
  
  
}
