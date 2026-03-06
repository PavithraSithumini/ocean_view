package com.oceanview.dao;

import com.oceanview.model.Reservation;
import com.oceanview.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public class ReservationDAO {

    public void addReservation(Reservation reservation) throws Exception {

        Connection conn = DBConnection.getConnection();

        // Get room_id from rooms table
        PreparedStatement ps1 = conn.prepareStatement("SELECT room_id FROM rooms WHERE room_type=?");
        ps1.setString(1, reservation.getRoomType());
        ResultSet rs = ps1.executeQuery();

        int roomId = 0;
        if (rs.next()) roomId = rs.getInt("room_id");

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO reservations (guest_name,address,contact_number,room_id,check_in,check_out,total_amount) " +
                        "VALUES (?,?,?,?,?,?,?)"
        );

        ps.setString(1, reservation.getGuestName());
        ps.setString(2, reservation.getAddress());
        ps.setString(3, reservation.getContactNumber());
        ps.setInt(4, roomId);
        ps.setDate(5, java.sql.Date.valueOf(reservation.getCheckIn()));
        ps.setDate(6, java.sql.Date.valueOf(reservation.getCheckOut()));
        ps.setDouble(7, reservation.getTotalAmount());

        ps.executeUpdate();

        // Close resources
        ps.close();
        rs.close();
        ps1.close();
        conn.close();
    }

    public List<Reservation> getAllReservations() {
        return List.of();
    }
}