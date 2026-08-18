package com.movieticket.booking;

public class Booking {

    private int id;
    private String customerName;
    private int movieId;
    private int numberOfTickets;

    public Booking() {
    }

    public Booking(int id, String customerName, int movieId, int numberOfTickets) {
        this.id = id;
        this.customerName = customerName;
        this.movieId = movieId;
        this.numberOfTickets = numberOfTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
