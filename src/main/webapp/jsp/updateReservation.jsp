<%@ page session="true" %>
<%@ page import="com.oceanview.model.Reservation" %>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }

    Reservation r = (Reservation) request.getAttribute("reservation");
    if (r == null) {
        response.sendRedirect(request.getContextPath() + "/viewReservations");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Reservation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right,#0077b6,#00b4d8);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-box {
            background: white;
            padding: 30px;
            border-radius: 10px;
            width: 400px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.3);
        }
        h2 { text-align: center; color: #0077b6; }
        input[type=text], input[type=number], input[type=date] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type=submit] {
            width: 100%;
            padding: 10px;
            background: #0077b6;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type=submit]:hover { background: #023e8a; }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Update Reservation</h2>
    <form action="<%= request.getContextPath() %>/updateReservation" method="post">
        <input type="hidden" name="id" value="<%= r.getReservationId() %>">

        <label>Guest Name</label>
        <input type="text" name="guestName" value="<%= r.getGuestName() %>" required>

        <label>Address</label>
        <input type="text" name="address" value="<%= r.getAddress() %>" required>

        <label>Contact Number</label>
        <input type="text" name="contact" value="<%= r.getContactNumber() %>" required>

        <label>Room Type</label>
        <input type="text" name="roomType" value="<%= r.getRoomType() %>" required>

        <label>Check-in Date</label>
        <input type="date" name="checkIn" value="<%= r.getCheckIn() %>" required>

        <label>Check-out Date</label>
        <input type="date" name="checkOut" value="<%= r.getCheckOut() %>" required>

        <label>Total Amount</label>
        <input type="number" step="0.01" name="total" value="<%= r.getTotalAmount() %>" required>

        <input type="submit" value="Update Reservation">
    </form>
</div>

</body>
</html>