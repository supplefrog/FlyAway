<!DOCTYPE html>
<html>
<head>
    <title>Booking Success</title>
</head>
<body>
    <h1>Booking Successful!</h1>
    <p>Booking ID: <%= request.getAttribute("bookingId") %></p>
    <p>Booking Date: <%= request.getAttribute("bookingDate") %></p>
    <p>Passenger Count: <%= request.getAttribute("passengerCount") %></p>
    <p>Total Price: <%= request.getAttribute("totalPrice") %></p>
    <p>User: <%= request.getAttribute("userName") %></p>
    <p>Flights:</p>
    <ul>
        <% String[] flights = request.getParameterValues("flightNumber");
           if (flights != null) {
               for (String flight : flights) { %>
                   <li><%= flight %></li>
        <%     }
           } %>
    </ul>
    <p>Payments:</p>
    <ul>
        <% String[] payments = request.getParameterValues("paymentMethod");
           if (payments != null) {
               for (String payment : payments) { %>
                   <li><%= payment %></li>
        <%     }
           } %>
    </ul>
</body>
</html>
