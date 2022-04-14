public class Three implements CardFactory{
    @Override
    public String dealCard() {
        return  "   _____\n" +
                "  |3    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____E|\n";
    }
}
