<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*,com.oceanview.model.Room" %>
<%@ page import="com.oceanview.service.RoomService" %>

<%
    List<Room> roomList = (List<Room>) request.getAttribute("roomList");
%>

<!DOCTYPE html>
<html>
<head>

    <title>Generate Bill</title>

    <style>

        body{
            font-family: Arial;
            background: linear-gradient(to right,#0077b6,#00b4d8);
        }

        .container{
            width:420px;
            margin:80px auto;
            background:white;
            padding:30px;
            border-radius:10px;
            box-shadow:0 0 15px rgba(0,0,0,0.2);
        }

        h2{
            text-align:center;
            color:#023e8a;
        }

        input,select{
            width:100%;
            padding:10px;
            margin:10px 0;
            border:1px solid #ccc;
            border-radius:5px;
        }

        button{
            width:100%;
            padding:12px;
            background:#0077b6;
            color:white;
            border:none;
            border-radius:5px;
            font-size:16px;
            cursor:pointer;
        }

        button:hover{
            background:#023e8a;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Generate Bill</h2>

    <form action="<%=request.getContextPath()%>/calculateBill" method="post">

        <label>Reservation ID</label>
        <input type="number" name="reservationId" required>

        <label>Select Room</label>
        <select name="roomPrice" required>

                <option value="">-- Select Room --</option>
                <%
                    try {
                        RoomService roomService = new RoomService();
                        List<Room> rooms = roomService.getAllRooms();
                        for(Room r : rooms){
                %>
                <option value="<%= r.getRoomType() %>"><%= r.getRoomType() %> ($<%= r.getPricePerNight() %>)</option>
                <%
                        }
                    } catch(Exception e){

                    }
                %>
            </select>






        <label>Nights</label>
        <input type="number" name="nights" required>

        <button type="submit">Generate Bill</button>

    </form>

</div>

</body>
</html>