package com.oceanview.service;

import com.oceanview.dao.BillDAO;
import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Bill;
import com.oceanview.model.Reservation;

public class BillService {

    private ReservationDAO reservationDAO = new ReservationDAO();
    private BillDAO billDAO = new BillDAO();

    public Bill generateBill(int reservationId) throws Exception {

        // Fetch reservation
        Reservation res = reservationDAO.getReservationById(reservationId);
        if(res == null) throw new Exception("Reservation not found!");

        // Calculate nights
        int nights = (int) java.time.temporal.ChronoUnit.DAYS.between(res.getCheckIn(), res.getCheckOut());

        // Get price from database
        double pricePerNight = reservationDAO.getPricePerNight(res.getRoomType());

        // Calculate bill
        double roomCharge = pricePerNight * nights;
        double serviceCharge = roomCharge * 0.10; // 10%
        double tax = roomCharge * 0.05; // 5%
        double total = roomCharge + serviceCharge + tax;

        Bill bill = new Bill();
        bill.setReservationId(reservationId);
        bill.setNights(nights);
        bill.setRoomPrice(pricePerNight);
        bill.setRoomCharge(roomCharge);
        bill.setServiceCharge(serviceCharge);
        bill.setTax(tax);
        bill.setTotal(total);

        // Save payment
        billDAO.savePayment(bill, reservationId);

        return bill;
    }
}