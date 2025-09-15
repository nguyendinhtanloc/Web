<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Cookies</h1>
<table border="1">
    <tr><th>Name</th><th>Value</th></tr>
    <c:forEach var="c" items="${cookie}">
        <tr>
            <td><c:out value='${c.value.name}'/></td>
            <td><c:out value='${c.value.value}'/></td>
        </tr>
    </c:forEach>
</table>
