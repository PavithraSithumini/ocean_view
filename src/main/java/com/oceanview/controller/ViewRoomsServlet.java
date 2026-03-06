package com.oceanview.controller;

import com.oceanview.model.Room;
import com.oceanview.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewRooms")
public class ViewRoomsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            RoomService service = new RoomService();
            List<Room> rooms = service.getAllRooms();
            request.setAttribute("rooms", rooms);

            request.getRequestDispatcher("/jsp/viewRooms.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}