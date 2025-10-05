<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>SQL Gateway</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>SQL Gateway</h2>

    <form action="sqlGateway" method="post">
        <div class="mb-3">
            <label for="sqlStatement" class="form-label">SQL Statement</label>
            <textarea id="sqlStatement" name="sqlStatement" class="form-control" rows="6"
                      placeholder="Chỉ cho phép SELECT, INSERT, UPDATE, DELETE">${sqlStatement}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Thực thi</button>
    </form>

    <c:if test="${not empty sqlResult}">
        <div class="mt-4">
            <h5>Kết quả:</h5>
            <div class="table-responsive border p-3 bg-light">${sqlResult}</div>
        </div>
    </c:if>
</div>
</body>
</html>
