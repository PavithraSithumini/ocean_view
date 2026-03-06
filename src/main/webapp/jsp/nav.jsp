<%
  String role = (String) session.getAttribute("role"); // assume you save "admin" or "staff"
%>

<div class="nav-links">
  <a href="<%=request.getContextPath()%>/dashboard">Dashboard</a>
  <a href="<%=request.getContextPath()%>/addReservation.jsp">Add Reservation</a>
  <a href="<%=request.getContextPath()%>/viewReservations">View Reservations</a>
  <a href="<%=request.getContextPath()%>/billForm">Billing</a>
  <a href="<%=request.getContextPath()%>/jsp/help.jsp">Help</a>

  <% if("admin".equals(role)) { %>
  <a href="<%=request.getContextPath()%>/addRoom">Add Room</a>
  <a href="<%=request.getContextPath()%>/viewRooms">View Rooms</a>
  <% } %>

  <a href="<%=request.getContextPath()%>/logout" class="logout-btn">Logout</a>
</div>