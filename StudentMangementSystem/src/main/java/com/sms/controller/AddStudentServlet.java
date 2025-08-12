package com.sms.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sms.dao.StudentDao;
import com.sms.model.Student;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get form data from request
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        // 2. Create Student object (ID not needed as it's auto-generated)
        Student student = new Student();
        student.setName(name);
        student.setRoll(roll);
        student.setDob(dob);
        student.setEmail(email);
        student.setCourse(course);

        // 3. Save to DB
        boolean status = StudentDao.addStudent(student);

        // 4. Redirect or Show result
        if (status) {
            response.sendRedirect("index.jsp"); // 
        } else {
            response.getWriter().println("Failed to add student.");
        }
    }
}
