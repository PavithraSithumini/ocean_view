package com.oceanview.dao;

import com.oceanview.model.Bill;
import com.oceanview.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillDAO {

    public void savePayment(Bill bill, int reservationId) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO payments(reservation_id, room_charge, service_charge, tax, total_amount) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, reservationId);
        ps.setDouble(2, bill.getRoomCharge());
        ps.setDouble(3, bill.getServiceCharge());
        ps.setDouble(4, bill.getTax());
        ps.setDouble(5, bill.getTotal());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}