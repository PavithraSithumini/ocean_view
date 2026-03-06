package com.oceanview.controller;

import com.oceanview.model.Reservation;
import com.oceanview.service.AddReservationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/AddReservationServlet")
public class AddReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String guestName = request.getParameter("guestName");
            String address = request.getParameter("address");
            String contactNumber = request.getParameter("contactNumber");
            String roomType = request.getParameter("roomType");
            String checkIn = request.getParameter("checkIn");
            String checkOut = request.getParameter("checkOut");

            Reservation reservation = new Reservation();
            reservation.setGuestName(guestName);
            reservation.setAddress(address);
            reservation.setContactNumber(contactNumber);
            reservation.setRoomType(roomType);



            if(checkIn == null || checkOut == null || checkIn.isEmpty() || checkOut.isEmpty()) {
                response.getWriter().println("Error: Check-in and Check-out dates must be provided.");
                return;
            }

            AddReservationService service = new AddReservationService();
            service.addReservation(reservation, checkIn, checkOut);

            response.sendRedirect(request.getContextPath() + "/jsp/addReservation.jsp?success=Reservation Added");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    // Optional: redirect GET to form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/jsp/addReservation.jsp");
    }
}