<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        p {
            margin-bottom: 10px;
        }
        h3 {
            margin-top: 30px;
            margin-bottom: 10px;
        }
        a {
            display: block;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <h2>Welcome, ${admin.adminName}!</h2>
    <p>Admin ID: ${admin.adminId}</p>
    <p>Email: ${admin.email}</p>
   
    <h3>Add Airline</h3>
    <a href="addAirline.jsp">Go to Add Airline Page</a>
    <a href="addflight.jsp">Go to Add Flight Page</a>
    <a href="addPlace.jsp">Go to Add Place Page</a>
    
    <a href="logout">Logout</a>
</body>
</html>
