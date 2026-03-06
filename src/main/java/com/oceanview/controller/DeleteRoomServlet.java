package com.oceanview.controller;

import com.oceanview.dao.RoomDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/deleteRoom")
public class DeleteRoomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomIdStr = request.getParameter("roomId");
        if(roomIdStr != null && !roomIdStr.isEmpty()) {
            int roomId = Integer.parseInt(roomIdStr);
            try {
                new RoomDAO().deleteRoom(roomId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/viewRooms");
    }
}