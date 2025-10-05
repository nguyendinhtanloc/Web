<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h2>Download registration</h2>
<p>To register for our downloads, enter your name and email address below. Then, click on the Submit button.</p>

<form action="download" method="post">
    <input type="hidden" name="action" value="registerUser">        
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="<c:out value='${user.email}'/>" required><br>
    <label class="pad_top">First Name:</label>
    <input type="text" name="firstName" value="<c:out value='${user.firstName}'/>" required><br>
    <label class="pad_top">Last Name:</label>
    <input type="text" name="lastName" value="<c:out value='${user.lastName}'/>" required><br>        
    <label>&nbsp;</label>
    <input type="submit" value="Register" class="margin_left">
</form>

<jsp:include page="footer.jsp"/>
