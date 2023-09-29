<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fly Away - A Flight Booking Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            color: #333333;
            text-align: center;
            margin-top: 40px;
        }

        nav {
            background-color: #f7f7f7;
            padding: 10px;
            margin-top: 40px;
        }

        ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        li {
            margin: 0 10px;
        }

        li a {
            color: #333333;
            text-decoration: none;
            padding: 10px;
            transition: color 0.3s ease;
        }

        li a:hover {
            color: #4caf50;
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
        <h1>Fly Away - A Flight Booking Portal</h1>
        
        <nav>
            <ul>
                <li><a href="flights.jsp">View Flights</a></li>
                <li><a href="bookings.jsp">View Bookings</a></li>
                <li><a href="admin-login">Admin Login</a></li>
                <li><a href="register.jsp">User Register</a></li>
                <li><a href="user-login.jsp">User Login</a></li>
                <li><a href="AdminRegister.jsp">Admin Register</a></li>
            </ul>
        </nav>
        
        <footer>
            &copy; 2023 Fly Away - An Air Booking Portal. All rights reserved. | Developed by Akshat Das
        </footer>
    </div>
</body>
</html>
