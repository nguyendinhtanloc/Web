<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Cookies</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<h1>Cookies in your browser</h1>
<table border="1">
    <tr><th>Name</th><th>Value</th></tr>
    <%
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (javax.servlet.http.Cookie c : cookies) {
    %>
    <tr>
        <td><%= c.getName() %></td>
        <td><%= c.getValue() %></td>
    </tr>
    <%      }
        }
    %>
</table>

<p><a href="?action=deleteCookies">Delete Cookies</a></p>
<p><a href="?action=viewAlbums">Back to Albums</a></p>
</body>
</html>
