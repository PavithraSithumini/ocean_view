<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Reservation - Ocean View Resort</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #0077b6, #00b4d8);
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

        .back-btn {
            background: #e63946;
            color: white;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 5px;
        }

        .back-btn:hover {
            background: #b5172e;
        }

        .container {
            width: 450px;
            margin: 50px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.3);
        }

        h2 {
            text-align: center;
            color: #0077b6;
            margin-bottom: 20px;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin: 8px 0 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            background: #0077b6;
            color: white;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background: #023e8a;
        }

        .message {
            text-align: center;
            color: green;
            font-weight: bold;
        }

    </style>
</head>
<body>

<div class="navbar">
    <h2>Ocean View Resort - Add Reservation</h2>
    <a href="adminDashboard.jsp" class="back-btn">Back</a>
</div>

<div class="container">

    <h2>New Reservation</h2>

    <% if(request.getAttribute("success") != null) { %>
    <div class="message">
        <%= request.getAttribute("success") %>
    </div>
    <% } %>

    <form action="${pageContext.request.contextPath}/addReservation" method="post">

        <label>Guest Name</label>
        <input type="text" name="guestName" required>

        <label>Address</label>
        <input type="text" name="address" required>

        <label>Contact Number</label>
        <input type="text" name="contactNumber" required pattern="[0-9]{10}" title="Enter 10 digit number">

        <label>Room Type</label>
        <select name="roomType" required>
            <option value="">Select Room Type</option>
            <option value="Single">Single - $50 per night</option>
            <option value="Double">Double - $80 per night</option>
            <option value="Suite">Suite - $120 per night</option>
        </select>

        <label>Check-In Date</label>
        <input type="date" name="checkIn" required>

        <label>Check-Out Date</label>
        <input type="date" name="checkOut" required>

        <input type="submit" value="Add Reservation">

    </form>

</div>

</body>
</html>
