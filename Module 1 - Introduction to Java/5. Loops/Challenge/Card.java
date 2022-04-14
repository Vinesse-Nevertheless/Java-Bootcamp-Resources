public class Card {
    public CardFactory createCard(int randomInt){
        switch (randomInt){
            case 1 :
                return new Ace();
            case 2 :
                return new Two();
            case 3 :
                return new Three();
            case 4 :
                return new Four();
            case 5 :
                return new Five();
            case 6 :
                return new Six();
            case 7 :
                return new Seven();
            case 8 :
                return new Eight();
            case 9 :
                return new Nine();
            case 10 :
                return new Ten();
            case 11 :
                return new Jack();
            case 12:
                return new Queen();
            case 13 :
                return new King();
            default:
                return null;
        }
    }
}
