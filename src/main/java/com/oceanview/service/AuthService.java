package com.oceanview.service;

import com.oceanview.dao.UserDAO;

public class AuthService {

    public String login(String username, String password) {

        UserDAO dao = new UserDAO();
        return dao.validateUser(username, password);
    }
}
