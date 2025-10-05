<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">User List</h2>

    <c:if test="${not empty message}">
        <div class="alert alert-info">${message}</div>
    </c:if>

    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th colspan="2">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td><a href="userAdmin?action=display_user&email=${user.email}" class="btn btn-info btn-sm">Update</a></td>
                <td><a href="userAdmin?action=delete_user&email=${user.email}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this user?')">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="add_user.jsp" class="btn btn-success">Add New User</a>
</div>
</body>
</html>
