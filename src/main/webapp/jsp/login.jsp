<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ocean View Resort - Login</title>

  <style>
    body{
      font-family: Arial, sans-serif;
      background: linear-gradient(to right, #0077b6, #00b4d8);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .login-box{
      background: white;
      padding: 40px 30px;
      border-radius: 15px;
      width: 400px;
      box-shadow: 0 8px 25px rgba(0,0,0,0.3);
      text-align: center;
    }

    .login-box h1{
      margin: 0 0 10px 0;
      font-size: 28px;
      color: #023e8a;
      text-shadow: 1px 1px 2px rgba(0,0,0,0.2);
    }

    .login-box p{
      font-size: 16px;
      color: #0077b6;
      margin-bottom: 25px;
    }

    input[type=text], input[type=password]{
      width: 100%;
      padding: 12px;
      margin: 8px 0;
      border-radius: 6px;
      border: 1px solid #ccc;
      font-size: 14px;
    }

    input[type=submit]{
      width: 100%;
      padding: 12px;
      background: #0077b6;
      color: white;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      font-size: 16px;
      transition: 0.3s;
    }

    input[type=submit]:hover{
      background: #023e8a;
    }

    /* ERROR MESSAGE */
    .error{
      background: #ffdddd;
      color: #d8000c;
      padding: 10px;
      border-radius: 5px;
      margin-bottom: 10px;
      text-align: center;
      font-weight: bold;
    }

    /* Footer / small welcome text */
    .login-footer {
      margin-top: 20px;
      font-size: 14px;
      color: #555;
    }

  </style>
</head>

<body>

<div class="login-box">

  <h1>🌊 Ocean View Resort 🌊</h1>
  <p>Welcome! Please login to continue</p>

  <%
    String error = (String)request.getAttribute("error");
    if(error != null){
  %>
  <div class="error">
    <%=error%>
  </div>
  <%
    }
  %>

  <form action="<%=request.getContextPath()%>/login" method="post">
    <input type="text" name="username" placeholder="Enter Username" required>
    <input type="password" name="password" placeholder="Enter Password" required>
    <input type="submit" value="Login">
  </form>

  <div class="login-footer">
    © 2026 Ocean View Resort. All rights reserved.
  </div>

</div>

</body>
</html>