<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.FlyAway.models.FlightModel" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Flights</title>
</head>
<body>
    <h1>View Flights</h1>

    <table>
        <tr>
            <th>Flight Number</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Airline</th>
        </tr>
        <%-- Retrieve the flights attribute and cast it to List<FlightModel> --%>
        <% List<FlightModel> flights = (List<FlightModel>) request.getAttribute("flights");
        if (flights != null) {
            for (FlightModel flight : flights) { %>
                <tr>
                    <td><%= flight.getFlightNumber() %></td>
                    <td><%= flight.getSource() %></td>
                    <td><%= flight.getDestination() %></td>
                    <td><%= flight.getAirline().getAirlineName() %></td>
                </tr>
            <% }
        } %>
    </table>

    <a href="index.jsp">Go Back</a>
</body>
</html>
