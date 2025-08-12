<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sms.model.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>

<div class="d-flex">
    <jsp:include page="sidebar.jsp" />

    <!-- Main Content -->
    <div class="flex-grow-1 p-4 bg-light">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <div>
                <h2 class="text-primary">Welcome, Admin 👋</h2>
                <p class="lead text-muted">Today is <%= new java.util.Date() %></p>
            </div>
          <!--   <div>
                <a href="AddStudent.jsp" class="btn btn-success me-2"><i class="bi bi-plus-circle me-1"></i> Add Student</a>
                <a href="ListStudentServlet" class="btn btn-primary"><i class="bi bi-list-task me-1"></i> View Students</a>
                <a href="AddStudent.jsp" class="btn btn-success me-2"><i class="bi bi-plus-circle me-1"></i>Update Student </a>
                <a href="AddStudent.jsp" class="btn btn-success me-2"><i class="bi bi-plus-circle me-1"></i> Delete Student</a>
                
            </div> -->
        </div> 

        <!-- Dashboard Cards -->
        <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
    <div class="card-header">Total Students</div>
    <div class="card-body">
      
       <h5 class="card-title">${totalStudents}</h5>
       
        <p class="card-text">Number of students currently in the system.</p>
    </div>
</div>
        

        <!-- Notifications -->
        <div class="card shadow-sm border-0">
            <div class="card-header bg-info text-white">
                Recent Students Added
            </div>
            <div class="card-body">
                <ul class="list-group list-group-flush">
                     <%
                     List<String> recentStudents = (List<String>) request.getAttribute("recentStudents");
                           if (recentStudents != null && !recentStudents.isEmpty()) {
                             for (String name : recentStudents) {
                        %>
                     <li class="list-group-item">
                      <strong><%= name %></strong> was recently added.
                      </li>
                     <%
                          }
                        } else {
                      %>
                   <li class="list-group-item text-muted">No recent activity</li>
              <%
               }
               %>
                     
                </ul>
            </div>
        </div>
    </div>
        
        
        

    </div>
</div>
</div>

</body>
</html>
