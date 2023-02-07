package org.example;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String fromAirport;
    private String toAirport;
    private int travelTime;

    public Ticket(int id, int price, String fromAirport, String toAirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
            return (this.price - o.price);
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }
}