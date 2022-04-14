public class Rectangle implements Calculator{
    @Override
    public double calculateArea(double... varArgs) {
        ValidateInputs.validate(varArgs);
        return varArgs[0] * varArgs[1];
    }
}
