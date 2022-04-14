public class Triangle implements Calculator{
    @Override
    public double calculateArea(double... varArgs) {
        ValidateInputs.validate(varArgs);
        return 0.5 * varArgs[0] * varArgs[1];
    }
}
