<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Add New User</h2>
    <form action="userAdmin" method="post">
        <input type="hidden" name="action" value="add_user">
        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>First Name</label>
            <input type="text" name="firstName" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Last Name</label>
            <input type="text" name="lastName" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Add User</button>
        <a href="userAdmin" class="btn btn-secondary">Back</a>
    </form>
</div>
</body>
</html>
