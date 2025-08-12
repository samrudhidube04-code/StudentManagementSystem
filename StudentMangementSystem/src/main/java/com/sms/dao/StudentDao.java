package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sms.model.Student;
import com.sms.util.DBConnection;

public class StudentDao {

    // 1. Student Login
    public static Student authenticate(String roll, String dob) {
        Student student = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE roll=? AND dob=?");
            ps.setString(1, roll);
            ps.setString(2, dob);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setRoll(rs.getString("roll"));
                student.setDob(rs.getString("dob"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // 2. Add Student
    public static boolean addStudent(Student s) {
        boolean status = false;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO students (name, roll, dob, email, course) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getRoll());
            ps.setString(3, s.getDob());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getCourse());

            int rows = ps.executeUpdate();
            status = rows > 0;

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
   

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setRoll(rs.getString("roll"));
                s.setDob(rs.getString("dob"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                students.add(s);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public static void updateStudent(Student student) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE students SET name=?, roll=?, dob=?, email=?, course=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getRoll());
            ps.setString(3, student.getDob());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getCourse());
            ps.setInt(6, student.getId());

            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteStudent(int id) {
        boolean result = false;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            result = rows > 0;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Student getStudentById(int id) {
        Student s = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("roll"),
                    rs.getString("dob"),
                    rs.getString("email"),
                    rs.getString("course")
                );
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

 
    public int getTotalStudents() {
        int count = 0;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM students");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public static List<Student> getRecentStudents(int limit) {
        List<Student> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection(); // your connection method
            PreparedStatement ps = con.prepareStatement(
                "SELECT id, name FROM students ORDER BY id DESC LIMIT ?"
            );
            ps.setInt(1, limit);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



}


