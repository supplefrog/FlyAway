<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Airline</title>
</head>
<body>
    <h2>Add Airline</h2>
    <form action="addAirline" method="post">
        <label for="airlineName">Airline Name:</label>
        <input type="text" id="airlineName" name="airlineName" required><br><br>
        
        <label for="airlineHeadquarters">Airline Headquarters:</label>
        <input type="text" id="airlineHeadquarters" name="airlineHeadquarters" required><br><br>
        
        <label for="websites">Websites:</label>
        <input type="text" id="websites" name="websites" required><br><br>
        
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" required><br><br>
        
        <label for="country">Country:</label>
        <input type="text" id="country" name="country" required><br><br>
        
        <input type="submit" value="Add Airline">
    </form>
    
    <div style="color: red;">
        <%-- Display error message if any --%>
        <%= request.getAttribute("errorMessage") %>
    </div>
    
    <div style="color: green;">
        <%-- Display success message if any --%>
        <%= request.getAttribute("successMessage") %>
    </div>
</body>
</html>
