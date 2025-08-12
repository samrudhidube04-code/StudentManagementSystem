<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.sms.dao.StudentDao" %>
<%@ page import="com.sms.model.Student" %>
<%
    String idStr = request.getParameter("id");
    int id = Integer.parseInt(idStr);
    StudentDao dao = new StudentDao();
    Student student = dao.getStudentById(id);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2>Confirm Deletion</h2>
    <p>Are you sure you want to delete the following student?</p>
    
    <table class="table table-bordered w-50">
        <tr><th>ID</th><td><%= student.getId() %></td></tr>
        <tr><th>Name</th><td><%= student.getName() %></td></tr>
        <tr><th>Roll</th><td><%= student.getRoll() %></td></tr>
        <tr><th>DOB</th><td><%= student.getDob() %></td></tr>
        <tr><th>Email</th><td><%= student.getEmail() %></td></tr>
        <tr><th>Course</th><td><%= student.getCourse() %></td></tr>
    </table>

    <form action="DeleteStudentServlet" method="post">
        <input type="hidden" name="id" value="<%= student.getId() %>">
        <button type="submit" class="btn btn-danger">Delete</button>
        <a href="viewStudents.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</body>
</html>
