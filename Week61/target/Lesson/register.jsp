<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Download registration</h1>

<form action="download" method="post">
    <input type="hidden" name="action" value="registerUser">

    <label>Email:</label>
    <input type="email" name="email" value="<c:out value='${user.email}'/>"><br>

    <label>First Name:</label>
    <input type="text" name="firstName" value="<c:out value='${user.firstName}'/>"><br>

    <label>Last Name:</label>
    <input type="text" name="lastName" value="<c:out value='${user.lastName}'/>"><br>

    <label>Heard From:</label>
    <input type="text" name="heardFrom" value="<c:out value='${user.heardFrom}'/>"><br>

    <label>Updates:</label>
    <input type="text" name="updates" value="<c:out value='${user.updates}'/>"><br>

    <label>Contact Via:</label>
    <input type="text" name="contactVia" value="<c:out value='${user.contactVia}'/>"><br>

    <input type="submit" value="Register">
</form>
