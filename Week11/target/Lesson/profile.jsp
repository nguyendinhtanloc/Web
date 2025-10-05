<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Xin chào, ${sessionScope.loggedInAccount.firstName}!</h2>
        <a href="logout" class="btn btn-outline-danger">Đăng xuất</a>
    </div>
    <div class="card">
        <div class="card-header"><h3>Thông tin tài khoản</h3></div>
        <div class="card-body">
            <p><strong>Họ và tên:</strong> ${sessionScope.loggedInAccount.firstName} ${sessionScope.loggedInAccount.lastName}</p>
            <p><strong>Email:</strong> ${sessionScope.loggedInAccount.email}</p>
        </div>
    </div>
</div>
</body>
</html>
