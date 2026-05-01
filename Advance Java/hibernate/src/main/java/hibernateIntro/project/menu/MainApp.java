package hibernateIntro.project.menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import hibernateIntro.project.dao.UsersDAO;
import hibernateIntro.project.entity.Users;

public class MainApp {

    public static void main(String[] args) {

        UsersDAO dao = new UsersDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n===== USER CRUD USING HIBERNATE =====");
                System.out.println("1. Insert User");
                System.out.println("2. Get User By ID");
                System.out.println("3. Get All Users");
                System.out.println("4. Update User");
                System.out.println("5. Delete User");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1: {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        System.out.print("Enter Name: ");
                        String name = sc.next();

                        System.out.print("Enter Email: ");
                        String email = sc.next();

                        System.out.print("Enter City: ");
                        String city = sc.next();

                        Users user = new Users(id, name, email, city);

                        if (dao.insert(user)) {
                            System.out.println("User inserted successfully.");
                        }

                        break;
                    }

                    case 2: {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        Users user = dao.getById(id);

                        if (user != null) {
                            System.out.println(user);
                        }

                        break;
                    }

                    case 3: {
                        List<Users> users = dao.getAll();

                        if (users.isEmpty()) {
                            System.out.println("No users found.");
                        } else {
                            users.forEach(System.out::println);
                        }

                        break;
                    }

                    case 4: {
                        System.out.print("Enter ID to update: ");
                        int id = sc.nextInt();

                        System.out.print("Enter New Name: ");
                        String name = sc.next();

                        System.out.print("Enter New Email: ");
                        String email = sc.next();

                        System.out.print("Enter New City: ");
                        String city = sc.next();

                        Users user = new Users(id, name, email, city);

                        if (dao.update(user)) {
                            System.out.println("User updated successfully.");
                        }

                        break;
                    }

                    case 5: {
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();

                        if (dao.delete(id)) {
                            System.out.println("User deleted successfully.");
                        }

                        break;
                    }

                    case 6: {
                        System.out.println("Application closed.");
                        sc.close();
                        return;
                    }

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers where required.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}