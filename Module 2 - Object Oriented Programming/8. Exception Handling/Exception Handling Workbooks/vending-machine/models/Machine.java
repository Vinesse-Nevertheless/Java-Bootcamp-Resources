package models;
public class Machine {
    private Item[][] items;

    public Machine(Item[][] items) {
        this.items = new Item[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }
    
    public Item getItem(int row, int spot) {
        return new Item(this.items[row][spot]);
    }
    
    public void setItem(Item item, int row, int spot) {
        this.items[row][spot] = new Item(item);
    }

    public void dispense(int row, int spot) {
        if(items[row][spot].getQuantity() == 0){
            throw new IllegalStateException("can't dispense an item with a quantity of zero");
        }
        items[row][spot].setQuantity(items[row][spot].getQuantity() - 1);
    }

    public int getLength(){
        return items[getRowLength()-1].length;
    }
    public int getRowLength(){
        return items.length;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < items.length; i++) {
            temp += "\t";
            for (int j = 0; j < items[i].length; j++) {
                temp += items[i][j].toString() + " ";
            }
            temp += "\n\n";
        }
        temp += "\t************************************************";
        return temp;
    }

}
