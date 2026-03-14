<%@ page session="true" %>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }
%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.oceanview.model.Room" %>
<%@ page import="com.oceanview.service.RoomService" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Reservation - Ocean View Resort</title>

    <style>
        /* Navbar */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 40px;
            background: linear-gradient(90deg, #023e8a, #0077b6, #00b4d8);
            color: white;
            font-family: Arial;
        }

        .navbar .logo {
            font-size: 22px;
            font-weight: bold;
        }

        .navbar .nav-links {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .navbar .nav-links a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            padding: 8px 15px;
            border-radius: 6px;
            transition: 0.3s;
        }

        .navbar .nav-links a:hover {
            background-color: #ffd60a;
            color: #023e8a;
        }

        .navbar .logout {
            background-color: #ff6b6b;
        }

        .navbar .logout:hover {
            background-color: #e63946;
        }

        /* Page Styles */
        body { font-family: Arial; background: linear-gradient(to right,#0077b6,#00b4d8); margin:0; }
        .container { width: 500px; margin: 50px auto; background: white; padding: 30px; border-radius: 12px; box-shadow: 0 5px 20px rgba(0,0,0,0.3);}
        h2 { text-align:center; color:#0077b6; margin-bottom: 25px; }
        label { font-weight:bold; }
        input, select { width:100%; padding:10px; margin-bottom:18px; border-radius:6px; border:1px solid #ccc; }
        button { width:100%; padding:12px; border:none; background:#0077b6; color:white; border-radius:6px; font-size:16px; cursor:pointer; }
        button:hover { background:#023e8a; }
        .success { color:green; text-align:center; margin-bottom:15px; }
    </style>
</head>
<body>

<!-- Navbar -->
<div class="navbar">
    <div class="logo">
        Ocean View Resort
    </div>
    <div class="nav-links">
        <a href="<%=request.getContextPath()%>/jsp/inadminDashboard.jsp">Dashboard</a>
        <a class="logout" href="<%=request.getContextPath()%>/logout">Logout</a>
    </div>
</div>

<!-- Add Reservation Form -->
<div class="container">
    <h2>Add Reservation</h2>

    <% if(request.getParameter("success") != null){ %>
    <p class="success"><%= request.getParameter("success") %></p>
    <% } %>

    <form action="<%=request.getContextPath()%>/AddReservationServlet" method="post">
        <label>Guest Name</label>
        <input type="text" name="guestName" required>

        <label>Address</label>
        <input type="text" name="address" required>

        <label>Contact Number</label>
        <input type="text" name="contactNumber" required>

        <label>Room Type</label>
        <select name="roomType" required>
            <option value="">-- Select Room --</option>
            <%
                try {
                    RoomService roomService = new RoomService();
                    List<Room> rooms = roomService.getAllRooms();
                    for(Room r : rooms){
            %>
            <option value="<%= r.getRoomType() %>"><%= r.getRoomType() %> ($<%= r.getPricePerNight() %>)</option>
            <%
                    }
            } catch(Exception e){ %>
            <option disabled>Error loading rooms</option>
            <% } %>
        </select>

        <label>Check-in Date</label>
        <input type="date" name="checkIn" required>

        <label>Check-out Date</label>
        <input type="date" name="checkOut" required>

        <button type="submit">Add Reservation</button>
    </form>
</div>

</body>
</html>