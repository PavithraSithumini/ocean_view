package com.oceanview.service;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.dao.RoomDAO;
import com.oceanview.model.Bill;
import com.oceanview.model.Reservation;
import com.oceanview.model.Room;

public class BillService {

    public Bill generateBill(int reservationId, String roomType, int nights) throws Exception {
        // Get reservation details
        ReservationDAO reservationDAO = new ReservationDAO();
        Reservation reservation = reservationDAO.getReservationById(reservationId);
        if(reservation == null) {
            throw new Exception("Reservation not found.");
        }

        // Get room price
        RoomDAO roomDAO = new RoomDAO();
        double price = 0;
        for(Room r : roomDAO.getAllRooms()) {
            if(r.getRoomType().equalsIgnoreCase(roomType)) {
                price = r.getPricePerNight();
                break;
            }
        }

        if(price == 0) {
            throw new Exception("Room type not found.");
        }

        // Create Bill object
        return new Bill(reservation.getReservationId(),
                reservation.getGuestName(),
                roomType,
                price,
                nights);
    }
}