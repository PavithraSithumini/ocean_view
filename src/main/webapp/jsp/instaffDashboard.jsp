<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ocean View Resort - Staff Dashboard</title>

  <%
    // Redirect to login if session is not set
    if (session.getAttribute("user") == null) {
      response.sendRedirect(request.getContextPath() + "/login.jsp");
      return;
    }
  %>

  <style>
    /* General Body Styles */
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background: linear-gradient(to right, #0077b6, #00b4d8);
    }

    /* Navbar Styles */
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

    /* Main Container */
    .container {
      padding: 40px;
      text-align: center;
    }
    .welcome {
      font-size: 22px;
      color: white;
      margin-bottom: 30px;
    }

    /* Card Container */
    .card-container {
      display: flex;
      justify-content: center;
      flex-wrap: wrap;
      gap: 30px;
    }

    /* Individual Card Styles */
    .card {
      background: white;
      width: 220px;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 5px 15px rgba(0,0,0,0.2);
      transition: 0.3s;
      cursor: pointer;
    }
    .card:hover {
      transform: translateY(-10px);
    }
    .card h3 {
      margin-bottom: 15px;
      color: #0077b6;
    }
    .card a {
      text-decoration: none;
      color: white;
      background: #0077b6;
      padding: 8px 15px;
      border-radius: 5px;
      display: inline-block;
    }
    .card a:hover {
      background: #023e8a;
    }
  </style>
</head>
<body>

<!-- Navbar -->
<div class="navbar">
  <h2>Ocean View Resort - Staff Panel</h2>
  <%@ page session="true" %>
  <%
    if(session.getAttribute("user") == null){
      response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
      return;
    }
  %>


  <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Logout</a>
</div>

<!-- Main Container -->
<div class="container">
  <div class="welcome">
    Welcome Staff: <b><%= session.getAttribute("user") %></b>
  </div>

  <!-- Dashboard Cards -->
  <div class="card-container">

    <div class="card">
      <h3>Add Reservation</h3>
      <a href="<%= request.getContextPath() %>/jsp/addReservation.jsp">Open</a>
    </div>

    <div class="card">
      <h3>View Reservations</h3>
      <a href="<%= request.getContextPath() %>/viewReservations">Open</a>

    </div>

    <div class="card">
      <h3>View Rooms</h3>
      <a href="<%= request.getContextPath() %>/viewRooms">Open</a>
    </div>

    <div class="card">
      <h3>Calculate Bill</h3>
      <a href="<%= request.getContextPath() %>/jsp/billForm.jsp">Open</a>
    </div>

    <div class="card">
      <h3>Help</h3>
      <a href="<%= request.getContextPath() %>/jsp/help.jsp">Open</a>
    </div>

  </div>
</div>

</body>
</html>