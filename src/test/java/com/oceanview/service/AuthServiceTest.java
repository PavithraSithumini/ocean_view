package com.oceanview.service;

import com.oceanview.dao.UserDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("AuthService - login Tests")
class AuthServiceTest {

    @Mock
    private UserDAO userDAO;

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService(userDAO);
    }

    // ════════════════════════════════════════════════════════════════
    // 🔴 Run this first → FAILS (no injectable constructor yet)
    // 🟢 Add constructor in Step 1 above → PASSES
    // ════════════════════════════════════════════════════════════════
    @Test
    @DisplayName("login should return role when valid credentials are given")
    void login_ValidCredentials_ReturnsRole() {

        // ARRANGE — mock returns "ADMIN" for valid credentials
        when(userDAO.validateUser("admin", "admin123")).thenReturn("ADMIN");

        // ACT
        String result = authService.login("admin", "admin123");

        // ASSERT
        assertNotNull(result,          "Role must not be null for valid credentials");
        assertEquals("ADMIN", result,  "Role must be ADMIN");

        verify(userDAO, times(1)).validateUser("admin", "admin123");
    }
}