package com.oceanview.service;

import com.oceanview.dao.BillDAO;
import com.oceanview.model.Bill;

public class BillService {

    public Bill calculateBill(int reservationId, int nights, double roomPrice) throws Exception {

        double total = nights * roomPrice;

        Bill bill = new Bill(reservationId, nights, roomPrice, total);

        BillDAO dao = new BillDAO();
        dao.saveBill(bill);

        return bill;
    }
}