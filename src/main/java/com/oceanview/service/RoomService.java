package com.oceanview.service;

import com.oceanview.dao.RoomDAO;
import com.oceanview.model.Room;

import java.util.List;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();

    public void addRoom(Room room) throws Exception {
        roomDAO.addRoom(room);
    }

    public void deleteRoom(int roomId) throws Exception {
        roomDAO.deleteRoom(roomId);
    }

    public List<Room> getAllRooms() throws Exception {
        return roomDAO.getAllRooms();
    }
}