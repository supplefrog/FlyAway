<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Payment</title>
</head>
<body>
    <h1>Add Payment</h1>
    <form action="addPayment" method="post">
        <label for="bookingId">Booking ID:</label>
        <input type="number" id="bookingId" name="bookingId" required><br><br>
        
        <label for="paymentAmount">Payment Amount:</label>
        <input type="number" id="paymentAmount" name="paymentAmount" required><br><br>
        
        <label for="paymentDate">Payment Date:</label>
        <input type="date" id="paymentDate" name="paymentDate" required><br><br>
        
        <label for="paymentMethod">Payment Method:</label>
        <input type="text" id="paymentMethod" name="paymentMethod" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
