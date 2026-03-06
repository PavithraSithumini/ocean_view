<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.oceanview.model.Bill" %>

<%
    Bill bill = (Bill) request.getAttribute("bill");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Bill Receipt</title>

    <style>
        body{
            font-family:Arial;
            background:#f4f6f9;
        }

        .container{
            width:500px;
            margin:50px auto;
            background:white;
            padding:30px;
            border-radius:10px;
            box-shadow:0 0 10px rgba(0,0,0,0.2);
        }

        h2{
            text-align:center;
            color:#023e8a;
        }

        .row{
            display:flex;
            justify-content:space-between;
            margin:10px 0;
        }

        .total{
            font-size:20px;
            font-weight:bold;
            color:#0077b6;
        }

        button{
            width:100%;
            padding:10px;
            background:#0077b6;
            color:white;
            border:none;
            border-radius:5px;
            cursor:pointer;
        }

    </style>

    <script>
        function printReceipt(){
            window.print();
        }
    </script>

</head>

<body>

<div class="container">

    <h2>Ocean View Resort</h2>

    <%@ page session="true" %>
    <%
        if(session.getAttribute("user") == null){
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            return;
        }
    %>


    <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Logout</a>

    <hr>

    <div class="row">
        <span>Reservation ID</span>
        <span><%= bill.getReservationId() %></span>
    </div>

    <div class="row">
        <span>Nights</span>
        <span><%= bill.getNights() %></span>
    </div>



    <hr>

    <div class="row total">
        <span>Total</span>
        <span>$<%= bill.getTotal() %></span>
    </div>

    <button onclick="printReceipt()">Print Receipt</button>

</div>

</body>
</html>