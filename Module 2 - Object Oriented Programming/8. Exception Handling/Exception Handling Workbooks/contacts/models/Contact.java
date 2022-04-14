package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String birthdate;
    private String phoneNumber;
    private static DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private static Date now = new Date();

    public Contact(String name, String phoneNumber, String birthdate) throws ParseException {
        if ((name == null || name.isBlank()) || (phoneNumber == null || phoneNumber.isBlank())) {
            System.out.println("The input you provided is not valid.  Registration failed.");}
        if (phoneNumber.length() < 5) {
                System.out.println("The phone number cannot be shorter than 5 digits.");    }

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.age = toAge(birthdate);
    }

    public Contact(Contact source) throws ParseException {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthdate = source.birthdate;
        this.age = toAge(birthdate);
    }



    /**
     * Name: toAge
     *
     * @param birthdate
     * @return age (int)
     * @throws ParseException Inside the function:
     *                        1. Parses a date from the birthDate String
     *                        2. Gets the current date
     *                        3. Subtracts the difference and returns the age.
     */
    public int toAge(String birthdate) throws ParseException {
        formatter.setLenient(false);
        Date birthdateParsed = formatter.parse(birthdate);
        long birthdateInMilliseconds = birthdateParsed.getTime();

        long currentTime = now.getTime();
        long ageInMilliseconds = currentTime - birthdateInMilliseconds;

        long daysSinceBirth = TimeUnit.DAYS.convert(ageInMilliseconds, TimeUnit.MILLISECONDS);
        int currentAge = (int) (daysSinceBirth / 365);
        return currentAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Setting name failed. Name invalid.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) throws ParseException {
        int currentAge = toAge(birthdate);
        setAge(currentAge);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.length() < 5) {
            System.out.println("Setting phone number failed.  Invalid length.");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Phone number: " + phoneNumber + "\n" +
                "Birth Date: " + birthdate + "\n" +
                "Age: " + age + " year old \n";
    }
}
