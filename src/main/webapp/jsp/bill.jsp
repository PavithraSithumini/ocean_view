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
        body{font-family:Arial; background:#f4f6f9;}
        .container{width:500px; margin:50px auto; background:white; padding:30px; border-radius:10px; box-shadow:0 0 10px rgba(0,0,0,0.1);}
        h2{text-align:center; color:#023e8a;}
        .row{display:flex; justify-content:space-between; margin:10px 0;}
        .total{font-weight:bold; font-size:20px; color:#0077b6;}
        .btn{margin-top:20px; width:100%; padding:10px; background:#0077b6; color:white; border:none; border-radius:5px; cursor:pointer;}
    </style>
    <script>function printBill(){window.print();}</script>
</head>
<body>
<div class="container">
    <h2>Ocean View Resort</h2>
    <hr>
    <% if(bill != null){ %>
    <div class="row"><span>Reservation ID</span><span><%=bill.getReservationId()%></span></div>
    <div class="row"><span>Nights</span><span><%=bill.getNights()%></span></div>
    <div class="row"><span>Room Price</span><span>$<%=bill.getRoomPrice()%></span></div>
    <div class="row"><span>Room Charge</span><span>$<%=bill.getRoomCharge()%></span></div>
    <div class="row"><span>Service Charge (10%)</span><span>$<%=bill.getServiceCharge()%></span></div>
    <div class="row"><span>Tax (5%)</span><span>$<%=bill.getTax()%></span></div>
    <hr>
    <div class="row total"><span>Total</span><span>$<%=bill.getTotal()%></span></div>
    <button class="btn" onclick="printBill()">Print Receipt</button>
    <% } else { %>
    <h3 style="color:red;text-align:center;">Bill not generated. Please calculate the bill first.</h3>
    <% } %>
</div>
</body>
</html>