package com.oceanview.controller;

import com.oceanview.dao.RoomDAO;
import com.oceanview.model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/billForm")
public class BillFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            RoomDAO dao = new RoomDAO();

            List<Room> rooms = dao.getAllRooms();

            request.setAttribute("roomList", rooms);

            RequestDispatcher rd = request.getRequestDispatcher("/jsp/billForm.jsp");
            rd.forward(request,response);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}