<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to the Home Page</title>
    <style>
        body {
            background-color: #f7f7f7;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h2 {
            color: #333333;
            text-align: center;
        }

        p {
            color: #666666;
            text-align: center;
            margin-top: 20px;
        }

        h3 {
            color: #333333;
            margin-top: 40px;
        }

        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .button-container a {
            display: inline-block;
            background-color: #4caf50;
            color: #ffffff;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .button-container a:hover {
            background-color: #45a049;
        }

        .logout-container {
            display: flex;
            justify-content: center;
            margin-top: 40px;
        }

        .logout-container input[type="submit"] {
            background-color: #f44336;
            color: #ffffff;
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .logout-container input[type="submit"]:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to the Home Page</h2>
        <p>Hello, <strong>${user.userName}</strong>! You have successfully logged in.</p>
        <h3>Add Booking</h3>
        <div class="button-container">
            <a href="addBooking.jsp">Go to Add Booking Page</a>
        </div>
        <div class="logout-container">
            <form action="logout" method="post">
                <input type="submit" value="Logout">
            </form>
        </div>
    </div>
</body>
</html>
