package com.oceanview.model;

public class Bill {
    private int reservationId;
    private int nights;
    private double roomPrice;
    private double roomCharge;
    private double serviceCharge;
    private double tax;
    private double total;

    // getters and setters
    public int getReservationId() { return reservationId; }
    public void setReservationId(int reservationId) { this.reservationId = reservationId; }
    public int getNights() { return nights; }
    public void setNights(int nights) { this.nights = nights; }
    public double getRoomPrice() { return roomPrice; }
    public void setRoomPrice(double roomPrice) { this.roomPrice = roomPrice; }
    public double getRoomCharge() { return roomCharge; }
    public void setRoomCharge(double roomCharge) { this.roomCharge = roomCharge; }
    public double getServiceCharge() { return serviceCharge; }
    public void setServiceCharge(double serviceCharge) { this.serviceCharge = serviceCharge; }
    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}