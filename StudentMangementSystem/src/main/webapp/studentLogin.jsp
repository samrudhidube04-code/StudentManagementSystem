<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Login | Student Management System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center vh-100">

<div class="card shadow p-4" style="width: 100%; max-width: 400px;">
    <h3 class="text-center text-success mb-4">
        <i class="bi bi-mortarboard-fill me-2"></i>Student Login
    </h3>

    <form action="StudentLoginServlet" method="post">
        <div class="mb-3">
            <input type="text" name="roll" class="form-control" placeholder="Enter Roll Number" required>
        </div>
        <div class="mb-3">
            <input type="date" name="dob" class="form-control" placeholder="Enter DOB" required>
        </div>
        <div class="d-grid">
            <button type="submit" class="btn btn-success fw-bold">Login</button>
        </div>
    </form>
</div>

</body>
</html>
