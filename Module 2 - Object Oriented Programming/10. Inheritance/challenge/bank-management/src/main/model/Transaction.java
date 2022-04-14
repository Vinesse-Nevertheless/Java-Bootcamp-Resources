package src.main.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Transaction implements Comparable<Transaction>{

    public enum Type {
        WITHDRAW("withdraw"), DEPOSIT("deposit");
        private final String type;

        private Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private long timestamp;
    private String id;
    private double amount;
    private Type type;

    public Transaction(Type type, long timestamp, String id, double amount) {
       if(id == null || id.isBlank()) {
           throw new IllegalArgumentException("id can't be null");
       }

       if(amount < 0) {
            throw new IllegalArgumentException("Deposit and withdrawal requests can't be negative values.");
       }

        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    public Transaction(Transaction source) {
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
        this.type = source.type;
    }

    public String returnDate() {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        Date date = new Date(TimeUnit.SECONDS.toMillis(timestamp));
        return sdf.format(date);
    }

    public Type getType(){
        return this.type;
    }

    public void setType(Type type){
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Transaction o) {
        return  Long.compare(this.timestamp, o.timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return getTimestamp() == that.getTimestamp() && Double.compare(that.getAmount(), getAmount()) == 0 && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimestamp(), getId(), getAmount());
    }

    @Override
    public String toString(){
        String evenSpacing = type.equals(Type.DEPOSIT) ?  "     " : "    ";
        return (type) + evenSpacing +
                "\t" + returnDate() + "" +
                "\t" + id + "" +
                "\t$" + amount + "";
    }
    }

