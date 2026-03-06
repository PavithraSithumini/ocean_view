package com.oceanview.service;

import com.oceanview.dao.BillDAO;
import com.oceanview.model.Bill;
import com.oceanview.model.Payment;

public class BillService {

    public Bill calculateBill(int reservationId, int nights, double roomPrice) throws Exception {

        double roomCharge = nights * roomPrice;
        double serviceCharge = roomCharge * 0.10;
        double tax = roomCharge * 0.05;
        double total = roomCharge + serviceCharge + tax;

        // create Bill object
        Bill bill = new Bill();
        bill.setReservationId(reservationId);
        bill.setNights(nights);
        bill.setRoomPrice(roomPrice);
        bill.setRoomCharge(roomCharge);
        bill.setServiceCharge(serviceCharge);
        bill.setTax(tax);
        bill.setTotal(total);

        // create Payment object
        Payment payment = new Payment();
        payment.setReservationId(reservationId);
        payment.setRoomCharge(roomCharge);
        payment.setServiceCharge(serviceCharge);
        payment.setTax(tax);
        payment.setTotalAmount(total);

        // save payment
        BillDAO dao = new BillDAO();
        dao.savePayment(payment);

        return bill;
    }
}