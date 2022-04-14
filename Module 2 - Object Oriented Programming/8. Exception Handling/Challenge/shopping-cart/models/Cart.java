package models;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void setItem(Item item, int index){
        new Item(items.set(index, item));
    }
    public Item getItem(int index){
        return new Item(items.get(index));
    }


    /**
    * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */

    public boolean add(Item item){
        if (!items.contains(item)){
            items.add(new Item(item));
            return true;
        }

      return false;
    }
 
  
   /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */
public void remove (String name){
    items.removeIf(item -> item.getName().equalsIgnoreCase(name));
}

   /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */
    public String checkout(){
        if (items.isEmpty()){
            return "";
        }
        double subtotal = 0;
        for (Item item: items) {
            subtotal += item.getPrice();
        }
        NumberFormat decimalFormat = DecimalFormat.getCurrencyInstance();
        double tax = subtotal * 0.13;
        double total = subtotal + tax;
        String subtotalFormatted = decimalFormat.format(subtotal);
        String taxFormatted = decimalFormat.format(tax);
        String totalFormatted = decimalFormat.format(total);
        return "\tRECEIPT\n\n" +
                "\tSubtotal: " + subtotalFormatted + "\n" +
                "\tTax: " + taxFormatted + "\n" +
                "\tTotal: " + totalFormatted + "\n";
    }

    @Override
    public String toString(){
        String temp = "";
        for (Item item: items) {
           temp += item + " ";
           temp += "\n";
        }
        return temp;
    }
}
