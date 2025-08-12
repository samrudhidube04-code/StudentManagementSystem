package com.sms.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Invalidate the session
        HttpSession session = request.getSession(false); // false → don't create a new session
        if (session != null) {
            session.invalidate();
        }

        // Redirect to login page
        response.sendRedirect("adminlogin.jsp");
    }
}
