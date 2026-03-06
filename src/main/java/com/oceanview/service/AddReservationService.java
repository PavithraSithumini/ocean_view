package com.oceanview.service;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AddReservationService {
    private ReservationDAO reservationDAO;

    public AddReservationService() {
        reservationDAO = new ReservationDAO();
    }

    /**
     * Adds a reservation after calculating total amount.
     *
     * @param reservation Reservation object from servlet
     * @param checkInStr Check-in date as string (yyyy-MM-dd)
     * @param checkOutStr Check-out date as string (yyyy-MM-dd)
     * @throws Exception if database operation fails
     */
    public void addReservation(Reservation reservation, String checkInStr, String checkOutStr) throws Exception {

        // Convert strings to LocalDate
        LocalDate checkIn = LocalDate.parse(checkInStr);
        LocalDate checkOut = LocalDate.parse(checkOutStr);

        if (checkOut.isBefore(checkIn) || checkOut.equals(checkIn)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }

        // Set reservation dates
        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);

        // Calculate total nights
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

        // Calculate total amount based on room type
        double pricePerNight = getPricePerNight(reservation.getRoomType());
        reservation.setTotalAmount(pricePerNight * nights);

        // Call DAO to save to DB
        reservationDAO.addReservation(reservation);
    }

    /**
     * Returns price per night based on room type.
     */
    private double getPricePerNight(String roomType) {
        switch (roomType) {
            case "Single": return 50;
            case "Double": return 80;
            case "Suite": return 120;
            default: throw new IllegalArgumentException("Invalid room type: " + roomType);
        }
    }
}

