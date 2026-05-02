package com.ems.main;

import com.ems.dao.EmployeeDAO;
import com.ems.entity.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
			EmployeeDAO dao = new EmployeeDAO();

			while (true) {

			    System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
			    System.out.println("1. Add Employee");
			    System.out.println("2. Get Employee By ID");
			    System.out.println("3. Get All Employees");
			    System.out.println("4. Update Salary");
			    System.out.println("5. Delete Employee");
			    System.out.println("6. Search By Department");
			    System.out.println("7. Exit");

			    int choice = sc.nextInt();
			    sc.nextLine(); // clear buffer

			    switch (choice) {

			        case 1:
			            System.out.print("First Name: ");
			            String fn = sc.nextLine();

			            System.out.print("Last Name: ");
			            String ln = sc.nextLine();

			            System.out.print("Email: ");
			            String email = sc.nextLine();

			            System.out.print("Phone: ");
			            String phone = sc.nextLine();

			            System.out.print("Department: ");
			            String dept = sc.nextLine();

			            System.out.print("Designation: ");
			            String desig = sc.nextLine();

			            System.out.print("Salary: ");
			            double sal = sc.nextDouble();
			            sc.nextLine();

			            System.out.print("Gender: ");
			            String gender = sc.nextLine();

			            System.out.print("Date of Joining (yyyy-MM-dd): ");
			            String dojStr = sc.nextLine();

			            // Convert String → LocalDate
			            LocalDate doj = LocalDate.parse(dojStr);

			            System.out.print("City: ");
			            String city = sc.nextLine();

			            System.out.print("State: ");
			            String state = sc.nextLine();

			            System.out.print("Country: ");
			            String country = sc.nextLine();

			            Employee emp = new Employee(
			                    fn, ln, email, phone, dept,
			                    desig, sal, gender, doj,
			                    city, state, country
			            );

			            dao.insert(emp);
			            System.out.println("Employee Added!");
			            break;

			        case 2:
			            System.out.print("Enter ID: ");
			            int id = sc.nextInt();

			            System.out.println(dao.getById(id));
			            break;

			        case 3:
			            List<Employee> list = dao.getAll();
			            list.forEach(System.out::println);
			            break;

			        case 4:
			            System.out.print("Enter ID: ");
			            int uid = sc.nextInt();

			            System.out.print("New Salary: ");
			            double newSal = sc.nextDouble();

			            dao.updateSalary(uid, newSal);
			            System.out.println("Updated!");
			            break;

			        case 5:
			            System.out.print("Enter ID: ");
			            int did = sc.nextInt();

			            dao.delete(did);
			            System.out.println("Deleted!");
			            break;

			        case 6:
			            System.out.print("Enter Department: ");
			            String d = sc.next();

			            List<Employee> deptList = dao.getByDepartment(d);
			            deptList.forEach(System.out::println);
			            break;

			        case 7:
			            System.exit(0);
			    }
			}
		}
    }
}