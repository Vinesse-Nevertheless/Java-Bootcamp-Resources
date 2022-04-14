public class Ten implements CardFactory{
    @Override
    public String drawCard() {
        return  "   _____ \n" +
                "  |10  o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |___10|\n";
    }
}
