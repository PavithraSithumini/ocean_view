package com.oceanview.service;

import com.oceanview.dao.UserDAO;

public class AuthService {

    private final UserDAO userDAO;

    // Original — keep this
    public AuthService() {
        this.userDAO = new UserDAO();
    }

    // NEW — for testing only
    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String login(String username, String password) {
        return userDAO.validateUser(username, password);
    }
}