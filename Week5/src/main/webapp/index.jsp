<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="includes/header.jsp" %>

        <h1>Join our email list</h1>
        <p>To join our email list, enter your name and email address below.</p>

        <form action="emailList" method="post">
            <input type="hidden" name="action" value="add">

            <label>Email:</label>
            <input type="email" name="email" value="${sessionScope.user.email}"><br>

            <label>First Name:</label>
            <input type="text" name="firstName" value="${sessionScope.user.firstName}"><br>

            <label>Last Name:</label>
            <input type="text" name="lastName" value="${sessionScope.user.lastName}"><br>

            <label class="pad_top">Heard from:</label>
            <select name="heardFrom">
                <option value="">--Select--</option>
                <option value="Search Engine" ${user.heardFrom=='Search Engine' ? 'selected' : '' }>Search Engine
                </option>
                <option value="Friend" ${user.heardFrom=='Friend' ? 'selected' : '' }>Friend</option>
                <option value="Other" ${user.heardFrom=='Other' ? 'selected' : '' }>Other</option>
            </select><br>

            <label class="pad_top">Updates:</label>
            <input type="checkbox" name="updates" value="Yes" <c:if test="${user.updates == 'Yes'}">checked</c:if> >
            Yes<br>

            <label class="pad_top">Contact Via:</label>
            <input type="radio" name="contactVia" value="Email" <c:if test="${user.contactVia == 'Email'}">checked
            </c:if> > Email
            <input type="radio" name="contactVia" value="Postal Mail" <c:if
                test="${user.contactVia == 'Postal Mail'}">checked</c:if> > Postal Mail<br>

            <label>&nbsp;</label>
            <input type="submit" value="Join Now" class="margin_left">
        </form>

        <%@ include file="includes/footer.jsp" %>