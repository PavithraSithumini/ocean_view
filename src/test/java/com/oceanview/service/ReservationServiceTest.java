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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ReservationService - getAllReservations Tests")
class ReservationServiceTest {

    @Mock
    private ReservationDAO reservationDAO;

    private ReservationService reservationService;

    private Reservation testReservation1;
    private Reservation testReservation2;

    @BeforeEach
    void setUp() {
        reservationService = new ReservationService(reservationDAO);

        // Build test data using your exact Reservation model fields
        testReservation1 = new Reservation(
                1,
                "Kamal Perera",
                "45 Galle Road, Colombo",
                "0771234567",
                "Deluxe",
                LocalDate.of(2025, 12, 1),
                LocalDate.of(2025, 12, 5),
                600.0
        );

        testReservation2 = new Reservation(
                2,
                "Nimal Bandara",
                "22 Temple Road, Kandy",
                "0712345678",
                "Suite",
                LocalDate.of(2025, 12, 10),
                LocalDate.of(2025, 12, 17),
                2100.0
        );
    }

    // ════════════════════════════════════════════════════════════════
    // 🔴 Run this first → FAILS (no injectable constructor yet)
    // 🟢 Add constructor in Step 1 above → PASSES
    // ════════════════════════════════════════════════════════════════
    @Test
    @DisplayName("getAllReservations should return all reservations from DAO")
    void getAllReservations_ReturnsAllReservations() throws Exception {

        // ARRANGE — mock DAO returns our two test reservations
        when(reservationDAO.getAllReservations())
                .thenReturn(Arrays.asList(testReservation1, testReservation2));

        // ACT
        List<Reservation> result = reservationService.getAllReservations();

        // ASSERT — list must not be null or empty
        assertNotNull(result,        "Result list must not be null");
        assertEquals(2, result.size(),"Must return exactly 2 reservations");

        // ASSERT — first reservation fields match your model
        assertEquals(1,             result.get(0).getReservationId(), "First ID must be 1");
        assertEquals("Kamal Perera",result.get(0).getGuestName(),     "First guest must be Kamal Perera");
        assertEquals("Deluxe",      result.get(0).getRoomType(),      "First room type must be Deluxe");
        assertEquals(600.0,         result.get(0).getTotalAmount(),   "First total must be 600.0");

        // ASSERT — second reservation fields match your model
        assertEquals(2,             result.get(1).getReservationId(), "Second ID must be 2");
        assertEquals("Nimal Bandara",result.get(1).getGuestName(),    "Second guest must be Nimal Bandara");
        assertEquals("Suite",       result.get(1).getRoomType(),      "Second room type must be Suite");
        assertEquals(2100.0,        result.get(1).getTotalAmount(),   "Second total must be 2100.0");

        // ASSERT — DAO was called exactly once
        verify(reservationDAO, times(1)).getAllReservations();
    }
}