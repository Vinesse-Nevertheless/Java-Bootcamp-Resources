import java.util.Arrays;

public class Main {
  
    public static void main(String[] args) {
    Person person1 = new Person("Rayan Slim", "Canadian", "01//01/1111",
            new String[]{"Rayan Slim", "Canadian", "01//01/1111"}, 5);

        System.out.println("Name: " + person1.getName() + "\n" + "Nationality: " +
                person1.getNationality() + "\n" + "Date of Birth: " +
                person1.getDateOfBirth() + "\n" + "Passport: " + Arrays.toString(person1.getPassport()) + "\n" +
                "Seat Number: " + (person1.chooseSeat()) + "\n");

        boolean hasApplied = person1.applyPassport();

        if (hasApplied){
            System.out.println("Congratulations " + person1.getName() + ". Your passport was approved!");
        }else{
            System.out.println("We're sorry " + person1.getName() + ". " +
                    "We cannot process your application.");
        }


    }
  
  
}
