<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Page</title>
</head>
<body>
    <h1>Booking Page</h1>
    <form action="addBooking" method="post">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required><br><br>

        <label for="bookingDate">Booking Date:</label>
        <input type="text" id="bookingDate" name="bookingDate" required><br><br>

        <label for="passengerCount">Passenger Count:</label>
        <input type="text" id="passengerCount" name="passengerCount" required><br><br>

        <label for="totalPrice">Total Price:</label>
        <input type="text" id="totalPrice" name="totalPrice" required><br><br>

        <label for="flightNumber">Flight Numbers (comma-separated):</label>
        <input type="text" id="flightNumber" name="flightNumber" required><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
