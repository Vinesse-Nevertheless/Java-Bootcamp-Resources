package src.main.models;

import java.util.Objects;

public class Movie {
    private String name;
  //  private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;
    public Format format;

    public static final double sellingPriceBlueRay = 4.25;
    public static final double sellingPriceDVD = 2.25;
    public static final double rentalPriceBlueRay = 1.99;
    public static final double rentalPriceDVD = 0.99;

    public enum Format {BLUE_RAY, DVD}

    public Movie(String name, Format format, double rating) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must contain a value");
        }

        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Invalid rating");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = format.name().equals("BLUE_RAY") ? sellingPriceBlueRay : sellingPriceDVD;
        this.rentalPrice = format.name().equals("BLUE_RAY") ? rentalPriceBlueRay : rentalPriceDVD;
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

    public String getName() {
        return name;
    }
    
    public Format getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }

    public void setFormat(Format format) {
        this.format = format;
        setSellingPrice(format.name().equals("BLUE_RAY") ? sellingPriceBlueRay : sellingPriceDVD);
        setRentalPrice(format.name().equals("BLUE_RAY") ? rentalPriceBlueRay : rentalPriceDVD);
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("invalid rating");
        }
        this.rating = rating;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String toString() {
        return "\t Name: " + this.name + "\n" +
               "\t Format: " + this.format + "\n" +
               "\t Rating: " + this.rating + "\n" +
               "\t Selling Price: " + this.sellingPrice + "\n" +
               "\t Rental Price: " + this.rentalPrice + "\n" +
               "\t Availability: " + (this.isAvailable ? "in-stock" : "rented") + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.getRating(), getRating()) == 0 && Double.compare(movie.getSellingPrice(), getSellingPrice()) == 0 && Double.compare(movie.getRentalPrice(), getRentalPrice()) == 0 && isAvailable() == movie.isAvailable() && getName().equals(movie.getName()) && getFormat().equals(movie.getFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFormat(), getRating(), getSellingPrice(), getRentalPrice(), isAvailable());
    }
}
