package com.sms.controller;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.sms.model.Student;

@WebServlet("/UpcomingEventsServlet")
public class UpcomingEventsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> pendingAdmissions = new ArrayList<>();
        List<Student> upcomingFees = new ArrayList<>();
        List<Student> upcomingProjects = new ArrayList<>();
        List<Student> upcomingExams = new ArrayList<>();

        try {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");

            // Pending Admissions
            String sql1 = "SELECT * FROM students WHERE admission_deadline >= CURDATE() AND status='Pending'";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                pendingAdmissions.add(new Student(
                        rs1.getInt("id"),
                        rs1.getString("name"),
                        rs1.getString("roll"),
                        rs1.getString("dob"),
                        rs1.getString("email"),
                        rs1.getString("course")
                ));
            }

            // Upcoming Fees
            String sql2 = "SELECT * FROM students WHERE fee_due_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                upcomingFees.add(new Student(
                        rs2.getInt("id"),
                        rs2.getString("name"),
                        rs2.getString("roll"),
                        rs2.getString("dob"),
                        rs2.getString("email"),
                        rs2.getString("course")
                ));
            }

            // Upcoming Projects
            String sql3 = "SELECT * FROM students WHERE project_submission_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)";
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                upcomingProjects.add(new Student(
                        rs3.getInt("id"),
                        rs3.getString("name"),
                        rs3.getString("roll"),
                        rs3.getString("dob"),
                        rs3.getString("email"),
                        rs3.getString("course")
                ));
            }

            // Upcoming Exams
            String sql4 = "SELECT * FROM students WHERE exam_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)";
            PreparedStatement ps4 = con.prepareStatement(sql4);
            ResultSet rs4 = ps4.executeQuery();
            while (rs4.next()) {
                upcomingExams.add(new Student(
                        rs4.getInt("id"),
                        rs4.getString("name"),
                        rs4.getString("roll"),
                        rs4.getString("dob"),
                        rs4.getString("email"),
                        rs4.getString("course")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("pendingAdmissions", pendingAdmissions);
        request.setAttribute("upcomingFees", upcomingFees);
        request.setAttribute("upcomingProjects", upcomingProjects);
        request.setAttribute("upcomingExams", upcomingExams);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}
