package com.oceanview.controller;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getReservation")
public class GetReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ReservationDAO dao = new ReservationDAO();
            Reservation res = dao.getReservationById(id);

            if (res != null) {
                out.print("{\"guestName\":\"" + res.getGuestName() + "\"}");
            } else {
                out.print("{\"error\":\"not found\"}");
            }
        } catch (Exception e) {
            out.print("{\"error\":\"invalid id\"}");
        }
    }
}