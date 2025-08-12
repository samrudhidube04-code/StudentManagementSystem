package com.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sms.model.Student;
import com.sms.dao.StudentDao;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student s = new Student(id, name, roll, dob, email, course);
        StudentDao.updateStudent(s);

        response.sendRedirect("ViewStudentServlet");
    }

    // Optional: Prevent 405 error if someone sends a GET request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("ViewStudentServlet"); // or show update form
    }
}
