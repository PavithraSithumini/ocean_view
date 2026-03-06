<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oceanview.model.Reservation" %>
<%
    // Check session
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }

    List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Reservations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin:0;
            padding:0;
        }

        .navbar{
            display:flex;
            justify-content:space-between;
            align-items:center;
            padding:15px 40px;
            background:#0077b6;
            color:white;
        }

        .navbar a{
            color:white;
            text-decoration:none;
            font-weight:bold;
            margin-left:20px;
        }

        .logout-btn{
            background:#e63946;
            padding:8px 14px;
            border-radius:5px;
            color:white;
        }

        h2{
            text-align:center;
            color:#0077b6;
            margin-top:30px;
        }

        table{
            width:90%;
            margin:30px auto;
            border-collapse:collapse;
            background:white;
            box-shadow:0 5px 15px rgba(0,0,0,0.1);
        }

        th, td{
            border:1px solid #ccc;
            padding:10px;
            text-align:center;
        }

        th{
            background:#0077b6;
            color:white;
        }

        tr:nth-child(even){
            background:#e6f0fa;
        }

        .action-btn{
            padding:5px 10px;
            border:none;
            border-radius:4px;
            color:white;
            cursor:pointer;
            margin:2px;
        }

        .update-btn{
            background:#0077b6;
        }

        .update-btn:hover{
            background:#005f8a;
        }

        .delete-btn{
            background:#e63946;
        }

        .delete-btn:hover{
            background:#b5172e;
        }

    </style>
</head>
<body>

<div class="navbar">
    <div>Ocean View Resort - Reservations</div>
    <div>
        <a href="<%=request.getContextPath()%>/jsp/instaffDashboard.jsp">Dashboard</a>
        <a href="<%=request.getContextPath()%>/logout" class="logout-btn">Logout</a>
    </div>
</div>

<h2>Reservations List</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Guest Name</th>
        <th>Address</th>
        <th>Contact</th>
        <th>Room Type</th>
        <th>Check-in</th>
        <th>Check-out</th>
        <th>Total</th>
        <th>Actions</th>
    </tr>
    <%
        if(reservations != null && !reservations.isEmpty()){
            for(Reservation r : reservations){
    %>
    <tr>
        <td><%= r.getReservationId() %></td>
        <td><%= r.getGuestName() %></td>
        <td><%= r.getAddress() %></td>
        <td><%= r.getContactNumber() %></td>
        <td><%= r.getRoomType() %></td>
        <td><%= r.getCheckIn() %></td>
        <td><%= r.getCheckOut() %></td>
        <td>$<%= r.getTotalAmount() %></td>
        <td>
            <!-- Update Button -->
            <form action="<%=request.getContextPath()%>/updateReservation" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%=r.getReservationId()%>">
                <button type="submit" class="action-btn update-btn">Update</button>
            </form>

            <!-- Delete Button -->
            <form action="<%=request.getContextPath()%>/deleteReservation" method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this reservation?');">
                <input type="hidden" name="id" value="<%=r.getReservationId()%>">
                <button type="submit" class="action-btn delete-btn">Delete</button>
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="9" style="color:red;">No reservations found.</td>
    </tr>
    <% } %>
</table>

</body>
</html>