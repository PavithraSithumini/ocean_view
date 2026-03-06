package com.oceanview.controller;

import com.oceanview.model.Bill;
import com.oceanview.service.BillService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/calculateBill")
public class CalculateBillServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int reservationId = Integer.parseInt(request.getParameter("idaddreservation"));
            int nights = Integer.parseInt(request.getParameter("nights"));
            double roomPrice = Double.parseDouble(request.getParameter("roomPrice"));

            BillService service = new BillService();

            Bill bill = service.calculateBill(reservationId, nights, roomPrice);

            request.setAttribute("bill", bill);

            RequestDispatcher rd = request.getRequestDispatcher("/jsp/billReceipt.jsp");
            rd.forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

        }
        int reservationId = Integer.parseInt(request.getParameter("idaddreservation"));
        int nights = Integer.parseInt(request.getParameter("nights"));

        double roomPrice = Double.parseDouble(request.getParameter("roomPrice"));

        double total = roomPrice * nights;
    }
}