<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>CD List</h1>

<c:if test="${cookie.firstNameCookie.value != null}">
    <p>Welcome back, <c:out value='${cookie.firstNameCookie.value}'/></p>
</c:if>

<ul>
    <li><a href="download?action=checkUser&productCode=8601">86 - True Life Songs</a></li>
    <li><a href="download?action=checkUser&productCode=pf01">Paddlefoot - The First CD</a></li>
    <li><a href="download?action=checkUser&productCode=pf02">Paddlefoot - The Second CD</a></li>
    <li><a href="download?action=checkUser&productCode=jr01">Joe Rut - Genuine Wood</a></li>
</ul>

<p><a href="view_cookies.jsp">View Cookies</a></p>
