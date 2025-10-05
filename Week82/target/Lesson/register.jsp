<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<h2>Register for Email List</h2>

<form action="download" method="post">
    <input type="hidden" name="action" value="registerUser">
    <label>Email:</label>
    <input type="text" name="email"><br>
    <label>First name:</label>
    <input type="text" name="firstName"><br>
    <label>Last name:</label>
    <input type="text" name="lastName"><br>
    <input type="submit" value="Register">
</form>


<p><a href="index.jsp">Back to home</a></p>
</body>
</html>
