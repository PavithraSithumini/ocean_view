package com.oceanview.model;

import java.time.LocalDate;

public class Reservation {

    private int reservationId;
    private String guestName;
    private String address;
    private String contactNumber;
    private String roomType;
    private double totalAmount;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setCheckOut(LocalDate checkOut) {
    }

    public void setCheckIn(LocalDate checkIn) {
    }

    public LocalDate getCheckIn() {
        return null;
    }

    public LocalDate getCheckOut() {


        return null;
    }


}