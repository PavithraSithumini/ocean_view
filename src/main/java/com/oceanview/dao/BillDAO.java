package com.oceanview.dao;

import com.oceanview.model.Bill;
import com.oceanview.util.DBConnection;

import java.sql.*;

public class BillDAO {

    public void saveBill(Bill bill) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO bills(reservation_id,nights,room_price,total) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, bill.getReservationId());
        ps.setInt(2, bill.getNights());
        ps.setDouble(3, bill.getRoomPrice());
        ps.setDouble(4, bill.getTotal());

        ps.executeUpdate();
    }
}