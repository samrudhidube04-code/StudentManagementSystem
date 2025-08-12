<%@ page import="com.sms.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
    if (student == null) {
        out.println("<p style='color:red;'>Student not found.</p>");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Update Student Details</h4>
        </div>
        <div class="card-body">
            <form action="UpdateStudentServlet" method="post">
                <input type="hidden" name="id" value="<%= student.getId() %>">

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" value="<%= student.getName() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Roll Number</label>
                    <input type="text" name="roll" class="form-control" value="<%= student.getRoll() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Date of Birth</label>
                    <input type="date" name="dob" class="form-control" value="<%= student.getDob() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" value="<%= student.getEmail() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Course</label>
                    <input type="text" name="course" class="form-control" value="<%= student.getCourse() %>" required>
                </div>

                <div class="d-flex justify-content-between">
                    <a href="ViewStudentServlet" class="btn btn-secondary">Cancel</a>
                    <button type="submit" class="btn btn-success">Update Student</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
