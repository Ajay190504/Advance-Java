package com.dao;

import java.sql.*;
import java.util.*;

import com.model.Task;
import com.util.DBConnection;

public class TaskDAO {

    // CREATE
    public boolean addTask(Task t) {
        String sql = "INSERT INTO tasks(title, description, user_id) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setInt(3, t.getUserId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding task");
            e.printStackTrace();
        }
        return false;
    }

    // READ (User-specific)
    public List<Task> getTasksByUser(int userId) {
        List<Task> list = new ArrayList<>();

        String sql = "SELECT id, title, description, user_id FROM tasks WHERE user_id=? ORDER BY id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching tasks");
            e.printStackTrace();
        }

        return list;
    }

    // READ SINGLE TASK
    public Task getTaskById(int id, int userId) {
        String sql = "SELECT id, title, description, user_id FROM tasks WHERE id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, userId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching task by id");
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public boolean updateTask(Task t) {
        String sql = "UPDATE tasks SET title=?, description=? WHERE id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setInt(3, t.getId());
            ps.setInt(4, t.getUserId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating task");
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public boolean deleteTask(int id, int userId) {
        String sql = "DELETE FROM tasks WHERE id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, userId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting task");
            e.printStackTrace();
        }

        return false;
    }

    // 🔹 COMMON MAPPER (DRY principle)
    private Task mapRow(ResultSet rs) throws SQLException {
        Task t = new Task();
        t.setId(rs.getInt("id"));
        t.setTitle(rs.getString("title"));
        t.setDescription(rs.getString("description"));
        t.setUserId(rs.getInt("user_id"));
        return t;
    }
}