public class Ace implements CardFactory{
    @Override
    public String dealCard() {
        return  "   _____\n"+
                "  |A _  |\n"+
                "  | ( ) |\n"+
                "  |(_'_)|\n"+
                "  |  |  |\n"+
                "  |____V|\n";
    }
}
