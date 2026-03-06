package com.oceanview.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

@WebServlet("/AddReservationServlet")
public class AddReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        String address = request.getParameter("address");
        String contactNumber = request.getParameter("contactNumber");
        String roomType = request.getParameter("roomType");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");

        String url = "jdbc:mysql://localhost:3306/oceanview_db";
        String user = "root";
        String password = "1234"; // <-- change this

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            // Get room_id from rooms table
            PreparedStatement ps1 = con.prepareStatement("SELECT room_id FROM rooms WHERE room_type=?");
            ps1.setString(1, roomType);
            ResultSet rs = ps1.executeQuery();
            int roomId = 0;
            if(rs.next()) roomId = rs.getInt("room_id");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO reservations (guest_name, address, contact_number, room_id, check_in, check_out) VALUES (?,?,?,?,?,?)"
            );
            ps.setString(1, guestName);
            ps.setString(2, address);
            ps.setString(3, contactNumber);
            ps.setInt(4, roomId);
            ps.setDate(5, Date.valueOf(checkIn));
            ps.setDate(6, Date.valueOf(checkOut));

            ps.executeUpdate();

            ps.close();
            con.close();

            response.sendRedirect("addReservation.jsp?success=Reservation Added");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}