package com.daoProject.service;

import com.daoProject.dao.StudentDAO;
import com.daoProject.dao.StudentDAOImpl;
import com.daoProject.model.Student;

import java.util.List;

public class StudentService {

    private StudentDAO dao;

    public StudentService() {
        this.dao = new StudentDAOImpl();
    }

    public boolean addStudent(Student s) {
        validate(s);
        return dao.insert(s);
    }

    public boolean updateStudent(Student s) {
        validate(s);
        return dao.update(s);
    }

    public boolean deleteStudent(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return dao.delete(id);
    }

    public Student getStudent(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return dao.getById(id);
    }

    public List<Student> getAllStudents() {
        return dao.getAll();
    }

    // Centralized validation
    private void validate(Student s) {

        if (s == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (s.getId() <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if (s.getName() == null || s.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (s.getAge() < 5 || s.getAge() > 100) {
            throw new IllegalArgumentException("Invalid Age");
        }
    }
}