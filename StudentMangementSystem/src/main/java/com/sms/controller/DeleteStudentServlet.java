package com.sms.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.sms.dao.StudentDao;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        
        StudentDao dao = new StudentDao();
        boolean success = dao.deleteStudent(id);
        
        if (success) {
            response.sendRedirect("viewStudent.jsp");
        } else {
            response.sendRedirect("error.jsp"); // Optional: create error.jsp
        }
    }
}
