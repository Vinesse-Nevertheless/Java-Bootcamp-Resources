import java.util.Arrays;

public class Person {
     private String name;
     private String nationality;
     private String dateOfBirth;
     private String[] passport;
     private int seatNumber;

    public Person(String name, String nationality, String dateOfBirth,
                   int seatNumber){
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passport = new String[3];
        this.seatNumber = seatNumber;
    }

    public Person(Person source){
        this.name = source.name;
        this.nationality = source.nationality;
        this.dateOfBirth = source.dateOfBirth;
        this.passport = Arrays.copyOf(source.passport, source.passport.length);
        this.seatNumber = source.seatNumber;
    }


    public boolean applyPassport(){
        return (int) (Math.random() * 2) % 2 == 0;
    }

    public int chooseSeat(){
        double randomInt = Math.random() * 11 + 1;
        this.seatNumber = (int) randomInt;
        return this.seatNumber;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String[] getPassport() {
        return Arrays.copyOf(passport, passport.length);

    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassport() {
        this.passport = new String[]{name, nationality, dateOfBirth};
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\n" + "Nationality: " +
                nationality + "\n" + "Date of Birth: " +
                dateOfBirth + "\n" + "Seat Number: " +
                seatNumber + "\n" + "Passport: " +
               Arrays.toString(passport) + "\n";
    }
}
