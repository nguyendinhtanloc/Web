<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cart" value="${sessionScope.cart}" />

<h1>Your Cart</h1>

<c:if test="${empty cart.items}">
    <p>Your cart is empty.</p>
</c:if>

<c:if test="${not empty cart.items}">
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th></th>
        </tr>
        <c:forEach var="item" items="${cart.items}">
            <tr>
                <td>${item.product.description}</td>
                <td>${item.product.priceCurrencyFormat}</td>
                <td>${item.quantity}</td>
                <td>${item.totalCurrencyFormat}</td>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="productCode" value="${item.product.code}">
                        <input type="hidden" name="quantity" value="0">
                        <input type="submit" name="action" value="cart">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="products">Continue Shopping</a></p>
    <form action="cart" method="post">
        <input type="hidden" name="action" value="checkout">
        <input type="submit" value="Checkout">
    </form>
</c:if>
