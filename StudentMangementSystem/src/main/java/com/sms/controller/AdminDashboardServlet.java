package com.sms.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sms.util.DBConnection; // Your DB connection utility

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> recentStudents = new ArrayList<>();
        int totalStudents = 0;

        try {
            Connection con = DBConnection.getConnection();

            // Get total students count
            PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) FROM students");
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                totalStudents = rs1.getInt(1);
            }
            rs1.close();
            ps1.close();

            // Get last 5 student names
            PreparedStatement ps2 = con.prepareStatement(
                "SELECT name FROM students ORDER BY id DESC LIMIT 5"
            );
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                recentStudents.add(rs2.getString("name"));
            }
            rs2.close();
            ps2.close();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        // Send data to JSP
        request.setAttribute("totalStudents", totalStudents);
        request.setAttribute("recentStudents", recentStudents);

        // Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("index"
        		+ ".jsp");
        rd.forward(request, response);
    }
}
