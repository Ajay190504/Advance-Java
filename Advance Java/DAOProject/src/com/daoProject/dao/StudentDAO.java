package com.daoProject.dao;

import com.daoProject.model.Student;
import java.util.List;

public interface StudentDAO {

    // Insert a new student record
    boolean insert(Student student);

    // Update existing student details
    boolean update(Student student);

    // Delete student by ID
    boolean delete(int id);

    // Fetch a single student by ID
    Student getById(int id);

    // Fetch all student records
    List<Student> getAll();
}