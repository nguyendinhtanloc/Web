<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CD list</title>
    <style>
        table {
            border-collapse: collapse;
            width: 60%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        th {
            background: #f5f5f5;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>CD list</h1>
<table>
    <tr>
        <th>Description</th>
        <th>Price</th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.description}</td>
            <td>${product.priceCurrencyFormat}</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="productCode" value="${product.code}">
                    <input type="hidden" name="quantity" value="1">
                    <input type="submit" name="action" value="cart">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
