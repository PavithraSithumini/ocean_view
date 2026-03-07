package com.oceanview.dao;

import com.oceanview.model.Reservation;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.oceanview.util.DBConnection.getConnection;

public class ReservationDAO {

    // Add reservation
    public void addReservation(Reservation reservation) throws Exception {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO addreservation " +
                            "(guestName, address, contactNumber, roomType, checkIn, check_out, total_amount) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, reservation.getGuestName());
            ps.setString(2, reservation.getAddress());
            ps.setString(3, reservation.getContactNumber());
            ps.setString(4, reservation.getRoomType());
            ps.setString(5, reservation.getCheckIn().toString());   // ✅ varchar
            ps.setString(6, reservation.getCheckOut().toString());  // ✅ varchar
            ps.setDouble(7, reservation.getTotalAmount());
            ps.executeUpdate();
        }
    }

    // Get all reservations
    public List<Reservation> getAllReservations() throws Exception {
        List<Reservation> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM addreservation");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setReservationId(rs.getInt("idaddreservation"));
                r.setGuestName(rs.getString("guestName"));
                r.setAddress(rs.getString("address"));
                r.setContactNumber(rs.getString("contactNumber"));
                r.setRoomType(rs.getString("roomType"));
                r.setCheckIn(LocalDate.parse(rs.getString("checkIn")));    // ✅ varchar → LocalDate
                r.setCheckOut(LocalDate.parse(rs.getString("check_out"))); // ✅ varchar → LocalDate
                r.setTotalAmount(rs.getDouble("total_amount"));
                list.add(r);
            }
        }
        return list;
    }

    // Get reservation by ID
    public Reservation getReservationById(int reservationId) throws Exception {
        Reservation reservation = null;
        String sql = "SELECT * FROM addreservation WHERE idaddreservation=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, reservationId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reservation = new Reservation();
                    reservation.setReservationId(rs.getInt("idaddreservation"));
                    reservation.setGuestName(rs.getString("guestName"));
                    reservation.setAddress(rs.getString("address"));
                    reservation.setContactNumber(rs.getString("contactNumber"));
                    reservation.setRoomType(rs.getString("roomType"));
                    reservation.setCheckIn(LocalDate.parse(rs.getString("checkIn")));    // ✅
                    reservation.setCheckOut(LocalDate.parse(rs.getString("check_out"))); // ✅
                    reservation.setTotalAmount(rs.getDouble("total_amount"));
                }
            }
        }
        return reservation;
    }

    // Update reservation
    public void updateReservation(Reservation r) throws Exception {
        String sql = "UPDATE addreservation " +
                "SET guestName=?, address=?, contactNumber=?, roomType=?, " +
                "checkIn=?, check_out=?, total_amount=? " +
                "WHERE idaddreservation=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, r.getGuestName());
            ps.setString(2, r.getAddress());
            ps.setString(3, r.getContactNumber());
            ps.setString(4, r.getRoomType());
            ps.setString(5, r.getCheckIn().toString());
            ps.setString(6, r.getCheckOut().toString());
            ps.setDouble(7, r.getTotalAmount());
            ps.setInt(8, r.getReservationId());
            ps.executeUpdate();
        }
    }

    // Delete reservation
    public void deleteReservation(int id) throws Exception {
        String sql = "DELETE FROM addreservation WHERE idaddreservation=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // Get price per night from rooms table
    public double getPricePerNight(String roomType) throws Exception {
        String sql = "SELECT price_per_night FROM rooms WHERE room_type = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, roomType);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("price_per_night");
                }
            }
        }
        return 0;
    }
}