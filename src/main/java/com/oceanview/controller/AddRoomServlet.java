package com.oceanview.controller;

import com.oceanview.model.Room;
import com.oceanview.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/addRoom")
public class AddRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roomType = request.getParameter("roomType");
        double pricePerNight = Double.parseDouble(request.getParameter("pricePerNight"));

        Room room = new Room();
        room.setRoomType(roomType);
        room.setPricePerNight(pricePerNight);

        try {
            RoomService service = new RoomService();
            service.addRoom(room);

            response.sendRedirect("jsp/addRoom.jsp?success=Room Added");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    // GET request just forwards to JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/addRoom.jsp").forward(request, response);
    }
}