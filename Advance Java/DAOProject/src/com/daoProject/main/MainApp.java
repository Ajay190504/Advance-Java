package com.daoProject.main;

import com.daoProject.controller.StudentController;
import com.daoProject.model.Student;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
			StudentController controller = new StudentController();

			while (true) {
			    System.out.println("\n1. Insert");
			    System.out.println("2. Update");
			    System.out.println("3. Delete");
			    System.out.println("4. Get By ID");
			    System.out.println("5. Get All");
			    System.out.println("6. Exit");

			    int choice = sc.nextInt();

			    try {
			        switch (choice) {

			            case 1:
			                System.out.println("Enter id, name, age, city:");
			                Student s1 = new Student(
			                        sc.nextInt(),
			                        sc.next(),
			                        sc.nextInt(),
			                        sc.next()
			                );
			                System.out.println(controller.add(s1) ? "Inserted successfully" : "Insert failed");
			                break;

			            case 2:
			                System.out.println("Enter id, name, age, city:");
			                Student s2 = new Student(
			                        sc.nextInt(),
			                        sc.next(),
			                        sc.nextInt(),
			                        sc.next()
			                );
			                System.out.println(controller.update(s2) ? "Updated successfully" : "Update failed");
			                break;

			            case 3:
			                System.out.println("Enter id:");
			                System.out.println(controller.delete(sc.nextInt()) ? "Deleted successfully" : "Delete failed");
			                break;

			            case 4:
			                System.out.println("Enter id:");
			                Student s = controller.getOne(sc.nextInt());
			                System.out.println(s != null ? s : "Not Found");
			                break;

			            case 5:
			                List<Student> list = controller.getAll();
			                if (list.isEmpty()) {
			                    System.out.println("No records found");
			                } else {
			                    list.forEach(System.out::println);
			                }
			                break;

			            case 6:
			                System.out.println("Exiting...");
			                System.exit(0);

			            default:
			                System.out.println("Invalid choice");
			        }

			    } catch (Exception e) {
			        System.out.println("Error: " + e.getMessage());
			    }
			}
		}
    }
}