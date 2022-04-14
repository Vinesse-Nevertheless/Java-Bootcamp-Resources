package models;

public class Store {
    private Item[][] items;

    public Store() {
        items = new Item[7][3];
    }

    public Item getItem(int row, int column){
        return new Item(items[row][column]);
    }

    public int getLength(){
        return items.length;
    }
    public void setItem(Item item, int row, int column){
        this.items[row][column] = new Item(item);
    }

    @Override
    public String toString(){
        String temp = "";
        for (int row = 0; row < items.length; row++) {
            switch (row) {
                case 0: temp += "\tDRINKS:        "; break;
                case 1: temp += "\tCEREAL:        "; break;
                case 2: temp += "\tDAIRY:         "; break;
                case 3: temp += "\tDELI:          "; break;
                case 4: temp += "\tGREENS:        "; break;
                case 5: temp += "\tCLOTHING:      "; break;
                case 6: temp += "\tELECTRONICS:   "; break;
            }
            for (int column = 0; column < items[row].length; column++) {
                temp += items[row][column] + " ";
            }
            temp += "\n\n";
        }
        temp +="\t************************************************************************\n";
        return temp;
    }
}
