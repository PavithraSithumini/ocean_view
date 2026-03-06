package com.oceanview.controller;

import com.oceanview.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/deleteRoom")
public class DeleteRoomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int roomId = Integer.parseInt(request.getParameter("id")); // <-- must match JSP

            RoomService service = new RoomService();
            service.deleteRoom(roomId);

            response.sendRedirect("viewRooms"); // redirect to view all rooms
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}