<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Place</title>
</head>
<body>
    <h1>Add Place</h1>
    <form action="addPlace" method="post">
        <input type="hidden" name="action" value="create">
        <label for="pinCode">Pin Code:</label>
        <input type="text" id="pinCode" name="pinCode" required><br><br>
        <label for="placeName">Place Name:</label>
        <input type="text" id="placeName" name="placeName" required><br><br>
        <label for="country">Country:</label>
        <input type="text" id="country" name="country" required><br><br>
        <input type="submit" value="Add Place">
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
