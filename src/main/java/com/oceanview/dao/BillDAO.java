package com.oceanview.dao;

import com.oceanview.model.Bill;
import com.oceanview.util.DBConnection;

import java.sql.*;

public class BillDAO {

    public void saveBill(Bill bill) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();

            // ✅ Correct table: bill (not bills)
            // ✅ No bill_id — it is AUTO_INCREMENT
            String sql = "INSERT INTO bill (idaddreservation, roomType, price_per_night, nights, total) " +
                    "VALUES (?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, bill.getReservationId());     // idaddreservation
            ps.setString(2, bill.getRoomType());       // roomType
            ps.setDouble(3, bill.getPricePerNight());  // price_per_night
            ps.setInt(4, bill.getNights());            // nights
            ps.setDouble(5, bill.getTotal());          // total

            ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }
}