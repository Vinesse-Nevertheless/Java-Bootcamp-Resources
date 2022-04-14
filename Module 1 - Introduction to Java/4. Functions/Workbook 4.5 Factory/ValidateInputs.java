class ValidateInputs {
    public static void validate(double... varArgs) {
        for (double args : varArgs) {
            if (args <= 0) {
                throw new IllegalArgumentException("Error, impossible");
            }
        }
    }
}
