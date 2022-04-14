import java.util.Arrays;

public class Airline {
    private Person[] seats;

    public Airline(){
        this.seats = new Person[11];
    }

    public void createReservation(Person person){
        while (this.seats[person.getSeatNumber() -1] != null){
            System.out.println(person.getName() + ", seat: " + person.getSeatNumber() +
            " is already taken. Please choose another one.");
             person.chooseSeat();
        }
        this.seats[person.getSeatNumber() -1] = new Person(person);
        System.out.println("Thank you, " + person.getName() + " for flying with Java airlines." +
                " Your seat number is " + person.getSeatNumber() + ".");

    }

    public Person getPerson(int index){
        return new Person(seats[index]);
    }

    public void setPerson(Person person){
      this.seats[person.getSeatNumber() - 1] = new Person(person);

    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < seats.length; i++) {
            if(seats[i] != null) {
                temp += (seats[i].toString() + "\n\n");
            }else{
                temp += "Seat: " + (i + 1) + " is empty. \n\n";  //i + 1 gives the proper seat number since seats are 1 - 11, but indexes are 0 based.
            }
        }
        return temp;
    }
}
