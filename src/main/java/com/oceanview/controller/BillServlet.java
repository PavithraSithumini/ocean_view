package com.oceanview.controller;

import com.oceanview.model.Bill;
import com.oceanview.service.BillService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/calculateBill")
public class BillServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int reservationId = Integer.parseInt(request.getParameter("reservationId"));

            BillService service = new BillService();
            Bill bill = service.generateBill(reservationId);

            request.setAttribute("bill", bill);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/bill.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/addReservation.jsp");
    }
}