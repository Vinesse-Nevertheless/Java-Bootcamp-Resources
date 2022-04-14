public class Queen implements CardFactory{
    @Override
    public String drawCard() {
        return  "   _____\n" +
                "  |Q  ww|\n"+
                "  | o {(|\n"+
                "  |o o%%|\n"+
                "  | |%%%|\n"+
                "  |_%%%O|\n";
    }
}
