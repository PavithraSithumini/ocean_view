<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ocean View Resort - Login</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: linear-gradient(to right, #0077b6, #00b4d8);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .login-box {
      background: white;
      padding: 30px;
      border-radius: 10px;
      width: 350px;
      box-shadow: 0 5px 15px rgba(0,0,0,0.3);
    }

    h2 {
      text-align: center;
      color: #0077b6;
    }

    input[type=text], input[type=password] {
      width: 100%;
      padding: 10px;
      margin: 8px 0;
      border-radius: 5px;
      border: 1px solid #ccc;
    }

    input[type=submit] {
      width: 100%;
      padding: 10px;
      background: #0077b6;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    input[type=submit]:hover {
      background: #023e8a;
    }
  </style>
</head>
<body>

<div class="login-box">
  <h2>Ocean View Resort</h2>

  <form action="<%= request.getContextPath() %>/login" method="post">
    <input type="text" name="username" placeholder="Enter Username" required>
    <input type="password" name="password" placeholder="Enter Password" required>
    <input type="submit" value="Login">
  </form>

</div>

</body>
</html>
