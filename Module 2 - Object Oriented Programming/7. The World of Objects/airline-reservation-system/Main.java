import java.util.Arrays;

public class Main {
  
    public static void main(String[] args) {
    Person person1 = new Person();
        System.out.println(person1.name);
        System.out.println(person1.nationality);
        System.out.println(person1.dateOfBirth);
        System.out.println(Arrays.toString(person1.passport));
        System.out.println(person1.seatNumber);

        person1.name = "Rayan Slim";
        person1.nationality = "Canadian";
        person1.dateOfBirth = "01//01/1111";
        person1.passport = new String[]{person1.name, person1.nationality, person1.dateOfBirth};
        person1.seatNumber = 5;

        System.out.println(person1.name);
        System.out.println(person1.nationality);
        System.out.println(person1.dateOfBirth);
        System.out.println(Arrays.toString(person1.passport));
        System.out.println(person1.seatNumber);
    }
  
  
}
