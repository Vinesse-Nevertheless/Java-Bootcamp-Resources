public class AreaFactory {
    public Calculator createAreaCalculator(Shapes shape){
        switch (shape) {
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            case TRIANGLE:
                return new Triangle();
            case CIRCLE:
                return new Circle();
            default:
                throw new IllegalArgumentException("I don't know that shape.");
        }
    }
}
