package com.oceanview.dao;

import com.oceanview.model.Reservation;
import com.oceanview.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
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
                "INSERT INTO addreservation (guestName,address,contactNumber,roomType,checkIn,check_out,total_amount) " +
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

    public List<Reservation> getAllReservations() throws Exception {
        List<Reservation> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT r.idaddreservation, r.guestName, r.address, r.contactNumber, " +
                             "rm.room_type, rm.price_per_night, r.checkIn, r.check_out, r.total_amount " +
                             "FROM addreservation r " +
                             "JOIN rooms rm ON r.roomType = rm.room_id"
             );
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setReservationId(rs.getInt("idaddreservation"));
                r.setGuestName(rs.getString("guestName"));
                r.setAddress(rs.getString("address"));
                r.setContactNumber(rs.getString("contactNumber"));
                r.setRoomType(rs.getString("room_type"));
                r.setCheckIn(rs.getDate("checkIn").toLocalDate());
                r.setCheckOut(rs.getDate("check_out").toLocalDate());
                r.setTotalAmount(rs.getDouble("total_amount"));
                list.add(r);
            }
        }
        return list;
    }


    public double getPricePerNight(String roomType) throws Exception {
        double price = 0;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT price_per_night FROM rooms WHERE room_type=?")) {
            ps.setString(1, roomType);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) price = rs.getDouble("price_per_night");
                else throw new Exception("Room type not found.");
            }
        }
        return price;
    }

    public Reservation getReservationById(int reservationId) throws Exception {
        Reservation reservation = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT r.*, rm.room_type, rm.price_per_night  " +
                             "FROM addreservation r JOIN rooms rm ON r.roomType = rm.room_id " +
                             "WHERE r.idaddreservation = ?")) {

            ps.setInt(1, reservationId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reservation = new Reservation();
                    reservation.setReservationId(rs.getInt("idaddreservation"));
                    reservation.setGuestName(rs.getString("guestName"));
                    reservation.setAddress(rs.getString("address"));
                    reservation.setContactNumber(rs.getString("contactNumber"));
                    reservation.setRoomType(rs.getString("room_type")); // fetch room type from join
                    reservation.setCheckIn(rs.getDate("checkIn").toLocalDate());
                    reservation.setCheckOut(rs.getDate("check_out").toLocalDate());
                    reservation.setTotalAmount(rs.getDouble("total_amount"));
                }
            }
        }

        return reservation;
    }
}