package com.daoProject.controller;

import com.daoProject.model.Student;
import com.daoProject.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService service;

    public StudentController() {
        this.service = new StudentService();
    }

    public boolean add(Student s) {
        return service.addStudent(s);
    }

    public boolean update(Student s) {
        return service.updateStudent(s);
    }

    public boolean delete(int id) {
        return service.deleteStudent(id);
    }

    public Student getOne(int id) {
        return service.getStudent(id);
    }

    public List<Student> getAll() {
        return service.getAllStudents();
    }
}