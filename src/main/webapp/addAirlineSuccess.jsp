<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Airline Success</title>
</head>
<body>
    <h1>Airline Added Successfully!</h1>
    <p>The airline has been successfully added to the database.</p>
    <p>Airline Details:</p>
    <table>
        <tr>
            <td>Airline Name:</td>
            <td>${airline.airlineName}</td>
        </tr>
        <tr>
            <td>Airline Headquarters:</td>
            <td>${airline.airlineHeadquarters}</td>
        </tr>
        <tr>
            <td>Websites:</td>
            <td>${airline.websites}</td>
        </tr>
        <tr>
            <td>Code:</td>
            <td>${airline.code}</td>
        </tr>
        <tr>
            <td>Country:</td>
            <td>${airline.country}</td>
        </tr>
    </table>
</body>
</html>
