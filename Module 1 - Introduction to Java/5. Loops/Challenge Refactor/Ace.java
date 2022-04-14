public class Ace implements CardFactory{
    @Override
    public String drawCard() {
        return  "   _____\n"+
                "  |A _  |\n"+
                "  | ( ) |\n"+
                "  |(_'_)|\n"+
                "  |  |  |\n"+
                "  |____V|\n";
    }
}
