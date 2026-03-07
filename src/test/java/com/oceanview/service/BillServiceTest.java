package com.oceanview.service;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.dao.RoomDAO;
import com.oceanview.model.Bill;
import com.oceanview.model.Reservation;
import com.oceanview.model.Room;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("BillService - generateBill Tests")
class BillServiceTest {

    @Mock
    private ReservationDAO reservationDAO;

    @Mock
    private RoomDAO roomDAO;

    private BillService billService;

    private Reservation testReservation;
    private Room testDeluxeRoom;

    @BeforeEach
    void setUp() {
        billService = new BillService(reservationDAO, roomDAO);

        // Build test data from your exact Reservation model
        testReservation = new Reservation(
                1,
                "Kamal Perera",
                "45 Galle Road, Colombo",
                "0771234567",
                "Deluxe",
                LocalDate.of(2025, 12, 1),
                LocalDate.of(2025, 12, 5),
                0.0
        );

        // Build test data from your exact Room model
        testDeluxeRoom = new Room();
        testDeluxeRoom.setRoomId(1);
        testDeluxeRoom.setRoomType("Deluxe");
        testDeluxeRoom.setPricePerNight(150.0);
    }

    // ════════════════════════════════════════════════════════════════
    // 🔴 Run this first → FAILS (no injectable constructor yet)
    // 🟢 Add constructor in Step 1 above → PASSES
    // ════════════════════════════════════════════════════════════════
    @Test
    @DisplayName("generateBill should return correct Bill with proper total amount")
    void generateBill_ValidReservationAndRoom_ReturnsCorrectBill() throws Exception {

        // ARRANGE
        when(reservationDAO.getReservationById(1)).thenReturn(testReservation);
        when(roomDAO.getAllRooms()).thenReturn(Arrays.asList(testDeluxeRoom));

        // ACT
        Bill result = billService.generateBill(1, "Deluxe", 4);

        // ASSERT — check all fields from your Bill model
        assertNotNull(result,                            "Bill must not be null");
        assertEquals(1,              result.getReservationId(), "Reservation ID must be 1");
        assertEquals("Kamal Perera", result.getGuestName(),     "Guest name must match reservation");
        assertEquals("Deluxe",       result.getRoomType(),      "Room type must be Deluxe");
        assertEquals(150.0,          result.getPricePerNight(), "Price per night must be 150.0");
        assertEquals(4,              result.getNights(),        "Nights must be 4");
        assertEquals(600.0,          result.getTotal(),         "4 nights × 150.0 must equal 600.0");

        verify(reservationDAO, times(1)).getReservationById(1);
        verify(roomDAO,        times(1)).getAllRooms();
    }
}