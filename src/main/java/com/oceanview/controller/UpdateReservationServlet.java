package com.oceanview.controller;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/updateReservation")
public class UpdateReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idStr = request.getParameter("id");
            if(idStr != null){
                int id = Integer.parseInt(idStr);
                Reservation r = new ReservationDAO().getReservationById(id);
                request.setAttribute("reservation", r);
                request.getRequestDispatcher("/jsp/updateReservation.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/viewReservations");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String guestName = request.getParameter("guestName");
            String address = request.getParameter("address");
            String contact = request.getParameter("contact");
            String roomType = request.getParameter("roomType");
            String checkIn = request.getParameter("checkIn");
            String checkOut = request.getParameter("checkOut");
            double total = Double.parseDouble(request.getParameter("total"));

            Reservation r = new Reservation(id, guestName, address, contact, roomType,
                    java.time.LocalDate.parse(checkIn), java.time.LocalDate.parse(checkOut), total);

            new ReservationDAO().updateReservation(r);

            response.sendRedirect(request.getContextPath() + "/viewReservations");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}