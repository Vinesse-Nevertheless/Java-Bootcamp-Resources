public class Biography {
    public static void main(String[] args) {

        //make a name variable
        String name = "Vanessa";
        //make an age variable
        int age = 46;
        //make a country variable
        String country = "United States";
        //make a sport variable
        String sport = "rugby";
        //make an hours variable
        int hours = 1;
        //make a game variable
        String game = "go";
        //make a subject variable
        String subject = "computer science";
        //make a grade variable
        char grade = 'A';
     
        System.out.println("My name is " + name + ". I'm " + age + " years old, and I'm from the " + country + ".");
        System.out.printf("My favourite sport is %s. I play for %d hour a day.\n", sport, hours);
        System.out.println("When I'm tired, I like to play " + game + ".");
        System.out.println("In school, my favourite subject was " + subject + ", I scored an " + grade + ".");

    }
}