public class Three implements CardFactory{
    @Override
    public String drawCard() {
        return  "   _____\n" +
                "  |3    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____E|\n";
    }
}
