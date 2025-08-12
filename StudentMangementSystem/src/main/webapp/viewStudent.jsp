<%@ page import="java.util.*, com.sms.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="d-flex">
    <jsp:include page="sidebar.jsp" />

<div class="container mt-5">
    <h3 class="mb-4">View All Students</h3>

    <%
        List<Student> list = (List<Student>) request.getAttribute("studentList");
        if (list != null && !list.isEmpty()) {
    %>

    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Roll</th>
                <th>DOB</th>
                <th>Email</th>
                <th>Course</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for (Student s : list) { %>
                <tr>
                    <td><%= s.getId() %></td>
                    <td><%= s.getName() %></td>
                    <td><%= s.getRoll() %></td>
                    <td><%= s.getDob() %></td>
                    <td><%= s.getEmail() %></td>
                    <td><%= s.getCourse() %></td>
                    <td>
                    <a href="EditStudentServlet?id=<%= s.getId() %>" class="btn btn-sm btn-success me-1">Update</a>
                    <a href="DeleteStudentServlet?id=<%= s.getId() %>" class="btn btn-sm btn-danger"
                       onclick="return confirm('Are you sure to delete this student?');">Delete</a>
                </td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <%
        } else {
    %>
        <p class="text-muted">No student records found.</p>
    <%
        }
    %>
</div>
</div>

</body>
</html>
