<%@ include file="/includes/header.html" %>

    <h1>Thanks for joining our email list</h1>
    <p>Here is the information that you entered:</p>

        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>First Name:</label>
        <span>${user.firstName}</span><br>
        <label>Last Name:</label>
        <span>${user.lastName}</span><br>
        <label>Date of Birth:</label>
        <span>${user.dob}</span><br>

        <p>To enter another email address, click on the Back button in your browser or the Return button below.</p>
        <form action="emailList" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return" id="submit">
        </form>

        <%@ include file="/includes/footer.jsp" %>