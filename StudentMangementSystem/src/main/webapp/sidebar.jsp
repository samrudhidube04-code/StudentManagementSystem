<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<div class="bg-dark text-white p-3" style="width: 250px; min-height: 100vh;">
    <h4 class="mb-4 text-center"><i class="bi bi-person-gear me-2"></i>Admin Panel</h4>
    <ul class="nav flex-column">
        <li class="nav-item mb-2">
            <a class="nav-link text-white" href="addStudent.jsp"><i class="bi bi-person-plus me-2"></i>Add Student</a>
        </li>
        <li class="nav-item mb-2">
            <a class="nav-link text-white" href="ViewStudentServlet"><i class="bi bi-list-columns-reverse me-2"></i>View Students</a>
        </li>
         
        
        <li class="nav-item mt-4">
            <a class="nav-link text-danger" href="logout.jsp"><i class="bi bi-box-arrow-left me-2"></i>Logout</a>
        </li>
    </ul>
</div>
