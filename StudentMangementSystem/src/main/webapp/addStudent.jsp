<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="d-flex">
    <jsp:include page="sidebar.jsp" />


<div class="container mt-5">
    <h2 class="mb-4 text-center text-primary">Add Student</h2>
    <form action="AddStudentServlet" method="post" class="col-md-6 offset-md-3">

        <div class="mb-3">
            <label for="name" class="form-label">Full Name</label>
            <input type="text" class="form-control" name="name" id="name" required>
        </div>

        <div class="mb-3">
            <label for="roll" class="form-label">Roll Number</label>
            <input type="text" class="form-control" name="roll" id="roll" required>
        </div>

        <div class="mb-3">
            <label for="dob" class="form-label">Date of Birth</label>
            <input type="date" class="form-control" name="dob" id="dob" required>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email ID</label>
            <input type="email" class="form-control" name="email" id="email" required>
        </div>

        <div class="mb-3">
            <label for="course" class="form-label">Course</label>
            <input type="text" class="form-control" name="course" id="course" required>
        </div>

        <button type="submit" class="btn btn-success w-100">Add Student</button>
    </form>
</div>
</div>
</div>

</body>
</html>
