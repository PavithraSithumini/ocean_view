package com.oceanview.dao;

import com.oceanview.model.Payment;
import com.oceanview.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillDAO {

    public void savePayment(Payment payment) throws Exception {

        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO payments(reservation_id, room_charge, service_charge, tax, total_amount) VALUES (?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, payment.getReservationId());
        ps.setDouble(2, payment.getRoomCharge());
        ps.setDouble(3, payment.getServiceCharge());
        ps.setDouble(4, payment.getTax());
        ps.setDouble(5, payment.getTotalAmount());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }
}