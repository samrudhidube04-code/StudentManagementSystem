package com.sms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sms.dao.StudentDao; // your existing DAO
import com.sms.model.Student;  // your Student model

@WebServlet("/RecentNotificationservlet")
public class RecentNotificationservlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch the latest 5 students (you can change number)
        List<Student> recentStudents = StudentDao.getRecentStudents(5);

        // Store in request scope
        request.setAttribute("recentStudents", recentStudents);

        // Forward to admin dashboard JSP
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}
