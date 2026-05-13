package com.dao;

import java.sql.*;

import com.model.User;
import com.util.DBConnection;

public class UserDAO {

    // 🔹 REGISTER
    public boolean register(User u) {

        // Optional pre-check (fast fail)
        if (emailExists(u.getEmail())) {
            System.out.println("Email already exists: " + u.getEmail());
            return false;
        }

        String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword()); 

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error registering user");
            e.printStackTrace();
        }

        return false;
    }

    // 🔹 LOGIN
    public User login(String email, String password) {

        String sql = "SELECT id, name, email FROM users WHERE email=? AND password=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapUser(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error during login");
            e.printStackTrace();
        }

        return null;
    }

    // 🔹 CHECK EMAIL EXISTS
    public boolean emailExists(String email) {

        String sql = "SELECT id FROM users WHERE email=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Error checking email existence");
            e.printStackTrace();
        }

        return false;
    }

    // 🔹 COMMON MAPPER
    private User mapUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setEmail(rs.getString("email"));
        return u;
    }
}