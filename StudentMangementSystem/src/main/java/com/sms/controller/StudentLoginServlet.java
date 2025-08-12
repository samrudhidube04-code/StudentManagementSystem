package com.sms.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.sms.dao.StudentDao;
import com.sms.model.Student;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        String roll = request.getParameter("roll");
        String dob = request.getParameter("dob");

        Student student = StudentDao.authenticate(roll, dob);
        
        if (student != null) {
            HttpSession session = request.getSession();
            session.setAttribute("student", student);
            response.sendRedirect("studentHome.jsp");
        } else {
            response.sendRedirect("StudentLogin.jsp?error=1");
        }
    }
}
