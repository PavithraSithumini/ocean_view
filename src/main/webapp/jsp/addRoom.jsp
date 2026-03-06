<%@ page session="true" %>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }
%>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Room - Ocean View Resort</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #0077b6, #00b4d8);
            color: #333;
        }

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

        .container {
            width: 450px;
            margin: 50px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.3);
        }

        h2 {
            text-align: center;
            color: #0077b6;
            margin-bottom: 25px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #023e8a;
        }

        input[type="text"], input[type="number"] {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 16px;
        }

        input[type="submit"] {
            background: #0077b6;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }

        input[type="submit"]:hover {
            background: #023e8a;
        }

        .message {
            text-align: center;
            color: green;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .links {
            text-align: center;
            margin-top: 20px;
        }

        .links a {
            color: white;
            background: #0077b6;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 6px;
            transition: 0.3s;
        }

        .links a:hover {
            background: #023e8a;
        }
    </style>
</head>
<body>

<div class="navbar">
    <h2>Ocean View Resort - Add Room</h2>
    <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Logout</a>
</div>

<div class="container">

    <h2>New Room</h2>

    <% if(request.getParameter("success") != null){ %>
    <div class="message">
        <%= request.getParameter("success") %>
    </div>
    <% } %>

    <form action="<%=request.getContextPath()%>/addRoom" method="post">
        <label>Room Type:</label>
        <input type="text" name="roomType" placeholder="Enter Room Type" required>

        <label>Price Per Night ($):</label>
        <input type="number" name="pricePerNight" step="0.01" placeholder="Enter Price" required>

        <input type="submit" value="Add Room">
    </form>

    <div class="links">
        <a href="${pageContext.request.contextPath}/viewRooms">View Rooms</a>
    </div>

</div>

</body>
</html>