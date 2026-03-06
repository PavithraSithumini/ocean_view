<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Help - Ocean View Resort</title>
    <style>
        /* Body */
        body {
            margin: 0;
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #0077b6, #00b4d8);
            color: #333;
        }

        /* Navbar */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 30px;
            background-color: #023e8a;
            color: white;
        }
        .navbar h2 {
            margin: 0;
            font-size: 22px;
        }
        .logout-btn {
            background: #e63946;
            color: white;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }
        .logout-btn:hover {
            background: #b5172e;
        }

        /* Main container */
        .container {
            max-width: 900px;
            margin: 50px auto;
            background: white;
            padding: 40px 50px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.25);
        }

        h2.page-title {
            text-align: center;
            color: #0077b6;
            margin-bottom: 40px;
            font-size: 28px;
        }

        ul.help-list {
            list-style: none;
            padding: 0;
        }
        ul.help-list li {
            background: #f1f5f9;
            margin-bottom: 18px;
            padding: 18px 25px;
            border-left: 5px solid #0077b6;
            border-radius: 6px;
            font-size: 16px;
            transition: 0.3s;
        }
        ul.help-list li b {
            color: #023e8a;
        }
        ul.help-list li:hover {
            background: #e0f2fe;
        }

        /* Contact / Support section */
        .support {
            margin-top: 40px;
            padding: 25px;
            background: #f1f5f9;
            border-radius: 8px;
            border-left: 5px solid #023e8a;
        }
        .support h3 {
            margin-top: 0;
            color: #023e8a;
        }
        .support p {
            margin: 8px 0;
            font-size: 15px;
        }
        .support a {
            color: #0077b6;
            text-decoration: none;
        }
        .support a:hover {
            text-decoration: underline;
        }

        /* Responsive logout container */
        .logout-container {
            text-align: right;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="navbar">
    <h2>Ocean View Resort - Help</h2>
    <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Logout</a>
</div>

<div class="container">
    <h2 class="page-title">How to Use the Reservation System</h2>

    <ul class="help-list">
        <li><b>Login:</b> Use your staff credentials to access the system securely.</li>
        <li><b>Add Reservation:</b> Click "Add Reservation", fill in guest details, and submit.</li>
        <li><b>Calculate Bill:</b> Click "Calculate Bill", select Reservation ID, choose room type, enter nights, and generate receipt.</li>

    </ul>

    <div class="support">
        <h3>Need Assistance?</h3>
        <p>If you encounter any issues, please contact the system administrator:</p>
        <p><b>Email:</b> <a href="mailto:support@oceanview.com">support@oceanview.com</a></p>
        <p><b>Phone:</b> +94 123 456 789</p>
        <p><b>Office Hours:</b> Mon – Fri, 9:00 AM – 5:00 PM</p>
    </div>
</div>

</body>
</html>