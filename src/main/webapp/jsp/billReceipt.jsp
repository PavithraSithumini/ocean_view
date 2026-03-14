<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.oceanview.model.Bill" %>
<%
    Bill bill = (Bill) request.getAttribute("bill");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Receipt - Ocean View Resort</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f9;
            margin: 0;
        }

        .navbar {
            background-color: #023e8a;
            color: white;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
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
            width: 500px;
            margin: 50px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            color: #023e8a;
        }

        .row {
            display: flex;
            justify-content: space-between;
            margin: 8px 0;
        }

        .total {
            font-size: 20px;
            font-weight: bold;
            color: #0077b6;
            margin-top: 15px;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #0077b6;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
            font-size: 16px;
        }

        button:hover {
            background: #023e8a;
        }

    </style>
    <script>
        function printReceipt() {
            window.print();
        }
    </script>
</head>
<body>

<div class="navbar">
    <span>Welcome, <b><%= session.getAttribute("user") %></b></span>
    <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Logout</a>
</div>

<div class="container">
    <h2>Ocean View Resort - Bill Receipt</h2>
    <hr>

    <div class="row">
        <span>Reservation ID:</span>
        <span><%= bill.getReservationId() %></span>
    </div>

    <div class="row">
        <span>Guest Name:</span>
        <span><%= bill.getGuestName() %></span>
    </div>

    <div class="row">
        <span>Room Type:</span>
        <span><%= bill.getRoomType() %></span>
    </div>

    <div class="row">
        <span>Price per Night:</span>
        <span>$<%= bill.getPricePerNight() %></span>
    </div>

    <div class="row">
        <span>Nights:</span>
        <span><%= bill.getNights() %></span>
    </div>

    <hr>

    <div class="row total">
        <span>Total Amount:</span>
        <span>$<%= bill.getTotal() %></span>
    </div>

    <% if(bill == null){ %>
    <div style="text-align:center; color:red; margin-top:30px;">
        <h3>Error: Could not generate bill. Please go back and try again.</h3>
        <a href="javascript:history.back()">← Go Back</a>
    </div>
    <% } else { %>
    <%-- ... all your existing receipt rows ... --%>
    <% } %>

    <button onclick="printReceipt()">Print Receipt</button>
</div>

</body>
</html>