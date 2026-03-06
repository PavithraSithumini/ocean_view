package com.oceanview.controller;

import com.oceanview.model.Bill;
import com.oceanview.service.BillService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/calculateBill")
public class CalculateBillServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int reservationId = Integer.parseInt(request.getParameter("reservationId"));
            String roomType = request.getParameter("roomType");
            int nights = Integer.parseInt(request.getParameter("nights"));

            BillService billService = new BillService();
            Bill bill = billService.generateBill(reservationId, roomType, nights);

            request.setAttribute("bill", bill);
            request.getRequestDispatcher("/jsp/billReceipt.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to generate bill: " + e.getMessage());
            request.getRequestDispatcher("/jsp/billReceipt.jsp").forward(request, response);
        }
    }
}