<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach Music Store</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<header>
    <div class="container">
        <h1>Murach Music Store</h1>
        <c:if test="${cookie.firstNameCookie.value != null}">
            <p>Welcome back, <c:out value='${cookie.firstNameCookie.value}'/></p>
        </c:if>
    </div>
</header>
<div class="container">
