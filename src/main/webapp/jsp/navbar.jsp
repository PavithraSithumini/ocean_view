<%@ page session="true" %>
<%
  String user = (String) session.getAttribute("user");
  String role = (String) session.getAttribute("role");

  if(user == null){
    response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
    return;
  }
%>

<style>

  .navbar{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:15px 40px;

    background: linear-gradient(90deg,#023e8a,#0077b6,#00b4d8);

    color:white;
    font-family:Arial;
  }

  .logo{
    display:flex;
    align-items:center;
    gap:10px;
    font-size:20px;
    font-weight:bold;
  }

  .logo img{
    height:40px;
  }

  .nav-links a{
    color:white;
    margin-left:20px;
    text-decoration:none;
    font-weight:bold;
    transition:0.3s;
  }

  .nav-links a:hover{
    color:#ffd60a;
  }

  .logout{
    background:#ff6b6b;
    padding:8px 14px;
    border-radius:6px;
  }

  .logout:hover{
    background:#e63946;
  }

</style>

<div class="navbar">

  <div class="logo">
    
    Ocean View Resort
  </div>

  <div class="nav-links">

    <a href="<%=request.getContextPath()%>/jsp/inadminDashboard.jsp">Dashboard</a>

    <a href="<%=request.getContextPath()%>/jsp/addReservation.jsp">Add Reservation</a>

    <a href="<%=request.getContextPath()%>/viewReservations">Reservations</a>

    <a href="<%=request.getContextPath()%>/jsp/billForm.jsp">Billing</a>

    <% if("admin".equals(role)){ %>

    <a href="<%=request.getContextPath()%>/addRoom">Add Room</a>

    <a href="<%=request.getContextPath()%>/viewRooms">Rooms</a>

    <% } %>

    <a href="<%=request.getContextPath()%>/jsp/help.jsp">Help</a>

    <a class="logout" href="<%=request.getContextPath()%>/logout">Logout</a>

  </div>

</div>