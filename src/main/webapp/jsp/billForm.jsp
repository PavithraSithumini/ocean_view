<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Generate Bill - Ocean View Resort</title>

    <style>

        body{
            margin:0;
            font-family:Arial, Helvetica, sans-serif;
            background:linear-gradient(to right,#0077b6,#00b4d8);
        }

        /* NAVBAR */

        .navbar{
            background:#023e8a;
            color:white;
            padding:15px 30px;
            display:flex;
            justify-content:space-between;
            align-items:center;
        }

        .navbar h2{
            margin:0;
        }

        .back-btn{
            background:#e63946;
            color:white;
            padding:8px 15px;
            text-decoration:none;
            border-radius:5px;
        }

        .back-btn:hover{
            background:#b5172e;
        }

        /* FORM CONTAINER */

        .container{
            width:420px;
            margin:60px auto;
            background:white;
            padding:35px;
            border-radius:12px;
            box-shadow:0 5px 20px rgba(0,0,0,0.3);
        }

        .container h2{
            text-align:center;
            color:#0077b6;
        }

        /* INPUTS */

        label{
            font-weight:bold;
        }

        input{
            width:100%;
            padding:10px;
            margin-top:5px;
            margin-bottom:18px;
            border-radius:6px;
            border:1px solid #ccc;
        }

        /* BUTTON */

        button{
            width:100%;
            padding:12px;
            border:none;
            background:#0077b6;
            color:white;
            font-size:16px;
            border-radius:6px;
            cursor:pointer;
        }

        button:hover{
            background:#023e8a;
        }

    </style>

</head>

<body>

<div class="navbar">
    <h2>Ocean View Resort - Generate Bill</h2>
    <a href="adminDashboard.jsp" class="back-btn">Back</a>
</div>

<div class="container">

    <h2>Bill Calculation</h2>


    <form action="<%= request.getContextPath() %>/calculateBill" method="post">


        <label>Reservation ID</label>
        <input type="number" name="reservationId" required>

        <label>Nights</label>
        <input type="number" name="nights" required>

        <label>Room Price</label>
        <input type="number" name="roomPrice" step="0.01" required>

        <button type="submit">Generate Bill</button>
        <a href="<%= request.getContextPath() %>/bill">Generate Bill</a>


    </form>

</div>

</body>
</html>