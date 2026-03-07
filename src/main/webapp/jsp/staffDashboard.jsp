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

    <title>Ocean View Resort - Staff Dashboard</title>

    <style>

        /* BODY */

        body{
            margin:0;
            font-family:Arial, sans-serif;
            background:linear-gradient(to right,#0077b6,#00b4d8);
        }


        /* NAVBAR */

        .navbar{
            display:flex;
            justify-content:space-between;
            align-items:center;
            padding:15px 40px;
            background:#023e8a;
            color:white;
        }

        .navbar .logo{
            display:flex;
            align-items:center;
            gap:10px;
        }

        .navbar img{
            height:40px;
        }

        .nav-links a{
            color:white;
            margin-left:20px;
            text-decoration:none;
            font-weight:bold;
        }

        .nav-links a:hover{
            color:#ffdd57;
        }

        .logout-btn{
            background:#e63946;
            padding:8px 14px;
            border-radius:5px;
        }


        /* HERO */

        .hero{
            text-align:center;
            color:white;
            padding:90px 20px 40px;
        }

        .hero h1{
            font-size:45px;
        }

        .hero p{
            font-size:18px;
            margin-top:10px;
        }


        /* ACTION SECTION */

        .action-section{
            display:flex;
            justify-content:center;
            flex-wrap:wrap;
            gap:30px;
            padding:40px;
        }


        /* ACTION BOX */

        .action-box{
            background:white;
            width:220px;
            padding:30px;
            border-radius:12px;
            text-align:center;
            box-shadow:0 5px 20px rgba(0,0,0,0.2);
            transition:0.3s;
        }

        .action-box:hover{
            transform:translateY(-10px);
        }

        .action-box h3{
            color:#0077b6;
            margin-bottom:15px;
        }

        .action-box a{
            text-decoration:none;
            color:white;
            background:#0077b6;
            padding:8px 15px;
            border-radius:5px;
        }

        .action-box a:hover{
            background:#023e8a;
        }

    </style>

</head>


<body>

<!-- NAVBAR -->

<div class="navbar">

    <div class="logo">

        <span>Ocean View Resort</span>
    </div>

    <div class="nav-links">

        <a href="<%=request.getContextPath()%>/jsp/instaffDashboard.jsp">Dashboard</a>

        <a href="<%=request.getContextPath()%>/jsp/addReservation.jsp">Add Reservation</a>


        <a href="<%=request.getContextPath()%>/viewRooms">Rooms</a>

        <a href="<%=request.getContextPath()%>/jsp/billForm.jsp">Billing</a>

        <a href="<%=request.getContextPath()%>/jsp/help.jsp">Help</a>

        <a href="<%=request.getContextPath()%>/logout" class="logout-btn">Logout</a>

    </div>

</div>


<!-- HERO -->

<div class="hero">

    <h1>Welcome <%=session.getAttribute("user")%> 👋</h1>

    <p>You are logged in as <b>Staff</b></p>

    <p>Manage reservations, rooms and billing easily with the Ocean View Resort system.</p>

</div>





</body>
</html>