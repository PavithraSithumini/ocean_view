package com.oceanview.service;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("AddReservationService - addReservation Tests")
class AddReservationServiceTest {

    @Mock
    private ReservationDAO reservationDAO;

    private AddReservationService service;

    private Reservation testReservation;

    @BeforeEach
    void setUp() throws Exception {
        service = new AddReservationService(reservationDAO);

        // Your exact Reservation model fields
        testReservation = new Reservation();
        testReservation.setGuestName("Kamal Perera");
        testReservation.setAddress("45 Galle Road, Colombo");
        testReservation.setContactNumber("0771234567");
        testReservation.setRoomType("Deluxe");
    }

    // ════════════════════════════════════════════════════════════════
    // 🔴 To see RED — comment out this line in AddReservationService:
    //    reservationDAO.addReservation(reservation);
    // 🟢 Uncomment it back → PASSES
    // ════════════════════════════════════════════════════════════════
    @Test
    @DisplayName("addReservation should calculate total and save reservation")
    void addReservation_ValidDates_CalculatesTotalAndSaves() throws Exception {

        // ARRANGE — mock returns 150.0 for Deluxe room
        when(reservationDAO.getPricePerNight("Deluxe")).thenReturn(150.0);

        // ACT — 4 nights : Dec 1 to Dec 5
        service.addReservation(testReservation, "2025-12-01", "2025-12-05");

        // ASSERT — 4 nights × 150.0 = 600.0
        assertEquals(600.0, testReservation.getTotalAmount(),
                "4 nights x 150.0 must equal 600.0");

        // ASSERT — dates must be parsed and set on the reservation
        assertEquals(LocalDate.of(2025, 12, 1), testReservation.getCheckIn(),
                "checkIn must be 2025-12-01");
        assertEquals(LocalDate.of(2025, 12, 5), testReservation.getCheckOut(),
                "checkOut must be 2025-12-05");

        // ASSERT — DAO must be called exactly once
        verify(reservationDAO, times(1)).addReservation(testReservation);
    }

    // ════════════════════════════════════════════════════════════════
    // TEST 2 — invalid dates must throw your exact exception message
    // ════════════════════════════════════════════════════════════════
    @Test
    @DisplayName("addReservation should throw when checkOut is before checkIn")
    void addReservation_CheckOutBeforeCheckIn_ThrowsIllegalArgumentException() throws Exception {

        // ACT + ASSERT
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> service.addReservation(testReservation, "2025-12-10", "2025-12-01"),
                "checkOut before checkIn must throw"
        );

        // ASSERT — must match your exact message in AddReservationService
        assertEquals("Check-out date must be after check-in date.",
                thrown.getMessage());

        // ASSERT — DAO must never be called for invalid dates
        verify(reservationDAO, never()).addReservation(any());
        verify(reservationDAO, never()).getPricePerNight(any());
    }
}