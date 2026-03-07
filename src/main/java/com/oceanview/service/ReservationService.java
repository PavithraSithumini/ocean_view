package com.oceanview.service;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;
import java.util.List;

public class ReservationService {

    private final ReservationDAO reservationDAO;

    // Original — keep this
    public ReservationService() {
        this.reservationDAO = new ReservationDAO();
    }

    // NEW — for testing only
    public ReservationService(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public List<Reservation> getAllReservations() throws Exception {
        return reservationDAO.getAllReservations();
    }
}