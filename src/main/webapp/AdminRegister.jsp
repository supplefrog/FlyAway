<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 250px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        button[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        p {
            margin-top: 20px;
        }
        footer {
            margin-top: 40px;
            color: #888;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Admin Registration</h1>
    
    <form method="POST" action="AdminRegister">
        <label for="adminName">Admin Name:</label>
        <input type="text" id="adminName" name="adminName" required><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <button type="submit">Register</button>
    </form>
    
    <p>Already have an account? <a href="admin-login.jsp">Login here</a></p>
    
    <footer>
        &copy; 2023 My Web Application. All rights reserved.
    </footer>
</body>
</html>
