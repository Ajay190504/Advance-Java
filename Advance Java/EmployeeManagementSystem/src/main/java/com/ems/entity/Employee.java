package com.ems.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private double salary;
    private String gender;

    private LocalDate dateOfJoining;

    private String city;
    private String state;
    private String country;

    // Default constructor (required by Hibernate)
    public Employee() {}

    // Parameterized constructor
    public Employee(String firstName, String lastName, String email, String phone,
            String department, String designation, double salary,
            String gender, LocalDate date,
            String city, String state, String country) {

this.firstName = firstName;
this.lastName = lastName;
this.email = email;
this.phone = phone;
this.department = department;
this.designation = designation;
this.salary = salary;
this.gender = gender;
this.dateOfJoining = date;
this.city = city;
this.state = state;
this.country = country;
}

    // Getters & Setters

    public int getId() { return id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(LocalDate dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Name=" + firstName + " " + lastName +
                ", Email=" + email +
                ", Phone=" + phone +
                ", Dept=" + department +
                ", Designation=" + designation +
                ", Salary=" + salary +
                ", Gender=" + gender +
                ", DOJ=" + dateOfJoining +
                ", Location=" + city + ", " + state + ", " + country;
    }
}