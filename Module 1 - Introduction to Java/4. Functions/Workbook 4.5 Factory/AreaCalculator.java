/*
Practicing the factory pattern again.
*/

public class AreaCalculator {
    public static void main(String[] args) {
        System.out.println("Thank you for using the area calculator");
        System.out.println("This calculator lets you get the area of: ");
        System.out.println("1 – Square\n2 – Rectangle\n3 – Triangle\n4 – Circle\n");

        // double square = area of square with a side of 2.
        // double rectangle = area of rectangle with a length of 1, and a width of 2. 
        // double triangle = area of triangle with a base of 1, and a width of 2. 
        // double circle = area of circle with a radius of 2. 

        Calculator square = new AreaFactory().createAreaCalculator(Shapes.SQUARE);
        double squareArea = square.calculateArea(2);

        Calculator rectangle = new AreaFactory().createAreaCalculator(Shapes.RECTANGLE);
        double rectangleArea = rectangle.calculateArea(1,2);

        Calculator triangle = new AreaFactory().createAreaCalculator(Shapes.TRIANGLE);
        double triangleArea = triangle.calculateArea(1,2);

        Calculator circle = new AreaFactory().createAreaCalculator(Shapes.CIRCLE);
        double circleArea = circle.calculateArea(2);


        PrintArea.printAreas(rectangleArea, squareArea, triangleArea, circleArea);

    }
}
