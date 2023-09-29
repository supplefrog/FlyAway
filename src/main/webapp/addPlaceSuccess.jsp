<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Place Success</title>
    <style>
        table {
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
        }
        th {
            background-color: lightgray;
        }
    </style>
</head>
<body>
    <h1>Place Added Successfully!</h1>
    <p>The place has been successfully added to the database.</p>
    <p>Place Details:</p>
    <table>
        <tr>
            <th>Pin Code</th>
            <th>Place Name</th>
            <th>Country</th>
        </tr>
        <tr>
            <td>${place.pinCode}</td>
            <td>${place.placeName}</td>
            <td>${place.country}</td>
        </tr>
    </table>
    <br>
    <a href="addPlace.jsp">Add Another Place</a>
    <br>
    <a href="admin-home.jsp">Go to Admin Homepage</a>
</body>
</html>
