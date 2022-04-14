package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank.");
        }
        if (!format.equalsIgnoreCase("DVD") && !format.equalsIgnoreCase("Blue-Ray")){
            throw new IllegalArgumentException("Improper format");
        }
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }

        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = getSellingPrice();
        this.rentalPrice = getRentalPrice();
        this.isAvailable = true;
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.isAvailable = source.isAvailable;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }
    public void setIsAvailable(boolean available){
        this.isAvailable = available;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank.");
        }
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (!format.equalsIgnoreCase("DVD") && !format.equalsIgnoreCase("Blue-Ray")){
            throw new IllegalArgumentException("Improper format");
        }
        this.format = format;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }
        this.rating = rating;
    }

    public double getSellingPrice() {
        if (format.equalsIgnoreCase("Blue-Ray")){
            return 4.25;
        }
        if (format.equalsIgnoreCase("DVD")){
            return 2.25;
        }
        return sellingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    private double getRentalPrice() {
        if (format.equalsIgnoreCase("Blue-Ray")){
            return 1.99;
        }
        if (format.equalsIgnoreCase("DVD")){
            return 0.99;
        }
        return rentalPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Override
    public String toString(){
        return "\t Name: " + name + "\n" +

                "\t Format: " + format + "\n" +

                "\t Rating: " + rating + "\n" +

                "\t Selling Price: " + sellingPrice + "\n" +

                "\t Rental Price: " + rentalPrice + "\n" +

                "\t Availability: " + (isAvailable() ? "in-stock" : "rented") + "\n";
    }
}
