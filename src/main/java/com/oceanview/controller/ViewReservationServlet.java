package com.oceanview.controller;

import com.oceanview.model.Reservation;
import com.oceanview.service.ReservationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewReservations")
public class ViewReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            ReservationService service = new ReservationService();

            List<Reservation> list = service.getAllReservations();

            request.setAttribute("reservations", list);

            RequestDispatcher rd = request.getRequestDispatcher("/jsp/viewReservations.jsp");
            rd.forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();



        }
    }
}