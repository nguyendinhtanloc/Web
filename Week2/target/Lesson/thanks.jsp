<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="murach.business.User" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css" />
</head>
<body>
    <div class="container">
        <h1>Thanks for joining our email list</h1>
        <p>Here is the information that you entered:</p>

        <%
            User user = (User) request.getAttribute("user");
            if (user != null) {
        %>
            <div class="user-details">
                <label>Email:</label>
                <span><%= user.getEmail() %></span><br>
                <label>First Name:</label>
                <span><%= user.getFirstName() %></span><br>
                <label>Last Name:</label>
                <span><%= user.getLastName() %></span><br>
                <label>Date of Birth:</label>
                <span><%= user.getDob() %></span><br>
            </div>
        <%
            } else {
        %>
            <p>No user data available.</p>
        <%
            }
        %>

        <p>To enter another email address, click on the Back button in your browser or the Return button below.</p>
        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return" id="submit">
        </form>
    </div>
</body>
</html>
