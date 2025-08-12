package com.sms.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.sms.dao.StudentDao;
import com.sms.model.Student;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = StudentDao.getStudentById(id); // You must have this method

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateStudent.jsp");
        dispatcher.forward(request, response);
    }
}
