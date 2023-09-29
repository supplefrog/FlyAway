<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h1 {
            color: #333333;
            text-align: center;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333333;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #cccccc;
            border-radius: 3px;
            margin-bottom: 10px;
            font-size: 14px;
        }

        button[type="submit"] {
            display: block;
            width: 100%;
            background-color: #4caf50;
            color: #ffffff;
            padding: 10px;
            border: none;
            border-radius: 3px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }

        p {
            text-align: center;
            margin-top: 20px;
        }

        footer {
            background-color: #f7f7f7;
            padding: 10px;
            text-align: center;
            margin-top: 40px;
            color: #666666;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Registration</h1>
        
        <form method="POST" action="register">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required><br>
            
            <button type="submit">Register</button>
        </form>
        
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
    
    <footer>
        &copy; 2023 My Web Application. All rights reserved. | Developer: [Akshat Das]
    </footer>
</body>
</html>
