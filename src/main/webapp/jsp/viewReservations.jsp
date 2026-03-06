<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oceanview.model.Reservation" %>

<%
    List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Reservations</title>
    <style>
        body { font-family: Arial; background: #f4f6f9; }
        table { width: 90%; margin: 30px auto; border-collapse: collapse; background: white; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        th { background: #0077b6; color: white; }
        tr:nth-child(even) { background: #e6f0fa; }
    </style>
</head>
<body>
<h2 style="text-align:center; color:#0077b6;">Reservations List</h2>
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
    </tr>
    <%      }
    } else { %>
    <tr><td colspan="8" style="color:red;">No reservations found.</td></tr>
    <% } %>
</table>
</body>
</html>