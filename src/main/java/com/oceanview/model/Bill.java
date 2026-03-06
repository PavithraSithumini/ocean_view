package com.oceanview.model;

public class Bill {
    private int reservationId;
    private String guestName;
    private String roomType;
    private double pricePerNight;
    private int nights;
    private double total;

    // Constructors
    public Bill() { }

    public Bill(int reservationId, String guestName, String roomType, double pricePerNight, int nights) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.nights = nights;
        this.total = pricePerNight * nights;
    }

    // Getters and setters
    public int getReservationId() { return reservationId; }
    public void setReservationId(int reservationId) { this.reservationId = reservationId; }

    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public int getNights() { return nights; }
    public void setNights(int nights) { this.nights = nights; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getRoomPrice() {
        return 0;
    }
}