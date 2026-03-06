package com.oceanview.dao;

import com.oceanview.model.Room;
import com.oceanview.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    // Add room
    public void addRoom(Room room) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO rooms (room_type, price_per_night) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, room.getRoomType());
        ps.setDouble(2, room.getPricePerNight());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    // Delete room
    public void deleteRoom(int roomId) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM rooms WHERE room_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, roomId);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    // Get all rooms
    public List<Room> getAllRooms() throws Exception {
        List<Room> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM rooms";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Room r = new Room();
            r.setRoomId(rs.getInt("room_id"));
            r.setRoomType(rs.getString("room_type"));
            r.setPricePerNight(rs.getDouble("price_per_night"));
            list.add(r);
        }

        rs.close();
        ps.close();
        conn.close();
        return list;
    }
}