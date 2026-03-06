<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oceanview.model.Room" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Rooms - Ocean View Resort</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #0077b6, #00b4d8);
            color: #333;
        }

        .navbar {
            background-color: #023e8a;
            color: white;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar h2 {
            margin: 0;
        }

        .logout-btn {
            background: #e63946;
            color: white;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 5px;
        }

        .logout-btn:hover {
            background: #b5172e;
        }

        .container {
            padding: 40px;
            max-width: 900px;
            margin: auto;
            background: white;
            border-radius: 10px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.3);
        }

        h2 {
            text-align: center;
            color: #0077b6;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #0077b6;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #d9e9f7;
        }

        .delete-btn {
            background: #e63946;
            color: white;
            padding: 6px 12px;
            text-decoration: none;
            border-radius: 5px;
        }

        .delete-btn:hover {
            background: #b5172e;
        }

    </style>
</head>
<body>

<div class="navbar">
    <h2>Ocean View Resort - Rooms</h2>
    <%@ page session="true" %>
    <%
        if(session.getAttribute("user") == null){
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            return;
        }
    %>

    <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Logout</a>
</div>

<div class="container">
    <h2>All Rooms</h2>

    <%
        List<Room> rooms = (List<Room>) request.getAttribute("rooms");

        if (rooms != null && !rooms.isEmpty()) {
    %>
    <table>
        <tr>
            <th>Room ID</th>
            <th>Room Type</th>
            <th>Price per Night</th>
            <%-- Show delete column only for admin --%>
            <%
                String role = (String) session.getAttribute("role");
                if ("admin".equalsIgnoreCase(role)) {
            %>
            <th>Action</th>
            <% } %>
        </tr>

        <%
            for (Room r : rooms) {
        %>
        <tr>
            <td><%= r.getRoomId() %></td>
            <td><%= r.getRoomType() %></td>
            <td>$<%= r.getPricePerNight() %></td>

            <% if ("admin".equalsIgnoreCase(role)) { %>
            <td>
                <a href="<%= request.getContextPath() %>/deleteRoom?roomId=<%= r.getRoomId() %>"
                   class="delete-btn"
                   onclick="return confirm('Are you sure you want to delete this room?');">
                    Delete
                </a>
            </td>
            <% } %>
        </tr>
        <%
            }
        %>
    </table>
    <%
    } else {
    %>
    <p style="text-align:center; color:#0077b6; font-size:18px;">No rooms found.</p>
    <% } %>

</div>

</body>
</html>