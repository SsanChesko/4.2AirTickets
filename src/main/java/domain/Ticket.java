package domain;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int timeOnAir;

    public Ticket() {
    }

    public Ticket(int id, int price, String departure, String arrival, int timeOnAir) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.timeOnAir = timeOnAir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getTimeOnAir() {
        return timeOnAir;
    }

    public void setTimeOnAir(int timeOnAir) {
        this.timeOnAir = timeOnAir;
    }

    public int compareTo(Ticket o) {
        return price - o.price;
    }
}
