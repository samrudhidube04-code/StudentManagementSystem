package com.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sms.dao.StudentDao;
import com.sms.model.Student;

@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Student> studentList = StudentDao.getAllStudents();
        
        System.out.println("Fetched student count: " + studentList.size()); // Debugging

        request.setAttribute("studentList", studentList);
        RequestDispatcher rd = request.getRequestDispatcher("viewStudent.jsp");
        rd.forward(request, response);
    }
}
