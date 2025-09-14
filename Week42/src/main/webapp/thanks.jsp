<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.jsp" %>

<h1>Thanks for joining our email list</h1>

<p>Here is the information that you entered:</p>
<label>Email:</label>
<span>${user.email}</span><br>
<label>First name:</label>
<span>${user.firstName}</span><br>
<label>Last name:</label>
<span>${user.lastName}</span><br>
<label>Heard from:</label>
<span>${user.heardFrom}</span><br>
<label>Updates:</label>
<span>${user.updates}</span><br>
<label>Contact Via:</label>
<span>${user.contactVia}</span><br>

<p>To enter another email address, click on the Back 
button in your browser or the Return button shown 
below.</p>

<form action="survey" method="post">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>

<%@ include file="/includes/footer.jsp" %>
