import java.util.Arrays;

public class Airline {
    private Person[] seats;

    public void createReservation(){}

    public Airline(){
        this.seats = new Person[11];
    }

    public Person getPerson(int index){
        return new Person(seats[index]);
    }

    public void setPerson(Person person){
      this.seats[person.getSeatNumber() - 1] = new Person(person);

    }
}
