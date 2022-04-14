public class Four implements CardFactory{
    @Override
    public String drawCard() {
        return  "   _____\n" +
                "  |4    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  | o o |\n"+
                "  |____h|\n";
    }
}
