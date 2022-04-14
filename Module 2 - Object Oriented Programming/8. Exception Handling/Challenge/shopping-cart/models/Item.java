package models;
import java.util.Objects;

public class Item {
    private String name;
    private double price;


    public Item(String name, double price) {
        if (name == null || name.isBlank()){
            System.out.println("name missing");
        }
        if(price <= 0){
            System.out.println("price must be greater than 0");
        }
        this.name = name;
        this.price = price;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()){
            System.out.println("name missing");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            System.out.println("price must be greater than 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": $" + price + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.getPrice(), getPrice()) == 0 && getName().equals(item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
