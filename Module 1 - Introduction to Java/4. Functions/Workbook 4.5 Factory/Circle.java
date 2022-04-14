public class Circle implements Calculator{
    @Override
    public double calculateArea(double... varArgs) {
        ValidateInputs.validate(varArgs);
        return Math.PI * varArgs[0] * varArgs[0];
    }
}
