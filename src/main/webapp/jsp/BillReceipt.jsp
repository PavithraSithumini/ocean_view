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
            font-family: Arial;
            background:#eef2f7;
        }

        .receipt-box{
            width:600px;
            margin:50px auto;
            background:white;
            padding:30px;
            border-radius:10px;
            box-shadow:0 0 15px rgba(0,0,0,0.15);
        }

        .header{
            text-align:center;
        }

        .header h2{
            margin:0;
            color:#023e8a;
        }

        .line{
            border-bottom:2px dashed #ccc;
            margin:15px 0;
        }

        .row{
            display:flex;
            justify-content:space-between;
            margin:10px 0;
            font-size:16px;
        }

        .total{
            font-weight:bold;
            font-size:20px;
            color:#0077b6;
        }

        .btn{
            margin-top:20px;
            padding:12px;
            width:100%;
            border:none;
            background:#0077b6;
            color:white;
            font-size:16px;
            border-radius:5px;
            cursor:pointer;
        }

        .btn:hover{
            background:#023e8a;
        }

        /* Print Style */

        @media print{
            .btn{
                display:none;
            }
        }

    </style>

    <script>
        function printReceipt(){
            window.print();
        }
    </script>

</head>

<body>

<div class="receipt-box">

    <div class="header">
        <h2>Ocean View Resort</h2>
        <p>Galle, Sri Lanka</p>
    </div>

    <div class="line"></div>

    <% if(bill != null){ %>

    <div class="row">
        <span>Reservation ID</span>
        <span><%= bill.getReservationId() %></span>
    </div>

    <div class="row">
        <span>Nights</span>
        <span><%= bill.getNights() %></span>
    </div>

    <div class="row">
        <span>Room Price</span>
        <span>$<%= bill.getRoomPrice() %></span>
    </div>

    <div class="line"></div>

    <div class="row total">
        <span>Total Amount</span>
        <span>$<%= bill.getTotal() %></span>
    </div>

    <button class="btn" onclick="printReceipt()">Print Receipt</button>

    <% } else { %>

    <h3 style="color:red;text-align:center;">No bill found.</h3>

    <% } %>

</div>

</body>
</html>