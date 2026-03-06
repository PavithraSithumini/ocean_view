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
            String resIdStr = request.getParameter("idaddreservation");
            String roomPriceStr = request.getParameter("roomPrice");
            String nightsStr = request.getParameter("nights");

            // Validate null or empty
            if(resIdStr == null || roomPriceStr == null || nightsStr == null ||
                    resIdStr.isEmpty() || roomPriceStr.isEmpty() || nightsStr.isEmpty()) {

                request.setAttribute("error", "All fields are required!");
                request.getRequestDispatcher("/jsp/billForm.jsp").forward(request, response);
                return;
            }

            int reservationId = Integer.parseInt(resIdStr);
            double roomPrice = Double.parseDouble(roomPriceStr); // Must be numeric
            int nights = Integer.parseInt(nightsStr);

            // Calculate total
            double roomCharge = roomPrice * nights;
            double serviceCharge = roomCharge * 0.05; // 5%
            double tax = roomCharge * 0.1; // 10%
            double total = roomCharge + serviceCharge + tax;

            // Create Bill object
            Bill bill = new Bill();
            bill.setReservationId(reservationId);
            bill.setNights(nights);
            bill.setTotal(total);


            // Forward to receipt
            request.setAttribute("bill", bill);
            request.getRequestDispatcher("/jsp/billReceipt.jsp").forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error generating bill: " + e.getMessage());
            request.getRequestDispatcher("/jsp/billForm.jsp").forward(request, response);
        }
    }
}