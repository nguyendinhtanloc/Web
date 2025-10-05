<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<div class="container">
    <h2>Register for Email List</h2>
    <form action="register_user" method="post">
        <label>Email:</label><br>
        <input type="text" name="email" required><br><br>
        <label>First name:</label><br>
        <input type="text" name="firstName" required><br><br>
        <label>Last name:</label><br>
        <input type="text" name="lastName" required><br><br>
        <input type="submit" value="Register">
    </form>
    <p><a href="index.jsp">Back to home</a></p>
</div>
</body>
</html>
