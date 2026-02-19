package com.oceanview.controller;

import com.oceanview.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // When user types /login in browser
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("jsp/login.jsp")
                .forward(request, response);
    }

    // When user clicks login button
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AuthService service = new AuthService();
        String role = service.login(username, password);

        if (role != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", role);

            if (role.equals("ADMIN")) {
                response.sendRedirect("jsp/adminDashboard.jsp");
            } else if (role.equals("STAFF")) {
                response.sendRedirect("jsp/staffDashboard.jsp");
            }

        } else {
            request.setAttribute("error", "Invalid Username or Password!");
            request.getRequestDispatcher("jsp/login.jsp")
                    .forward(request, response);
        }
    }
}
