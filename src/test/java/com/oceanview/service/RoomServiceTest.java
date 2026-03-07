package com.oceanview.service;

import com.oceanview.dao.RoomDAO;
import com.oceanview.model.Room;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("RoomService - addRoom Tests")
class RoomServiceTest {

    @Mock
    private RoomDAO roomDAO;

    private RoomService roomService;

    private Room testRoom;

    @BeforeEach
    void setUp() throws Exception {
        roomService = new RoomService(roomDAO);

        // Build test data from your exact Room model
        testRoom = new Room();
        testRoom.setRoomId(1);
        testRoom.setRoomType("Deluxe");
        testRoom.setPricePerNight(150.0);
    }

    // ════════════════════════════════════════════════════════════════
    // 🔴 Run this first → FAILS (no injectable constructor yet)
    // 🟢 Add constructor in Step 1 above → PASSES
    // ════════════════════════════════════════════════════════════════
    @Test
    @DisplayName("addRoom should call DAO to save the room")
    void addRoom_ValidRoom_CallsDAO() throws Exception {

        // ACT
        roomService.addRoom(testRoom);

        // ASSERT — verify DAO was called exactly once with the correct room
        verify(roomDAO, times(1)).addRoom(testRoom);
    }
}