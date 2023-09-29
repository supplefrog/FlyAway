<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            background-color: #f7f7f7;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h1 {
            color: #333333;
            text-align: center;
        }

        p {
            color: #ff5252;
            text-align: center;
            margin-top: 20px;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333333;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #cccccc;
            border-radius: 3px;
            margin-bottom: 10px;
            font-size: 14px;
        }

        input[type="submit"] {
            display: block;
            width: 100%;
            background-color: #4caf50;
            color: #ffffff;
            padding: 10px;
            border: none;
            border-radius: 3px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login</h1>

        <%-- Display error message if present --%>
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null && !error.isEmpty()) { %>
            <p><%= error %></p>
        <% } %>

        <form action="login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>
