package com.oceanview.service;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

import java.util.List;

public class ReservationService {

    private ReservationDAO reservationDAO = new ReservationDAO();

    public List<Reservation> getAllReservations() throws Exception {
        return reservationDAO.getAllReservations();
    }
}