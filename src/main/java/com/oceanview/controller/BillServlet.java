package com.oceanview.controller;

import com.oceanview.model.Bill;
import com.oceanview.service.BillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/billFrom")
public class BillServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int reservationId = Integer.parseInt(request.getParameter("reservationId"));
            int nights = Integer.parseInt(request.getParameter("nights"));
            double roomPrice = Double.parseDouble(request.getParameter("roomPrice"));

            BillService service = new BillService();

            Bill bill = service.calculateBill(reservationId, nights, roomPrice);

            request.setAttribute("bill", bill);

            request.getRequestDispatcher("/jsp/billForm.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}