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

    public AddReservationService(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }


    public void addReservation(Reservation reservation, String checkInStr, String checkOutStr) throws Exception {
        LocalDate checkIn = LocalDate.parse(checkInStr);
        LocalDate checkOut = LocalDate.parse(checkOutStr);

        if(checkOut.isBefore(checkIn) || checkOut.equals(checkIn))
            throw new IllegalArgumentException("Check-out date must be after check-in date.");

        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);

        // Calculate nights and total
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        double pricePerNight = reservationDAO.getPricePerNight(reservation.getRoomType());
        reservation.setTotalAmount(pricePerNight * nights);

        reservationDAO.addReservation(reservation);
    }



}