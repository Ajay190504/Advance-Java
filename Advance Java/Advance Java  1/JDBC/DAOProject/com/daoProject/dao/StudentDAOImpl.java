package com.daoProject.dao;

import com.daoProject.model.Student;
import com.daoProject.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean insert(Student s) {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getCity());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Insert operation failed", e);
        }
    }

    @Override
    public boolean update(Student s) {
        String sql = "UPDATE students SET name=?, age=?, city=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCity());
            ps.setInt(4, s.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Update operation failed", e);
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Delete operation failed", e);
        }
    }

    @Override
    public Student getById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("city")
                    );
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Fetch by ID failed", e);
        }
    }

    @Override
    public List<Student> getAll() {
        String sql = "SELECT * FROM students";
        List<Student> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("city")
                ));
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException("Fetch all operation failed", e);
        }
    }
}