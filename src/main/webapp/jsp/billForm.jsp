<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.oceanview.model.Room" %>
<%@ page import="com.oceanview.service.RoomService" %>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }
    String errorMsg = (String) request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Generate Bill - Ocean View Resort</title>
    <style>
        body { font-family: Arial; background: linear-gradient(to right,#0077b6,#00b4d8); margin: 0; }
        .navbar { background-color: #023e8a; padding: 15px 30px; display: flex;
            justify-content: space-between; align-items: center; color: white; }
        .navbar .logout-btn { background: #e63946; color: white; padding: 8px 15px;
            text-decoration: none; border-radius: 5px; }
        .navbar .logout-btn:hover { background: #b5172e; }
        .container { width: 420px; margin: 50px auto; background: white;
            padding: 30px; border-radius: 10px; box-shadow: 0 0 15px rgba(0,0,0,0.2); }
        h2 { text-align:center; color:#023e8a; margin-bottom: 25px; }
        label { font-weight: bold; }
        input, select, button { width: 100%; padding: 10px; margin: 10px 0 15px 0;
            border:1px solid #ccc; border-radius:5px; font-size: 14px; box-sizing: border-box; }
        button { background: #0077b6; color: white; border: none; cursor: pointer; font-size: 16px; }
        button:hover { background: #023e8a; }
        .error { background:#ffe0e0; color:#c0392b; padding:10px; border-radius:5px;
            margin-bottom:15px; text-align:center; }
        .info-box { background:#e8f4fd; border:1px solid #0077b6; border-radius:6px;
            padding:10px 15px; margin-bottom:15px; font-size:14px; }
    </style>
</head>
<body>

<div class="navbar">
    <span>Welcome, <b><%= session.getAttribute("user") %></b></span>
    <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Logout</a>
</div>

<div class="container">
    <h2>Generate Bill</h2>

    <!-- ✅ Show error if reservation not found or other error -->
    <% if(errorMsg != null){ %>
    <div class="error"><%= errorMsg %></div>
    <% } %>

    <form action="<%=request.getContextPath()%>/calculateBill" method="post">

        <label>Reservation ID</label>
        <input type="number" name="reservationId" id="reservationId" required
               onblur="fetchReservation(this.value)">

        <!-- ✅ Shows guest name after ID lookup -->
        <div id="guestInfo" class="info-box" style="display:none;">
            <span id="guestNameDisplay"></span>
        </div>

        <label>Select Room</label>
        <select name="roomType" required>
            <option value="">-- Select Room --</option>
            <%
                try {
                    RoomService roomService = new RoomService();
                    List<Room> rooms = roomService.getAllRooms();
                    for(Room r : rooms){ %>
            <option value="<%= r.getRoomType() %>">
                <%= r.getRoomType() %> - $<%= r.getPricePerNight() %>/night
            </option>
            <%      }
            } catch(Exception e){
                e.printStackTrace(); %>
            <option disabled>Error loading rooms</option>
            <% } %>
        </select>

        <label>Number of Nights</label>
        <input type="number" name="nights" min="1" required>

        <button type="submit">Generate Bill</button>
    </form>
</div>

<script>
    // ✅ Fetch guest name when reservation ID is entered
    function fetchReservation(id) {
        if (!id) return;
        fetch('<%= request.getContextPath() %>/getReservation?id=' + id)
            .then(res => res.json())
            .then(data => {
                if (data.guestName) {
                    document.getElementById('guestNameDisplay').innerHTML =
                        '👤 Guest: <b>' + data.guestName + '</b>';
                    document.getElementById('guestInfo').style.display = 'block';
                } else {
                    document.getElementById('guestNameDisplay').innerHTML =
                        '⚠️ Reservation not found';
                    document.getElementById('guestInfo').style.display = 'block';
                }
            })
            .catch(() => {
                document.getElementById('guestInfo').style.display = 'none';
            });
    }
</script>

</body>
</html>