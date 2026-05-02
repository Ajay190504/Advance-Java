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
                System.out.println("4. Get Employees By City");
                System.out.println("5. Update Full Employee");
                System.out.println("6. Update Salary");
                System.out.println("7. Delete Employee");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1: {
                        Employee emp = readEmployee(sc, false);
                        dao.insert(emp);
                        break;
                    }

                    case 2: {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        Employee emp = dao.getById(id);

                        if (emp != null) {
                            System.out.println(emp);
                        } else {
                            System.out.println("Employee not found");
                        }

                        break;
                    }

                    case 3: {
                        List<Employee> list = dao.getAll();

                        if (list == null || list.isEmpty()) {
                            System.out.println("No employees found");
                        } else {
                            list.forEach(System.out::println);
                        }

                        break;
                    }

                    case 4: {
                        System.out.print("Enter City: ");
                        String city = sc.nextLine();

                        List<Employee> cityList = dao.getByCity(city);

                        if (cityList == null || cityList.isEmpty()) {
                            System.out.println("No employees found in this city");
                        } else {
                            cityList.forEach(System.out::println);
                        }

                        break;
                    }

                    case 5: {
                        Employee emp = readEmployee(sc, true);
                        dao.updateEmployee(emp);
                        break;
                    }

                    case 6: {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        System.out.print("Enter New Salary: ");
                        double salary = sc.nextDouble();

                        dao.updateSalary(id, salary);
                        break;
                    }

                    case 7: {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        dao.delete(id);
                        break;
                    }

                    case 8: {
                        System.out.println("Application closed");
                        return;
                    }

                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }

    // Reads employee details from user
    private static Employee readEmployee(Scanner sc, boolean includeId) {

        Employee emp = new Employee();

        if (includeId) {
            System.out.print("Enter ID: ");
            emp.setId(sc.nextInt());
            sc.nextLine();
        }

        System.out.print("First Name: ");
        emp.setFirstName(sc.nextLine());

        System.out.print("Last Name: ");
        emp.setLastName(sc.nextLine());

        System.out.print("Email: ");
        emp.setEmail(sc.nextLine());

        System.out.print("Phone: ");
        emp.setPhone(sc.nextLine());

        System.out.print("Department: ");
        emp.setDepartment(sc.nextLine());

        System.out.print("Designation: ");
        emp.setDesignation(sc.nextLine());

        System.out.print("Salary: ");
        emp.setSalary(sc.nextDouble());
        sc.nextLine();

        System.out.print("Gender: ");
        emp.setGender(sc.nextLine());

        System.out.print("Date of Joining (yyyy-MM-dd): ");
        emp.setDateOfJoining(LocalDate.parse(sc.nextLine()));

        System.out.print("City: ");
        emp.setCity(sc.nextLine());

        System.out.print("State: ");
        emp.setState(sc.nextLine());

        System.out.print("Country: ");
        emp.setCountry(sc.nextLine());

        return emp;
    }
}
