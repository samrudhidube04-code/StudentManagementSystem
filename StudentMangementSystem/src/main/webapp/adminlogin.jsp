<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login | Student Management System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center vh-100">

<div class="card shadow p-4" style="width: 100%; max-width: 400px;">
    <h3 class="text-center text-primary mb-4">
        <i class="bi bi-person-circle me-2"></i>Admin Login
    </h3>

    <form action="AdminLoginServlet" method="post">
        <div class="mb-3">
            <input type="text" name="username" class="form-control" placeholder="Enter Username" required>
        </div>
        <div class="mb-3">
            <input type="password" name="password" class="form-control" placeholder="Enter Password" required>
        </div>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary fw-bold">Login</button>
        </div>
    </form>
</div>

</body>
</html>
