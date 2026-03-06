package com.oceanview.model;

public class Bill {

    private int reservationId;
    private int nights;
    private double roomPrice;
    private double total;

    public Bill(){}

    public Bill(int reservationId, int nights, double roomPrice, double total) {
        this.reservationId = reservationId;
        this.nights = nights;
        this.roomPrice = roomPrice;
        this.total = total;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}