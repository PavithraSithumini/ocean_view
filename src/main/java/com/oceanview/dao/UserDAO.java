package com.oceanview.dao;

import com.oceanview.util.DBConnection;
import java.sql.*;

public class UserDAO {

    public String validateUser(String username, String password) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT role FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("role");  // ADMIN or STAFF
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
