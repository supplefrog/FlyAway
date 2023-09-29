<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Flight</title>
</head>
<body>
    <h1>Add Flight</h1>
   <form method="post" action="addflight?action=create">

        <label for="flightNumber">Flight Number:</label>
        <input type="text" id="flightNumber" name="flightNumber" required><br>
        
        <label for="source">Source:</label>
        <input type="text" id="source" name="source" required><br>
        
        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" required><br>
        
        <label for="airlineName">Airline:</label>
        <input type="text" id="airlineName" name="airlineName" required><br>
        
        <input type="submit" value="Add Flight">
    </form>
</body>
</html>
