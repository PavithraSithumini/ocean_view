package com.oceanview.service;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.dao.RoomDAO;
import com.oceanview.model.Bill;
import com.oceanview.model.Reservation;
import com.oceanview.model.Room;

public class BillService {

    private final ReservationDAO reservationDAO;
    private final RoomDAO roomDAO;

    // Original constructor — used in production (servlets)
    public BillService() {
        this.reservationDAO = new ReservationDAO();
        this.roomDAO = new RoomDAO();
    }

    // NEW constructor — used in tests (inject mocks)
    public BillService(ReservationDAO reservationDAO, RoomDAO roomDAO) {
        this.reservationDAO = reservationDAO;
        this.roomDAO = roomDAO;
    }

    public Bill generateBill(int reservationId, String roomType, int nights) throws Exception {

        Reservation reservation = reservationDAO.getReservationById(reservationId);
        if (reservation == null) {
            throw new Exception("Reservation not found.");
        }

        double price = 0;
        for (Room r : roomDAO.getAllRooms()) {
            if (r.getRoomType().equalsIgnoreCase(roomType)) {
                price = r.getPricePerNight();
                break;
            }
        }

        if (price == 0) {
            throw new Exception("Room type not found.");
        }

        return new Bill(
                reservation.getReservationId(),
                reservation.getGuestName(),
                roomType,
                price,
                nights
        );
    }
}