<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.oceanview.model.Reservation" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Reservations</title>

    <style>
        table{
            border-collapse:collapse;
            width:100%;
        }

        th,td{
            border:1px solid #ccc;
            padding:8px;
            text-align:left;
        }

        th{
            background-color:#0077b6;
            color:white;
        }

        tr:nth-child(even){
            background-color:#f2f2f2;
        }
    </style>

</head>
<body>

<h2>All Reservations</h2>

<%

    List<Reservation> reservations =
            (List<Reservation>) request.getAttribute("reservations");

    if(reservations != null){
%>

<table>

    <tr>
        <th>ID</th>
        <th>Guest Name</th>
        <th>Room Type</th>
        <th>Total Amount</th>
    </tr>

    <%
        for(Reservation r : reservations){
    %>

    <tr>
        <td><%= r.getReservationId() %></td>
        <td><%= r.getGuestName() %></td>
        <td><%= r.getRoomType() %></td>
        <td><%= r.getTotalAmount() %></td>
    </tr>

    <%
        }
    %>

</table>

<%
}else{
%>

<p>No reservations found.</p>

<%
    }
%>

</body>
</html>