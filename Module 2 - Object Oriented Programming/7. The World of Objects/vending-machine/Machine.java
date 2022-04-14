import javax.crypto.Mac;

public class Machine {
    private Item[][] items;

    public Machine(Item[][] items){
        this.items = new Item[items.length][items[0].length];

        for (int row = 0; row < items.length; row++) {
            for (int column = 0; column < items[row].length; column++) {
                this.items[row][column] = new Item(items[row][column]);
            }
        }
    }

    public Item getItem(int row, int spot){
        return new Item(items[row][spot]);
    }

    public void setItem(Item item, int row, int spot){
        items[row][spot] = new Item(item);
    }
    /**
     * Function name – dispense
     * @param row (int)
     * @param spot (int)
     * @return (boolean)
     * 
     * Inside the function:
     *  1. Checks if the requested item has a quantity bigger than 0.
     *      • if so: decreases its quantity by one and returns true.
     *      • otherwise: returns false.
     */
      public boolean dispense(int row, int spot){
          if(items[row][spot].getQuantity() > 0){
              items[row][spot].setQuantity(items[row][spot].getQuantity() - 1);
              return true;
          }
          return false;
      }

      @Override
    public String toString(){
          String temp = "";
          for (int row = 0; row < items.length; row++) {
              temp += "\t";
              for (int column = 0; column < items[row].length; column++) {
                  temp += items[row][column].toString() + " ";
              }
              temp += "\n\n";
          }
          temp += "\t************************************************";
          return temp;
      }
}
