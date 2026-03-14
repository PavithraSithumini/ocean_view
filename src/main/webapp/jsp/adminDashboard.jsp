<%@ page session="true" %>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>

    <title>Ocean View Resort Dashboard</title>

    <style>

        body{
            margin:0;
            font-family:Arial;

            background:linear-gradient(to right,#0077b6,#00b4d8);
        }

        /* welcome section */

        .hero{

            text-align:center;
            color:white;

            padding:100px 20px;
        }

        .hero h1{
            font-size:45px;
        }

        .hero p{
            font-size:18px;
            margin-top:10px;
        }

        /* info boxes */

        .info-section{

            display:flex;
            justify-content:center;
            gap:40px;

            margin-top:40px;
        }

        .box{

            background:white;
            padding:30px;
            width:220px;

            border-radius:12px;

            text-align:center;

            box-shadow:0 5px 20px rgba(0,0,0,0.2);

            transition:0.3s;
        }

        .box:hover{
            transform:translateY(-10px);
        }

        .box h3{
            color:#0077b6;
        }
        /* Info boxes (cards) */
        .info-boxes {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 30px;
        }

        .info-box {
            background-color: #fff;
            width: 220px;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .info-box:hover {
            transform: translateY(-8px);
            box-shadow: 0 12px 25px rgba(0,0,0,0.15);
        }

        .info-box h2 {
            font-size: 40px;
            color: #ff6f61;
            margin: 0;
        }

        .info-box p {
            font-size: 16px;
            color: #555;
            margin-top: 10px;
        }

        @media(max-width: 900px){
            .info-boxes {
                flex-direction: column;
                align-items: center;
            }
        }

    </style>

</head>

<body>

<!-- NAVBAR -->
<%@ include file="navbar.jsp" %>

<!-- WELCOME HERO -->
<div class="hero">
    <h1>Admin Dashboard - <%=session.getAttribute("user")%></h1>
    <p>You are logged in as <b><%=session.getAttribute("role")%></b></p>
    <p>Manage reservations, rooms and billing easily with the Ocean View Resort system.</p>
</div>


<!-- SMALL INFO SECTION -->

<div class="info-section">

    <div class="info-boxes">
        <div class="info-box">
            <h2>80</h2>
            <p>Total Rooms</p>
        </div>
        <div class="info-box">
            <h2>50</h2>
            <p>Available Rooms</p>
        </div>
        <div class="info-box">
            <h2>0</h2>
            <p>Today's Check-ins</p>
        </div>
        <div class="info-box">
            <h2>0</h2>
            <p>Today's Check-outs</p>
        </div>


    </div>

</div>


</body>
</html>