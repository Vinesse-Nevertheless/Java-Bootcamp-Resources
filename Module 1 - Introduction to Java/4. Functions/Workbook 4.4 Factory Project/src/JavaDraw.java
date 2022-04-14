import java.util.Scanner;

/*
My attempt to make a factory clean code pattern with this.
 */
public class JavaDraw {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice;

        System.out.print("\nWhich animal would you like to draw?\n");
        System.out.println("Write 1 for butterfly ");
        System.out.println("Write 2 for elephant  ");
        System.out.println("Write 3 for bear      ");
        System.out.println("Write 4 for snake     ");

        //Task 1 – Pick up the user's choice.
        choice = scan.nextInt();
        //Task 3 – Call the draw function, and pass in the user's choice.
        Drawing drawing = new DrawingFactory().createDrawing(choice);
        drawing.drawAnimal();
        scan.close();
    }
}
