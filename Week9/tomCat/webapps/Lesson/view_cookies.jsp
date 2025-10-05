<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h2>Cookies</h2>
<p>Here's a table with all of the cookies that this browser is sending to the current server.</p>

<table>
  <tr>
    <th>Name</th>
    <th>Value</th>
  </tr>
  <c:forEach var="c" items="${cookie}">      
    <tr>
      <td><c:out value='${c.value.name}'/></td>
      <td><c:out value='${c.value.value}'/></td>
    </tr>
  </c:forEach>  
</table>

<jsp:include page="footer.jsp"/>
